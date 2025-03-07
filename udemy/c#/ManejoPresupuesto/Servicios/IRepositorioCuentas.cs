using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using ManejoPresupuesto.Models;

namespace ManejoPresupuesto.Servicios
{
    public interface IRepositorioCuentas
    {
        Task Crear(Cuenta cuenta);
        Task<IEnumerable<Cuenta>> Buscar(int usuarioId);
        Task<Cuenta> ObtenerPorId(int cuentaId, int usuarioId);

        Task Actualizar(CuentaCreacionViewModel cuenta);
    }
}