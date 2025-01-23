# Angular: Guía Detallada

## ¿Qué es Angular?
Angular es un **framework de desarrollo web** basado en TypeScript, desarrollado y mantenido por **Google**. 
Se utiliza para crear aplicaciones **web de una sola página (SPA, Single Page Applications)**, 
ofreciendo una estructura robusta para el desarrollo de aplicaciones dinámicas y escalables.

---

## Características Principales de Angular
1. **Basado en TypeScript**  
   - Angular está escrito en TypeScript, un superset de JavaScript que agrega características como tipado estático y programación orientada a objetos.

2. **Arquitectura basada en Componentes**  
   - La aplicación se divide en **componentes reutilizables**, cada uno de ellos con su propia lógica y vista.
   - Los componentes son bloques de construcción modulares que encapsulan lógica(clases), plantilla(html) y estilos(css).

3. **Data Binding (Enlace de Datos)**  
   - Soporta enlace bidireccional de datos (*Two-way Data Binding*), lo que permite sincronizar datos entre la vista y el modelo de manera eficiente.
   - Es decir, los cambios en la interfaz de usuario se reflejan automáticamente en los datos y viceversa

4. **Inyección de Dependencias (DI)**  
   - Angular proporciona un sistema de inyección de dependencias potente y flexible para gestionar instancias de servicios.

5. **Directivas**  
   - Angular permite extender el HTML con funcionalidades adicionales mediante **directivas**, como `*ngIf`, `*ngFor`, `ngClass`, etc.

6. **Routing (Enrutamiento)**  
   - Angular proporciona un sistema de enrutamiento para construir aplicaciones de múltiples vistas y navegación dinámica.
   - Proporciona un sistema de enrutamiento integrado para crear aplicaciones de una sola página con múltiples vistas.

7. **Módulos (NgModules)**  
   - La estructura modular de Angular permite dividir la aplicación en módulos reutilizables y escalables.

8. **PWA (Progressive Web Apps)**  
   - Soporta la creación de aplicaciones web progresivas, ofreciendo funcionalidades como caché offline y notificaciones push.

9. **Formularios Reactivos y Basados en Plantillas**
   - Angular ofrece soporte tanto para formularios reactivos como basados en plantillas, facilitando la gestión y validación de formularios complejos.

10. **Herramientas de Desarrollo**
   - Angular CLI(Command Line Interface) es una herramienta poderosa que simplifica la creación, desarrollo y despliegue de aplicaciones Angular

---

## Arquitectura de Angular

Angular sigue un patrón basado en la separación de responsabilidades mediante:

- **Componentes:** Controlan la lógica de la interfaz de usuario.
- **Servicios:** Encargados de la lógica de negocio y gestión de datos.
- **Módulos:** Agrupan componentes y servicios relacionados.
- **Plantillas (Templates):** Definen la vista de los componentes utilizando HTML y directivas de Angular.

---

## Instalacon de Angular
- Para instalar Angular CLI, se necesita Node.js. Una vez instalado, ejecuta:
	- npm install -g @angular/cli

## Para crear un proyecto
- ng new mi-proyecto-angular
- cd mi-proyecto-angular
- ng serve

Si se requiere que la aplicación sea compatible con otras versiones de
angular **ng new mi-proyecto-angular --standalone=false** ya que crea el
app-module.ts

La aplicación estará disponible en http://localhost:4200/.

## Principales Comandos de Angular CLI
- Crea un nuevo proyecto Angular => ng new <nombre-proyecto>
- Inicia el servidor de desarrollo => ng server
- Genera un nuevo componente => ng generate component <nombre>
- Genera un nuevo servicio => ng generate service <nombre>
- Compila la aplicación para producción => ng build
- Ejecuta las pruebas unitarias => ng test
- Analiza el código en busca de errores de sintaxis => ng lint

## Concepto Clave de Angular
1. Componentes
Un componente es una parte fundamental de la UI en Angular. Un ejemplo de un componente básico:

>
> import { Component } from '@angular/core';
>
> @Component({
>  selector: 'app-ejemplo',
>  template: `<h1>{{ titulo }}</h1>`,
>  styleUrls: ['./ejemplo.component.css']
> })
> export class EjemploComponent {
>  titulo = '¡Hola Angular!';
> }

2. Directivas
Las directivas permiten modificar el DOM de la aplicación. Ejemplos de directivas comunes:
- *ngIf: Renderiza un elemento solo si la condición es verdadera.
> <p *ngIf="mostrarTexto">Texto visible si mostrarTexto es true</p>

- *ngFor: Itera sobre una colección de elementos.
> <ul>  
> 	<li *ngFor="let item of lista">{{ item }}</li>  
> </ul>  

3. Servicios e Inyección de Dependencias
Los servicios permiten compartir datos y lógica de negocio entre diferentes componentes.

> import { Injectable } from '@angular/core';  
>  
> @Injectable({  
>  providedIn: 'root'  
> })  
> export class EjemploService {  
>   obtenerMensaje() {  
>     return 'Mensaje desde el servicio';  
>   }  
> }  

Uso en un componente:

> import { Component, OnInit } from '@angular/core';  
> import { EjemploService } from './ejemplo.service';  
>  
> @Component({  
>   selector: 'app-ejemplo',  
>   template: `<p>{{ mensaje }}</p>`  
> })  
> export class EjemploComponent implements OnInit {  
>   mensaje: string;  
>  
>   constructor(private ejemploService: EjemploService) {}  
>  
>   ngOnInit() {  
>     this.mensaje = this.ejemploService.obtenerMensaje();  
>   }  
> }  

## Ventajas de Angular
- **Estructura escalable y modular.**
- **Soporte y actualizaciones frecuentes de Google.**
- **Amplio ecosistema de herramientas y librerías.**
- **Excelente manejo del DOM mediante el mecanismo de detección de cambios.**
- **Desarrollo multiplataforma con Angular Universal (SSR) y Mobile (Ionic).**

## Desventajas de Angular
- **Curva de aprendizaje pronunciada**, especialmente para principiantes.
- **Rendimiento ligeramente inferior** en comparación con frameworks más ligeros como React o Vue.js.
- **Mayor complejidad en proyectos pequeños.**

## Conclusion

Angular es una herramienta poderosa para construir aplicaciones web
modernas. Con sus características robustas y su estructura modular, Angular
facilita el desarrollo y mantenimiento de aplicaciones escalables y
eficiontes.

Para más información revisar página y documentación oficial de Angular:

Pagina web de angular => https://angular.dev/

Tutoriales de angular => https://angular.dev/tutorials


## ¿Por que es necesario Node.js para Angular?

Angular es un framework de desarrollo web que se utiliza para crear
aplicaciones de una sóla página(SPA). Aunque Angular se ejecuta en el
navegador, Node.js es necesario para varias tareas durante el desarrollo y
despliegue de aplicaciones Angular:
- **Angular CLI**: 
Angular Command LIne interfaces(cli) es una herramienta basada en Node.js
que facilita la creación, desarrollo y despliegue de aplicaciones Angular.
Permite a los desarrolladores generar componentes, servicios y otros
elementos rápidamente.
- **Servidor de Desarrollo**:
Node.js proporciona un servidor de desarrollo que permite a los
programadores ver los cambios en tiempo real sin necesidad de recargar
manualmente el navegador.
- **Gestión de Dependencias**:
npm, el getor de paquetes de Node.js, se utiliza para instalar y gestionar
las dependencias de un proyecto Angular.
- **Build y Herramientas de Tareas**:
Node.js se utiliza para ejecutar tareas automáticamente, como la
construcción, minificación y optimización de archivos, utilizando
heremientas como Webpack y Gulp.




