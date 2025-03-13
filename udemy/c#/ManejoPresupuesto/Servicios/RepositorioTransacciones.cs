using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Dapper;
using ManejoPresupuesto.Models;
using Npgsql;

namespace ManejoPresupuesto.Servicios
{
    public class RepositorioTransacciones: IRepositorioTransacciones
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

        public async Task Actualizar(Transaccion transaccion, decimal montoAnterior, int cuentaAnteriorId)
        {
            using var connection = new NpgsqlConnection(connectionString);
            await connection.ExecuteAsync
            (
                "transacciones_actualizar",
                new 
                {
                    transaccion.TransaccionId,
                    transaccion.FechaTransaccion,
                    transaccion.Monto,
                    transaccion.CategoriaId,
                    transaccion.CuentaId,
                    transaccion.Nota,
                    montoAnterior,
                    cuentaAnteriorId
                },
                commandType: System.Data.CommandType.StoredProcedure
            );
        }

        public async Task<Transaccion> ObtenerPorId(int TransaccionId, int UsuarioId)
        {
            using var connection = new NpgsqlConnection(connectionString);
            return await connection.QueryFirstOrDefaultAsync<Transaccion>
            (
                @"SELECT tra.*, cat.tipo_operacion_id 
                FROM transacciones AS tra INNER JOIN categorias AS cat 
                USING (categoria_id) 
                WHERE tra.transaccion_id = @TransaccionId AND tra.usuario_id = @UsuarioId",
                new {TransaccionId, UsuarioId}
            );
        }
    }
}