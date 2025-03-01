using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using ManejoPresupuesto.Models;

namespace ManejoPresupuesto.Servicios
{
    public interface IRepositorioTiposCuentas
    {
        Task Crear(TipoCuenta tipoCuenta);
        Task<bool> Existe(string nombre, int idUsuario);
        Task Borrar(int id);
        Task<IEnumerable<TipoCuenta>> Obtener(int idUsuario);

        Task<TipoCuenta> ObtenerPorId(int id, int usuarioId);

        Task Actualizar(TipoCuenta tipoCuenta);
    }
}