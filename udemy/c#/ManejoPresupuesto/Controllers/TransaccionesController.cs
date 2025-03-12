using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using ManejoPresupuesto.Models;
using ManejoPresupuesto.Servicios;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;

namespace ManejoPresupuesto.Controllers
{
    public class TransaccionesController: Controller
    {
        private readonly IServicioUsuarios servicioUsuarios;
        private readonly IRepositorioCuentas repositorioCuentas;

        public TransaccionesController
        (
            IServicioUsuarios servicioUsuarios, 
            IRepositorioCuentas repositorioCuentas
        )
        {
            this.servicioUsuarios = servicioUsuarios;
            this.repositorioCuentas = repositorioCuentas;
        }

        public async Task<IActionResult> Crear() 
        {
            var usuariId = servicioUsuarios.ObtenerUsuarioId();
            var modelo = new TransaccionCreacionViewModel();
            modelo.Cuentas = await ObtenerCuentas(usuariId);
            return View(modelo);
        }

        private async Task<IEnumerable<SelectListItem>> ObtenerCuentas(int usuarioId)
        {
            var cuentas = await repositorioCuentas.Buscar(usuarioId);
            return cuentas.Select(x => new SelectListItem(x.Nombre, x.CuentaId.ToString()));
        }
    }
}