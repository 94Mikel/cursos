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
        */
        public async Task Crear(TipoCuenta tipoCuenta)
        {
            /*
                QuerySingle => para realizar querys que devuelva un solo resultado.
                despues de insertar queresmo extraer el id insertado.
            */
            using var connection = new NpgsqlConnection(connectionString);
            var id = await connection.QuerySingleAsync<int>(
                $@"
                INSERT INTO tipos_cuentas (nombre, usuario_id, orden)
                VALUES(@Nombre, @usuarioId, 0);
                SELECT currval(pg_get_serial_sequence('tipos_cuentas','id'));", tipoCuenta);

            tipoCuenta.Id = id;
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
                "SELECT id, nombre, orden FROM tipos_cuentas WHERE usuario_id = @usuarioId",
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

    }

}