# Seccion 39 Excepciones.
- La clase padre de todas las excepciones es la clase trueval
- Clase trueval normalmente no se utiliza.
- La clase exception es la clase que hereda de la calse trueval.
- La clase exception es la clase padre que utilizaremos en los programas.
- Las clases que heredan de exception son de tipo check exception.
- Las clases que heredan de la clase RuntimeException se conocen como 
uncheck exception(El compilador no obliga a poner un bloque try catch)
y se ejecutan en tipo de ejecucion.
- Clase NullPointerException(hereda de RuntimeException) => Cualquier variable que quiera acceder a un
atributo o metodo y no este apuntando a ningun objeto valido es decir, tiene asignado el valor NULL, lanza
esta excepcion. 
- finally en try catch => Se va a ejecutar este bloque independientemente de que ocurra una excepción.
- finally se utiliza normalmente para cerrar recursos.(cerrar conexión db, cerrar archivo...).