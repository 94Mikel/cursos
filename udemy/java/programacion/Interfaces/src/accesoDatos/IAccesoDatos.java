package accesoDatos;

//No es una herencia de tipo object
public interface IAccesoDatos {
    //Hay que asignar el valor al declarar obligatoriamente.
    int MAX_REGISTRO = 10;
    
    //Metodo abstraco.
    void insertar();
    
    void listar();
    
    void actualizar();
    
    void eliminar();
}
