using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Dapper;
using ManejoPresupuesto.Models;
using Npgsql;

namespace ManejoPresupuesto.Servicios
{
    public class RepositorioCategorias : IRepositorioCategorias
    {
        private readonly string connectionString;
        public RepositorioCategorias(IConfiguration configuration)
        {
            connectionString = configuration.GetConnectionString("DefaultConnection");
        }

        public async Task Crear(Categoria categoria)
        {
            using var connection = new NpgsqlConnection(connectionString);
            var id = await connection.QuerySingleAsync<int>
            (
                @"INSERT INTO categorias (nombre, tipo_operacion_id, usuario_id)
                VALUES(@Nombre, @TipoOperacionId, @UsuarioId) RETURNING categoria_id;",
                categoria
            );
            categoria.CategoriaId = id;
        }

        public async Task<IEnumerable<Categoria>> Obtener(int usuarioId)
        {
            using var connection = new NpgsqlConnection(connectionString);
            return await connection.QueryAsync<Categoria> 
            (
               @"SELECT 
                categoria_id AS CategoriaId, 
                tipo_operacion_id AS TipoOperacionId, 
                usuario_id AS UsuarioId,
                nombre AS Nombre
               FROM categorias
               WHERE usuario_id = @usuarioId",
               new {usuarioId} 
            );
        }
    }
}