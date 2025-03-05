using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Dapper;
using ManejoPresupuesto.Models;
using Npgsql;

namespace ManejoPresupuesto.Servicios
{
    public class RepositorioCuentas : IRepositorioCuentas
    {
        private readonly string connectionString;

        public RepositorioCuentas(IConfiguration configuration)
        {
            connectionString = configuration.GetConnectionString("DefaultConnection");
        }

        public async Task Crear(Cuenta cuenta)
        {
            using var connection = new NpgsqlConnection(connectionString);
            var id = await connection.QuerySingleAsync<int>(
                @"INSERT INTO cuentas (nombre, tipo_cuenta_id, descripcion, balance)
                VALUES(@Nombre, @TipoCuentaId, @Descripcion, @Balance) RETURNING cuenta_id",
                cuenta
            );

            cuenta.cuentaId = id;
        }

        public async Task<IEnumerable<Cuenta>> Buscar(int usuarioId)
        {
            //NOTE: buscar cuenta
            /*
                TipoCuenta no es una propiedad de tipo cuenta. Lo cual añadimos atributo a Models => Cuenta.
            */
            using var connection = new NpgsqlConnection(connectionString);
            return await connection.QueryAsync<Cuenta>(
                @"SELECT c.cuenta_id, c.nombre, c.balance, tc.nombre AS TipoCuenta 
                FROM cuentas AS c 
                INNER JOIN tipos_cuentas AS tc using(tipo_cuenta_id)
                WHERE tc.usuario_id = @UsuarioId ORDER BY tc.orden;",
                new { usuarioId }
            );
        }
    }
}