package gm.inventarios.servicio;

import java.util.List;
import gm.inventarios.modelo.Producto;

public interface IProductoServicio {
    public List<Producto> listarProductos();

    public Producto buscarProductoPorId(Integer idProducto);

    public void guardarProducto(Producto producto);

    public void eliminarProductoPorId(Integer idProducto);
}
