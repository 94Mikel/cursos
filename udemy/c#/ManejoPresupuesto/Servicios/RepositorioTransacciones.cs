using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Dapper;
using ManejoPresupuesto.Models;
using Npgsql;

namespace ManejoPresupuesto.Servicios
{
    public class RepositorioTransacciones : IRepositorioTransacciones
    {
        private readonly string connectionString;

        public RepositorioTransacciones(IConfiguration configuration)
        {
            this.connectionString = configuration.GetConnectionString("DefaultConnection");
        }

        public async Task Crear(Transaccion transaccion)
        {
            using (var conn = new NpgsqlConnection(connectionString))
            {
                conn.Open();
                //var fecha = ((DateTimeOffset)transaccion.FechaTransaccion).ToUnixTimeMilliseconds();
                using (var cmd = new NpgsqlCommand
                (
                    @"SELECT * 
                    FROM transacciones_insertar
                    (
                        @usuario_id,
                        @fecha_transaccion,
                        @monto,
                        @categoria_id,
                        @cuenta_id,
                        @nota
                    )"
                    , conn
                )
                )
                {
                    cmd.Parameters.AddWithValue("usuario_id", transaccion.UsuarioId);
                    cmd.Parameters.AddWithValue("fecha_transaccion", transaccion.FechaTransaccion);
                    cmd.Parameters.AddWithValue("monto", transaccion.Monto);
                    cmd.Parameters.AddWithValue("categoria_id", transaccion.CategoriaId);
                    cmd.Parameters.AddWithValue("cuenta_id", transaccion.CuentaId);
                    cmd.Parameters.AddWithValue("nota", transaccion.Nota);

                    object result = cmd.ExecuteScalar();
                    if (result != null && result != DBNull.Value)
                    {
                        int id = Convert.ToInt32(result);
                        Console.WriteLine($"El ID del categoria es: {id}");
                        transaccion.CategoriaId = id;
                    }
                    else
                    {
                        throw new ApplicationException("No se ha obtenido el id");
                    }
                }
            }
        }

        public async Task<IEnumerable<Transaccion>> ObtenerPorCuentaId(ObtenerTransaccionesPorCuenta modelo)
        {
            using var connection = new NpgsqlConnection(connectionString);
            return await connection.QueryAsync<Transaccion>
            (
                @"SELECT 
                    t.transaccion_id AS TransaccionId, 
                    t.monto AS Monto, 
                    t.fecha_transaccion AS FechaTransaccion, 
                    c.nombre AS Categoria,
                    cu.nombre AS Cuenta,
                    c.tipo_operacion_id AS TipoOperacionId
                FROM transacciones AS t
                INNER JOIN categorias AS c 
                USING (categoria_id)
                INNER JOIN cuentas cu
                USING (cuenta_id)
                WHERE t.cuenta_id = @CuentaId AND t.usuario_id = @UsuarioId
                AND t.fecha_transaccion BETWEEN @FechaInicio AND @FechaFin",
                modelo
            );
        }

        public async Task<IEnumerable<Transaccion>> ObtenerPorUsuarioId(ParametroObtenerTrasaccionesPorUsuario modelo)
        {
            using var connection = new NpgsqlConnection(connectionString);
            return await connection.QueryAsync<Transaccion>
            (
                @"SELECT 
                    t.transaccion_id AS TransaccionId, 
                    t.monto AS Monto, 
                    t.fecha_transaccion AS FechaTransaccion, 
                    c.nombre AS Categoria,
                    cu.nombre AS Cuenta,
                    c.tipo_operacion_id AS TipoOperacionId
                FROM transacciones AS t
                INNER JOIN categorias AS c 
                USING (categoria_id)
                INNER JOIN cuentas cu
                USING (cuenta_id)
                WHERE t.usuario_id = @UsuarioId
                AND t.fecha_transaccion BETWEEN @FechaInicio AND @FechaFin
                ORDER BY t.fecha_transaccion DESC",
                modelo
            );
        }

        public async Task Actualizar(Transaccion transaccion, decimal montoAnterior, int cuentaAnteriorId)
        {
            using var connection = new NpgsqlConnection(connectionString);

            try
            {
                await using var dataSource = NpgsqlDataSource.Create(connectionString);
                await using var cmd = dataSource.CreateCommand("CALL transacciones_actualizar($1,$2,$3,$4,$5,$6,$7,$8)");

                cmd.Parameters.AddWithValue(transaccion.TransaccionId);
                cmd.Parameters.AddWithValue(transaccion.FechaTransaccion);
                cmd.Parameters.AddWithValue(transaccion.Monto);
                cmd.Parameters.AddWithValue(montoAnterior);
                cmd.Parameters.AddWithValue(transaccion.CuentaId);
                cmd.Parameters.AddWithValue(cuentaAnteriorId);
                cmd.Parameters.AddWithValue(transaccion.CategoriaId);
                cmd.Parameters.AddWithValue(transaccion.Nota);

                await cmd.ExecuteNonQueryAsync();
            }
            catch (NpgsqlException ex)
            {
                Console.WriteLine($"Error: {ex.Message}");
            }
        }

        public async Task<Transaccion> ObtenerPorId(int TransaccionId, int UsuarioId)
        {
            using var connection = new NpgsqlConnection(connectionString);
            return await connection.QueryFirstOrDefaultAsync<Transaccion>
            (
                @"SELECT 
                tra.transaccion_id AS TransaccionId,
                tra.usuario_id AS UsuarioId ,
                tra.cuenta_id AS CuentaId,
                tra.categoria_id AS CategoriaId,
                tra.fecha_transaccion AS FechaTransaccion,
                tra.monto AS Monto,
                tra.nota AS Nota,
                cat.tipo_operacion_id 
                FROM transacciones AS tra INNER JOIN categorias AS cat 
                USING (categoria_id) 
                WHERE tra.transaccion_id = @TransaccionId AND tra.usuario_id = @UsuarioId",
                new { TransaccionId, UsuarioId }
            );
        }

        public async Task<IEnumerable<ResultadoObtenerPorSemana>> ObtenerPorSemana(
            ParametroObtenerTrasaccionesPorUsuario modelo
        )
        {
            using var connection = new NpgsqlConnection(connectionString);
            return await connection.QueryAsync<ResultadoObtenerPorSemana>(@"
                SELECT 
                    ROUND(EXTRACT(DAY FROM AGE(fecha_transaccion, @FechaInicio)) / 7 + 1) AS semana, 
                    SUM(t.monto) AS Monto, 
                    cat.tipo_operacion_id AS TipoOperacionId 
                FROM transacciones AS t 
                INNER JOIN categorias AS cat USING(categoria_id) 
                WHERE 
                    t.usuario_id = @UsuarioId AND 
                    t.fecha_transaccion 
                BETWEEN @FechaInicio AND @FechaFin 
                GROUP BY 
                    ROUND(EXTRACT(DAY FROM AGE(fecha_transaccion, '2025-03-01')) / 7 + 1), 
                    cat.tipo_operacion_id;
            ",modelo);
        }

        public async Task Borrar(int id)
        {
            using var connection = new NpgsqlConnection(connectionString);
            try
            {
                await using var dataSource = NpgsqlDataSource.Create(connectionString);
                await using var cmd = dataSource.CreateCommand("CALL transacciones_borrar($1)");

                cmd.Parameters.AddWithValue(id);
                await cmd.ExecuteNonQueryAsync();
            }
            catch (NpgsqlException ex)
            {
                Console.WriteLine($"Error: {ex.Message}");
            }
        }
    }
}