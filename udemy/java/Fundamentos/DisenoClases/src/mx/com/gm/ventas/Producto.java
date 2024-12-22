package mx.com.gm.ventas;

public class Producto {
    private final int idProducto;//una vez establecido el valor no podremos modificar
    private String nombre;
    private double precio;
    private static int contadorProductos;

    private Producto() {
        this.idProducto = ++Producto.contadorProductos;
    }

    public Producto(String nombre, double precio) {
        this();
        this.nombre = nombre;
        this.precio = precio;
    }
    
    public int getIdProducto() {
        return this.idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }    

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", nombre=" + nombre + ", precio=" + precio + '}';
    }
    
}
