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
            /*
            using var connection = new NpgsqlConnection(connectionString);
            var categoriaId = await connection.QuerySingleAsync<int>
            (
                "transacciones_insertar",
                new {
                    transaccion.UsuarioId,
                    transaccion.FechaTransaccion,
                    transaccion.Monto,
                    transaccion.CategoriaId,
                    transaccion.CuentaId,
                    transaccion.Nota
                },
                commandType: System.Data.CommandType.StoredProcedure
            );
            transaccion.CategoriaId = categoriaId;
            */
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
        /*
        Se produjo una excepción de tipo 'Npgsql.PostgresException' en System.Private.CoreLib.dll pero 
        no se controló en el código del usuario: 
        '42883: no existe el procedimiento 
        «transacciones_actualizar
        (TransaccionId => integer, 
        FechaTransaccion => timestamp without time zone, 
        Monto => numeric, 
        CategoriaId => integer, 
        CuentaId => integer, 
        Nota => text, 
        montoAnterior => numeric, 
        cuentaAnteriorId => integer)»
        */


        public async Task Actualizar(Transaccion transaccion, decimal montoAnterior, int cuentaAnteriorId)
        {
            /*
            using var connection = new NpgsqlConnection(connectionString);
            await connection.ExecuteAsync
            (
                "transacciones_actualizar",
                new 
                {
                    transaccion.TransaccionId,
                    transaccion.FechaTransaccion,
                    transaccion.Monto,
                    montoAnterior,
                    transaccion.CuentaId,
                    cuentaAnteriorId,
                    transaccion.CategoriaId,
                    transaccion.Nota
                },
                commandType: System.Data.CommandType.StoredProcedure
            );
            */
            /*
            using (var conn = new NpgsqlConnection(connectionString))
            {
                conn.Open();
                using (var cmd = new NpgsqlCommand
                    (
                        @"SELECT * 
                        FROM transacciones_actualizar
                        (
                        @transaccion_id, 
                        @fecha_transaccion,
                        @monto,
                        @monto_anterior,
                        @cuenta_id,
                        @cuenta_anterior_id,
                        @categoria_id,
                        @nota
                        )", 
                        conn
                    )
                )
                {
                    cmd.Parameters.AddWithValue("transaccion_id", transaccion.TransaccionId);
                    cmd.Parameters.AddWithValue("fecha_transaccion", transaccion.FechaTransaccion);
                    cmd.Parameters.AddWithValue("monto", transaccion.Monto);
                    cmd.Parameters.AddWithValue("monto_anterior", montoAnterior);
                    cmd.Parameters.AddWithValue("cuenta_id", transaccion.CuentaId);
                    cmd.Parameters.AddWithValue("cuenta_anterior_id", cuentaAnteriorId);
                    cmd.Parameters.AddWithValue("categoria_id", transaccion.CategoriaId);
                    cmd.Parameters.AddWithValue("nota", transaccion.Nota);

                    cmd.ExecuteScalar();
                }
            }
            */
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