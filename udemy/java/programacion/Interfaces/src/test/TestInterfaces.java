package test;

import accesoDatos.*;

public class TestInterfaces {
    public static void main(String[] args) {
        //Variable de tipo interface.
        IAccesoDatos datos = new ImplementacionMySql();
        //datos.listar();
        //imprimir(datos);
        
        datos = new ImplementacionOracle();
        //datos.listar();
        imprimir(datos);
    }
    public static void imprimir(IAccesoDatos datos){
        datos.listar();
    }
}
