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
        Task Actualizar(Transaccion transaccion, decimal montoAnterior, int cuentaAnterior);
        Task<Transaccion> ObtenerPorId(int TransaccionId, int UsuarioId);
        Task Borrar(int id);
        Task<IEnumerable<Transaccion>> ObtenerPorCuentaId(ObtenerTransaccionesPorCuenta modelo);
        Task<IEnumerable<Transaccion>> ObtenerPorUsuarioId(ParametroObtenerTrasaccionesPorUsuario modelo);
        Task<IEnumerable<ResultadoObtenerPorSemana>> ObtenerPorSemana(
            ParametroObtenerTrasaccionesPorUsuario modelo
        );
    }
}