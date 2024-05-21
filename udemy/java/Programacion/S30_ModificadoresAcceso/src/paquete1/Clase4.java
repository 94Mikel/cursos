package paquete1;

class Clase4 {
    //ALL PRIVATE
    private String atributoPrivado = "Valor atributo privado";
    
    //Este constructor solo se pordra utilizar dentro de esta clase.
    private Clase4(){
        System.out.println("Constructor privado");
    }
    
    public Clase4(String argumento) {
        this();//Podemos acceder al contructor porque estamos en la misma clase.
        System.out.println("Constructor publico");
    }
    
    private void metodoPrivate(){
        System.out.println("Metodo private");
    }

    public String getAtributoPrivado() {
        return atributoPrivado;
    }

    public void setAtributoPrivado(String atributoPrivado) {
        this.atributoPrivado = atributoPrivado;
    }
    
    
    
}
