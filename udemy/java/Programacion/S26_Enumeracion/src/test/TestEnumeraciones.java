package test;

import enumeracion.Continentes;
import enumeracion.Dias;

public class TestEnumeraciones {
    public static void main(String[] args) {
//        System.out.println("Dias 1: "+Dias.LUNES);
//        indicarDiaSemana(Dias.LUNES);
        System.out.println("Continente numero 4: "+Continentes.AMERICA);
        System.out.println("NO. Paises en el 4to continente: "+Continentes.AMERICA.getPaises());
        
        System.out.println("Continente numero 1: "+Continentes.AFRICA);
        System.out.println("NO. Paises en el 1to continente: "+Continentes.AFRICA.getPaises());
    }
    
    private static void indicarDiaSemana(Dias dias){
        switch(dias){
            case LUNES:
                System.out.println("Primer dia de la semana");
              break;
            case MARTES:
                System.out.println("Segundo dia de la semana");
                break;
        }
    }
    
}
