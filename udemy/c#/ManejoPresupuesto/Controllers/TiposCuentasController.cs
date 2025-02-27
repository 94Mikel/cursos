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

        /*
            NOTE
            Utilizamos programación asincrona
            Devolvemos IActionResult. si estas solo Task es como void pero en programacion asincrona.
            Si se llama a un metodo con async await el metodo también tiene que trabajar con async await
        */

        [HttpPost]
        public async Task<IActionResult> Crear(TipoCuenta tipoCuenta)
        {
            if(!ModelState.IsValid){
                return View(tipoCuenta);
            }

            tipoCuenta.IdUsuario = 2;
            await repositorioTiposCuentas.Crear(tipoCuenta);
            
            //TODO ir a otra vista al insertar en la bd => tipoCuenta
            return View();
        }

    }
}