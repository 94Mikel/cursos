using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Threading.Tasks;
using Dapper;
using ManejoPresupuesto.Models;
using Npgsql;

namespace ManejoPresupuesto.Servicios
{
    //NOTE: Inyección de dependencias
    /*
    Vamos a mantenernos utilizando el principio de inyeccion de dependencias.
    Nuestras clases deben de depender de abstracciones y no de tipos concretos.
    IConfiguration => para acceder al conection string
    */

    public class RepositorioTiposCuentas : IRepositorioTiposCuentas
    {
        private readonly string connectionString;
        public RepositorioTiposCuentas(IConfiguration configuration)
        {
            connectionString = configuration.GetConnectionString("DefaultConnection") ??
            throw new ApplicationException("Connection string is missing");
        }

        //NOTE: Programación asíncrona
        /*
            Metodo para crear un tipo cuenta en la base de datos.
            Marcamos como asincrona y retoran un datos de tipo Task(promesa)
            querySingle => para llamada sincronas
            querySingleAsync => para llamada asincronas
            tipos_cuentas_insertar => procedimiento almacenado
        */
        public async Task Crear(TipoCuenta tipoCuenta)
        {
            /*
                QuerySingle => para realizar querys que devuelva un solo resultado.
                despues de insertar queresmo extraer el id insertado.

                Hay que crear un objeto para enviar solo el nombre y el usuario_id al procedimiento.
                commandType => para indicar que utilizaremos un procedimiento almacenado.
            */
            using (var conn = new NpgsqlConnection(connectionString))
            {
                conn.Open();
                using (var cmd = new NpgsqlCommand("SELECT * FROM tipos_cuentas_insertar(@nombre, @usuario_id)", conn))
                {
                    cmd.Parameters.AddWithValue("usuario_id", tipoCuenta.UsuarioId);
                    cmd.Parameters.AddWithValue("nombre", tipoCuenta.Nombre);

                    object result = cmd.ExecuteScalar();
                    if (result != null && result != DBNull.Value)
                    {
                        int id = Convert.ToInt32(result);
                        Console.WriteLine($"El ID del usuario es: {id}");
                        tipoCuenta.Id = id;
                    }
                    else
                    {
                        throw new ApplicationException("No se ha obtenido el id");
                    }
                }
            }
        }

        // NOTE: Validación personalizada a nivel de controlador
        /*
            Metodo que nos permitira verificar si ya existe un tipo cuenta con el nombre indicado.
            con programación asincrona.
            bool => igual a boolean retornamos true o false.
            para eso comprobamos el nombre y el id de usuario. Ya que un usuario determinado no puede tener el mismo nombre de tipo_cuenta.
            QueryFirstOrDefaultAsync => El primer registro o un valor por defecto en caso en el que no exista dicho registro.
                <int> => porque quiero traer un numero entero. Valor por defecto 0
        */
        public async Task<bool> Existe(string nombre, int usuarioId)
        {
            using var connection = new NpgsqlConnection(connectionString);
            var existe = await connection.QueryFirstOrDefaultAsync<int>
            (
                @"SELECT 1 FROM tipos_cuentas WHERE nombre = @Nombre AND usuario_id = @usuarioId;",
                new { nombre, usuarioId }
            );

            return existe == 1;
        }
        // NOTE: Obtener listado de tipoCuenta desde la base de datos.
        /*
            Queremos el listado de tipoCuenta del usuario que esta utilizando la aplicacion.
            QueryAsync => permite realizar un select y devuelve un conjunto de resultados 
            y mappea ese conjunto de resultados a una clase(tipo de datos especifico).
        */
        public async Task<IEnumerable<TipoCuenta>> Obtener(int usuarioId)
        {
            using var connection = new NpgsqlConnection(connectionString);
            return await connection.QueryAsync<TipoCuenta>
            (
                @"SELECT id, nombre, orden 
                FROM tipos_cuentas 
                WHERE usuario_id = @usuarioId
                ORDER BY Orden",
                new { usuarioId }
            );
        }

        public async Task Actualizar(TipoCuenta tipoCuenta)
        {
            using var connection = new NpgsqlConnection(connectionString);
            await connection.ExecuteAsync(
                "UPDATE tipos_cuentas SET nombre = @Nombre WHERE id = @Id",
                tipoCuenta
                );
        }

        public async Task<TipoCuenta> ObtenerPorId(int id, int usuarioId)
        {
            using var connection = new NpgsqlConnection(connectionString);
            return await connection.QueryFirstOrDefaultAsync<TipoCuenta>(
                @"SELECT id, nombre, orden 
                FROM tipos_cuentas 
                WHERE id = @Id AND usuario_id = @UsuarioId",
                new { id, usuarioId }
            );
        }

        public async Task Borrar(int id)
        {
            using var connection = new NpgsqlConnection(connectionString);
            await connection.ExecuteAsync(
                "DELETE FROM tipos_cuentas WHERE id = @id",
                new { id }
            );
        }

        //NOTE: ordenar
        /*
            Ejecutara la query por cada tipoCuenta que se pase.
        */
        public async Task Ordenar(IEnumerable<TipoCuenta> tipoCuentasOrdenados)
        {
            var query = "UPDATE tipos_cuentas SET orden = @Orden WHERE id = @Id";
            using var connection = new NpgsqlConnection(connectionString);
            await connection.ExecuteAsync(query, tipoCuentasOrdenados);

        }

    }

}