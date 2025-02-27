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
            PROGRAMACIÓN ASÍNCRONA
            Devolvemos IActionResult. si estas solo Task es como void pero en programacion asincrona.
            Si se llama a un metodo con async await el metodo también tiene que trabajar con async await
        */

        [HttpPost]
        public async Task<IActionResult> Crear(TipoCuenta tipoCuenta)
        {
            //Validación por atributo
            if (!ModelState.IsValid)
            {
                return View(tipoCuenta);
            }

            //FIXME corregiremos mas adelante. El usuario tiene que especificar.
            tipoCuenta.IdUsuario = 1;

            //FIXME La validación se realizar al pulsar el boton de enviar(crear) se tiene que realziar segun escriba.

            var yaExisteTipoCuenta = await repositorioTiposCuentas.Existe(tipoCuenta.Nombre, tipoCuenta.IdUsuario);

            if (yaExisteTipoCuenta)
            {
                //Agregar error al model state.
                ModelState.AddModelError(
                    nameof(tipoCuenta.Nombre),
                    $"El nombre {tipoCuenta.Nombre} ya existe"
                );

                //Devolver la vista pasando el objeto tipoCuenta.
                return View(tipoCuenta);
            }

            await repositorioTiposCuentas.Crear(tipoCuenta);

            //TODO ir a otra vista al insertar en la bd => tipoCuenta
            return View();
        }

    }
}