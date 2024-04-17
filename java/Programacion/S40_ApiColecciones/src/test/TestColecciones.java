package test;

import java.util.*;

public class TestColecciones {

    public static void main(String[] args) {
        List miLista = new ArrayList();
        //Añade elementos de forma sincrona(respeta el orden).
        //Se pude duplicar elementos
        miLista.add("Lunes");
        miLista.add("Martes");
        miLista.add("Miercoles");
        miLista.add("Jueves");
        miLista.add("Viernes");
        miLista.add("Viernes");
        //imprimir(miLista);

        /*
        for (Object elemento : miLista) {
            System.out.println("elemento = " + elemento);
        }
         */
        //Funcion landa(arrow)
        //Recorrer respetando el orden
        /*
        miLista.forEach(elemento -> {
            System.out.println("elemento = " + elemento);
        });
*/

        //No se respeta el orden de los elementos.(asincrono. es mas rapido)
        //No se pueden duplicar elementos.(se desecha el elemento duplicado)
        Set miSet = new HashSet();
        miSet.add("Lunes");
        miSet.add("Martes");
        miSet.add("Miercoles");
        miSet.add("Jueves");
        miSet.add("Viernes");
        miSet.add("Viernes");//Solo aparece un viernes una vez
        //imprimir(miSet);
        
        //MAP
        Map miMapa = new HashMap();
        miMapa.put("valor1", "Juan");
        miMapa.put("valor2", "Karla");
        miMapa.put("valor3", "Rosario");
        
        String elemento = (String) miMapa.get("valor1");
        System.out.println("elemento = " + elemento);
        
        imprimir(miMapa.keySet());
        imprimir(miMapa.values());
    }
    
    public static void imprimir(Collection coleccion){
        coleccion.forEach(elemento -> {
            System.out.println("elemento = " + elemento);
        });
    }

}
