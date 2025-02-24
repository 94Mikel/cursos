using ManejoPresupuesto.Models;
using Microsoft.AspNetCore.Mvc;

namespace ManejoPresupuesto.Controllers

{
    //Heredamos de la clase controller
    public class TiposCuentasController : Controller
    {

        public IActionResult Crear()
        {
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