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
               WHERE usuario_id = @UsuarioId",
               new { usuarioId }
            );
        }

        public async Task<IEnumerable<Categoria>> Obtener(int usuarioId, TipoOperacion tipoOperacionId)
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
               WHERE usuario_id = @UsuarioId AND tipo_operacion_id = @TipoOperacionId",
               new
               {
                   usuarioId,
                   tipoOperacionId
               }
            );
        }

        public async Task<Categoria> ObtenerPorId(int id, int usuarioId)
        {
            using var connection = new NpgsqlConnection(connectionString);
            return await connection.QueryFirstOrDefaultAsync<Categoria>
            (
                @"SELECT 
                    categoria_id AS CategoriaId, 
                    tipo_operacion_id AS TipoOperacionId, 
                    usuario_id AS UsuarioId,
                    nombre AS Nombre
                FROM categorias
                WHERE categoria_id = @Id AND usuario_id = @UsuarioId",
                new { id, usuarioId }
            );
        }

        public async Task Actualizar(Categoria categoria)
        {
            using var connection = new NpgsqlConnection(connectionString);
            await connection.ExecuteAsync(
                @"UPDATE categorias 
                SET nombre = @Nombre, tipo_operacion_id = @TipoOperacionId
                WHERE categoria_id = @CategoriaId",
                categoria
            );
        }

        public async Task Borrar(int categoriaId)
        {
            using var connection = new NpgsqlConnection(connectionString);
            await connection.ExecuteAsync(
                @"DELETE FROM categorias
                WHERE categoria_id = @CategoriaId",
                new { categoriaId }
            );
        }

    }
}