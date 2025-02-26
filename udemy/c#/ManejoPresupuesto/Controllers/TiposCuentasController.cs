using System.Data.SqlClient;
using Dapper;
using ManejoPresupuesto.Models;
using Microsoft.AspNetCore.Mvc;
using Npgsql;

namespace ManejoPresupuesto.Controllers

{
    //Heredamos de la clase controller
    public class TiposCuentasController : Controller
    {
        private readonly string connectionString;

        public TiposCuentasController(IConfiguration configuration)
        {
            connectionString = configuration.GetConnectionString("DefaultConnection");
        }

        public IActionResult Crear()
        {

            var connection = new NpgsqlConnection(connectionString);

            using (connection)
            {
                var query = connection.Query("SELECT 1").FirstOrDefault();
            }

            return View();
        }

        [HttpPost]
        public IActionResult Crear(TipoCuenta tipoCuenta)
        {
            if(!ModelState.IsValid){
                return View(tipoCuenta);
            }
            
            return View();
        }

    }
}