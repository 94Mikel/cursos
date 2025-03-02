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
        //NOTE:servicioUsuarios
        /*
            Utilizamos servicioUsuarios para no duplicar codigo y 
            para que sea mas mantenible
        */
        private readonly IRepositorioTiposCuentas repositorioTiposCuentas;
        private readonly IServicioUsuarios servicioUsuarios;

        public TiposCuentasController
        (
            IRepositorioTiposCuentas repositorioTiposCuentas,
            IServicioUsuarios servicioUsuarios
        )
        {
            this.repositorioTiposCuentas = repositorioTiposCuentas;
            this.servicioUsuarios = servicioUsuarios;
        }

        public async Task<IActionResult> Index()
        {
            //FIXME Quitar el Hardcodeo.
            var idUsuario = servicioUsuarios.ObtenerUsuarioId();
            return View(await repositorioTiposCuentas.Obtener(idUsuario));
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
        public async Task<IActionResult> Crear(TipoCuenta TipoCuenta)
        {
            //Validación por atributo
            if (!ModelState.IsValid)
            {
                return View(TipoCuenta);
            }

            //FIXME corregiremos mas adelante. El usuario tiene que especificar.
            TipoCuenta.UsuarioId = servicioUsuarios.ObtenerUsuarioId();

            if (await repositorioTiposCuentas.Existe(TipoCuenta.Nombre, TipoCuenta.UsuarioId))
            {
                //Agregar error al model state.
                ModelState.AddModelError(
                    nameof(TipoCuenta.Nombre),
                    $"El nombre {TipoCuenta.Nombre} ya existe"
                );

                //Devolver la vista pasando el objeto TiposCuentas.
                return View(TipoCuenta);
            }

            await repositorioTiposCuentas.Crear(TipoCuenta);

            //Redirijir a la accion vista Index.
            return RedirectToAction("Index");
        }

        [HttpPost]
        public async Task<ActionResult> Editar(TipoCuenta tipoCuenta)
        {
            var usuarioId = servicioUsuarios.ObtenerUsuarioId();
            var tipoCuentaExiste = await repositorioTiposCuentas.ObtenerPorId(tipoCuenta.Id, usuarioId);

            if (tipoCuentaExiste is null)
            {
                return RedirectToAction("NoEncontrado", "Home");
            }

            await repositorioTiposCuentas.Actualizar(tipoCuenta);

            return RedirectToAction("Index");
        }

        [HttpGet]
        public async Task<ActionResult> Editar(int id)
        {
            var usuarioId = servicioUsuarios.ObtenerUsuarioId();
            var tipoCuenta = await repositorioTiposCuentas.ObtenerPorId(id, usuarioId);

            if (tipoCuenta is null)
            {
                return RedirectToAction("NoEncontrado", "Home");
            }

            return View(tipoCuenta);
        }

        public async Task<IActionResult> Borrar(int id)
        {
            var usuarioId = servicioUsuarios.ObtenerUsuarioId();
            var tipoCuenta = await repositorioTiposCuentas.ObtenerPorId(id, usuarioId);

            if (tipoCuenta is null)
            {
                return RedirectToAction("NoEncontrado", "Home");
            }

            return View(tipoCuenta);
        }

        [HttpPost]
        public async Task<IActionResult> BorrarTipoCuenta(int id)
        {
            var usuarioId = servicioUsuarios.ObtenerUsuarioId();
            var tipoCuenta = await repositorioTiposCuentas.ObtenerPorId(id, usuarioId);

            if (tipoCuenta is null)
            {
                return RedirectToAction("NoEncontrado", "Home");
            }

            await repositorioTiposCuentas.Borrar(id);

            return RedirectToAction("Index");
        }

        //Nos comunicamos con el cliente para validar si el tipo cuenta es el mismo(frontEnd => al escribir en el input text).
        [HttpGet]
        public async Task<IActionResult> VerificarExisteTipoCuenta(string nombre)
        {

            //FIXME hardcodeamos el idUsuario
            var idUsuario = servicioUsuarios.ObtenerUsuarioId();

            if (await repositorioTiposCuentas.Existe(nombre, idUsuario))
            {
                return Json($"El nombre {nombre} ya existe");
            }

            return Json(true);

        }

        // NOTE: ordenamos la tabla mendian ajax
        /*
            En el cuerpo recibimos el arreglo de id.
            Los ids vendran en un orden especifico 
            y se actualizara la orden de las filas en base a esto.
        */
        [HttpPost]
        public async Task<IActionResult> Ordenar([FromBody] int[] ids)
        {
            var usuarioId = servicioUsuarios.ObtenerUsuarioId();
            var tiposCuentas = await repositorioTiposCuentas.Obtener(usuarioId);
            //Obtener los ids de los tipos cuentas que yo estory extrayendo aquí.
            var idsTiposCuentas = tiposCuentas.Select(x => x.Id);

            //Verificar que este listado de aquí sea vacío.
            //Preguntamos si existe un id que esta en ids y que no esta n idsTiposCuentas.
            var idsTiposCuentasNoPertenecenAlUsuario = ids.Except(idsTiposCuentas).ToList();

            //Si hay algun id que no coincide
            if (idsTiposCuentasNoPertenecenAlUsuario.Count > 0)
            {
                return Forbid();
            }

            /*
                Mappeo.
                Crear arreglo de tipos cuentas.
            */
            var tiposCuentasOrdenados = ids.Select(
                (valor, indice) => new TipoCuenta()
                {
                    Id = valor,
                    Orden = indice + 1
                }
            ).AsEnumerable();

            //Actualizar en la base de datos.
            await repositorioTiposCuentas.Ordenar(tiposCuentasOrdenados);

            return Ok();
        }

    }
}