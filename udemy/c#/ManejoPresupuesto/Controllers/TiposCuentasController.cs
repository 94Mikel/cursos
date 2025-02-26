using System.Data.SqlClient;
using Dapper;
using ManejoPresupuesto.Models;
using ManejoPresupuesto.Servicios;
using Microsoft.AspNetCore.Mvc;
using Npgsql;

namespace ManejoPresupuesto.Controllers

{
    //Heredamos de la clase controller
    public class TiposCuentasController : Controller
    {
        private readonly IRepositorioTiposCuentas repositorioTiposCuentas;

        public TiposCuentasController(IRepositorioTiposCuentas repositorioTiposCuentas)
        {
            this.repositorioTiposCuentas = repositorioTiposCuentas;
        }

        public IActionResult Crear()
        {

            //var connection = new NpgsqlConnection(connectionString);

            return View();
        }

        [HttpPost]
        public IActionResult Crear(TipoCuenta tipoCuenta)
        {
            if(!ModelState.IsValid){
                return View(tipoCuenta);
            }

            tipoCuenta.IdUsuario = 1;
            repositorioTiposCuentas.Crear(tipoCuenta);
            
            //TODO ir a otra vista al insertar en la bd => tipoCuenta
            return View();
        }

    }
}