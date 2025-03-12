using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using ManejoPresupuesto.Models;

namespace ManejoPresupuesto.Servicios
{
    public interface IRepositorioTransacciones
    {
        Task Crear(Transaccion transaccion);
    }
}