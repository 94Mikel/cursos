using System.Data.SqlClient;
using Dapper;
using ManejoPresupuesto.Models;
using ManejoPresupuesto.Servicios;
using Microsoft.AspNetCore.Mvc;
using Npgsql;

namespace ManejoPresupuesto.Controllers

{
    //Heredamos de la clase controller
    public class TipoCuentaController : Controller
    {
        private readonly IRepositorioTipoCuenta repositorioTipoCuenta;

        public TipoCuentaController(IRepositorioTipoCuenta repositorioTipoCuenta)
        {
            this.repositorioTipoCuenta = repositorioTipoCuenta;
        }

        public async Task<IActionResult> Index()
        {
            //FIXME Quitar el Hardcoreo.
            var idUsuario = 1;
            return View(await repositorioTipoCuenta.Obtener(idUsuario));
        }

        public IActionResult Crear()
        {
            //var connection = new NpgsqlConnection(connectionString);

            return View();
        }

        // NOTE:Programación asíncrona
        /*
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

            if (await repositorioTipoCuenta.Existe(tipoCuenta.Nombre, tipoCuenta.IdUsuario))
            {
                //Agregar error al model state.
                ModelState.AddModelError(
                    nameof(tipoCuenta.Nombre),
                    $"El nombre {tipoCuenta.Nombre} ya existe"
                );

                //Devolver la vista pasando el objeto tipoCuenta.
                return View(tipoCuenta);
            }

            await repositorioTipoCuenta.Crear(tipoCuenta);

            //Redirijir a la accion Index.
            return RedirectToAction("Index");
        }

        //Nos comunicamos con el cliente para validar si el tipo cuenta es el mismo(frontEnd => al escribir en el input text).
        [HttpGet]
        public async Task<IActionResult> VerificarExisteTipoCuenta(string nombre)
        {

            //FIXME hardcodeamos el idUsuario
            var idUsuario = 1;

            if (await repositorioTipoCuenta.Existe(nombre, idUsuario))
            {
                return Json($"El nombre {nombre} ya existe");
            }

            return Json(true);

        }

    }
}