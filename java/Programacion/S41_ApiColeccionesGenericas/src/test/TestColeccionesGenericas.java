package test;

import java.util.*;

public class TestColeccionesGenericas {

    public static void main(String[] args) {
        List<String> miLista = new ArrayList<>();
        //Añade elementos de forma sincrona(respeta el orden).
        //Se pude duplicar elementos
        miLista.add("Lunes");
        miLista.add("Martes");
        miLista.add("Miercoles");
        miLista.add("Jueves");
        miLista.add("Viernes");
        miLista.add("Viernes");
        //String elemento = miLista.get(0);// este metodo regresa un string
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
        Set<String> miSet = new HashSet<>();
        miSet.add("Lunes");
        miSet.add("Martes");
        miSet.add("Miercoles");
        miSet.add("Jueves");
        miSet.add("Viernes");
        miSet.add("Viernes");//Solo aparece un viernes una vez
        //imprimir(miSet);
        
        //MAP
        Map <String,String> miMapa = new HashMap<>();
        miMapa.put("valor1", "Juan");
        miMapa.put("valor2", "Karla");
        miMapa.put("valor3", "Rosario");
        
        String elementoMapa = miMapa.get("valor1");
        //System.out.println("elementoMapa = " + elementoMapa);
        
        imprimir(miMapa.keySet());
        imprimir(miMapa.values());
    }
    
    public static void imprimir(Collection<String> coleccion){
        coleccion.forEach(elemento -> {
            System.out.println("elemento = " + elemento);
        });
    }

}
