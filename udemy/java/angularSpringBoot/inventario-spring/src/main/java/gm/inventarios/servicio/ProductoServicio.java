package gm.inventarios.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gm.inventarios.modelo.Producto;
import gm.inventarios.repositorio.ProductoRepositorio;

@Service
public class ProductoServicio implements IProductoServicio {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Override
    public List<Producto> listarProductos() {
        return this.productoRepositorio.findAll();
    }

    @Override
    public Producto buscarProductoPorId(Integer idProducto) {
        //Si no se encuentra el objeto producto retorna un null
        return this.productoRepositorio.findById(idProducto).orElse(null);
    }

    @Override
    public void guardarProducto(Producto producto) {
        /*
         * Save realiza => si id_producto es null realiza un update si no un insert
         * 
        */
        this.productoRepositorio.save(producto);
    }

    @Override
    public void eliminarProductoPorId(Integer idProducto) {
        this.productoRepositorio.deleteById(idProducto);    
    }

}
