# Caracteristicas Java EE

## Clases
- Order en fichero:
	- Packetes
	- Imports
	- Definicion de la clase.
- Todas las clases heredan de la clase object.
- En un fichero solo puede haber una clase de tipo public.
- Si no se define la clase, es de tipo default o package.

## Memoria
- Tipos primitivos(int, string...)
	- Se guardan en la memoria stack.
	- Se eliminan cuando se termina el metodo o ambito.
	- Se optiene en el ambito donde se declara. 
- Tipos object
	- Se guardan en la memoria head.
	- No se eliminan hasta que se termine con la instancia.
	- Se optiene preguntado por la referencia.

## Metodos
- return:
	- La palabra return siempre esta presente aunque la funcion sea de
	  tipo void. En estos casos el compiraldor pone un return en la
	  ultima linea
	- Podemos poner varios returns en un metodo y jugar con el if...
	- 

## Errores
- Tiempo de ejecucion => Cuando se ejecuta el programa.

## Encapsulamiento
- Modificadores de acceso para uso privado/publico de atributos entre clases.
- Tipos
	- private(buena practica) => solo se puede acceder desde la propia
	  clase.(se acceder con getters y setters) 
	- public => se puede acceder desde cualquier sitio.  
	- package(default) => Es accesible dentro del propio paquete(folder)

## Metodo toString
- println de java manda llamar de manera automatica el metodo toString. Poniendo solo el nombre de clase ejecuta el toString()

## Contexto
- Estatico => Cuando se trabaja con las clases.
- Dinámico => Cuando se trabaja con los objetos de la clase.
- El contexto estatico no puede acceder al contexto dinámico. Porque se necesita que las clases esten ya creadas.
- El contecto dinámico si puede acceder al contexto estatico. Podemos acceder a las clases.
