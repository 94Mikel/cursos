using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Dapper;
using ManejoPresupuesto.Models;
using Npgsql;

namespace ManejoPresupuesto.Servicios
{
    /*
    Vamos a mantenernos utilizando el principio de inyeccion de dependencias.
    Nuestras clases deben de depender de abstracciones y no de tipos concretos.

    IConfiguration => para acceder al conection string

    */

    public interface IRepositorioTiposCuentas
    {
        Task Crear(TipoCuenta tipoCuenta);
    }

    public class RepositorioTiposCuentas: IRepositorioTiposCuentas
    {
        private readonly string connectionString;
        public RepositorioTiposCuentas(IConfiguration configuration)
        {
            connectionString = configuration.GetConnectionString("DefaultConnection") ??
            throw new ApplicationException("Connection string is missing");
        }

        //Metodo para crear un tipo cuenta en la base de datos.
        //Marcamos como asincrona y retoran un datos de tipo Task(promesa)
        //querySingle => para llamada sincronas
        //querySingleAsync => para llamada asincronas
        public async Task Crear(TipoCuenta tipoCuenta)
        {
            /*
                QuerySingle => para realizar querys que devuelva un solo resultado.
                despues de insertar queresmo extraer el id insertado.
            */
            using var connection = new NpgsqlConnection(connectionString);
            var id = await connection.QuerySingleAsync<int>(
                $@"
                INSERT INTO tipo_cuenta (nombre, id_usuario, orden)
                VALUES(@Nombre, @IdUsuario, 0);
                SELECT currval(pg_get_serial_sequence('tipo_cuenta','id_tipo_cuenta'));", tipoCuenta);

            tipoCuenta.Id = id;
        }

    }

    public interface ISqlConnectionFactory
    {
    }
}