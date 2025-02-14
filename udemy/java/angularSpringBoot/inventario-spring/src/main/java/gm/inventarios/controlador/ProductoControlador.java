package gm.inventarios.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gm.inventarios.excepcion.RecursoNoEncontradoExcepcion;
import gm.inventarios.modelo.Producto;
import gm.inventarios.servicio.ProductoServicio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
// http://localhost:8080/inventario-app
// ContextPath para todas las peticiones.Las peteniciones tiene que llevar
// "inventario-app"
@RequestMapping("inventario-app")
@CrossOrigin(value = "http://localhost:4200") // El front en esta en el puerto 4200
public class ProductoControlador {

    private static final Logger logger = LoggerFactory.getLogger(ProductoControlador.class);

    @Autowired
    private ProductoServicio productoServicio;

    // http://localhost:8080/inventario-app/productos
    @GetMapping("/productos")
    public List<Producto> obtenerProductos() {
        List<Producto> productos = this.productoServicio.listarProductos();
        logger.info("Productos obtenidos:");
        productos.forEach((producto -> logger.info(producto.toString())));
        return productos;
    }

    @PostMapping("/productos")
    public Producto agregarProducto(@RequestBody Producto producto) {
        logger.info("producto a agregar: " + producto);
        return this.productoServicio.guardarProducto(producto);
    }

    /*
     * Response Entity => Retornamos el objeto producto dentro del cuerpo de la
     * respuesta de tipo get
     */
    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable int id) {
        Producto producto = this.productoServicio.buscarProductoPorId(id);

        if (producto == null) {
            throw new RecursoNoEncontradoExcepcion("No se encontro el producto");
        }

        return ResponseEntity.ok(producto);
    }

    // Actualizar producto
    @PutMapping("productos/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable int id, @RequestBody Producto productoRecibido) {
        Producto producto = this.productoServicio.buscarProductoPorId(id);

        if (producto == null) {
            throw new RecursoNoEncontradoExcepcion("No se encontro el producto");
        }

        producto.setDescripcion(productoRecibido.getDescripcion());
        producto.setExistencia(productoRecibido.getExistencia());
        producto.setPrecio(productoRecibido.getPrecio());

        this.productoServicio.guardarProducto(producto);
        return ResponseEntity.ok(producto);
    }

    /*
     * Eliminar producto
     * Devolvemos una respuesta de tipo boolean para saber si esta eliminado o no.
     */
    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarProducto(@PathVariable int id){
        Producto producto = this.productoServicio.buscarProductoPorId(id);

        if(producto == null){
            throw new RecursoNoEncontradoExcepcion("No se encontro el producto a eliminar. id: "+id);
        }

        this.productoServicio.eliminarProductoPorId(producto.getIdProducto());
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
