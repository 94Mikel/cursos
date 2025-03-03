using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc.Rendering;

namespace ManejoPresupuesto.Models
{
    public class CuentaCreacionViewModel: Cuenta
    {
        //NOTE SelectListItem
        /*
            Es una clase especial de asp .net core que nos permite crearse de manera muy sencilla.
        */
        public IEnumerable<SelectListItem> TiposCuentas { get; set; }
    }
}