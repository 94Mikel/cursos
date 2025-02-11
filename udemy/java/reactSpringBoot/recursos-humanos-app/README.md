# Getting Started with Create React App

This project was bootstrapped with [Create React App](https://github.com/facebook/create-react-app).

## Available Scripts

In the project directory, you can run:

### `npm start`

Runs the app in the development mode.\
Open [http://localhost:3000](http://localhost:3000) to view it in your browser.

The page will reload when you make changes.\
You may also see any lint errors in the console.

### `npm test`

Launches the test runner in the interactive watch mode.\
See the section about [running tests](https://facebook.github.io/create-react-app/docs/running-tests) for more information.

### `npm run build`

Builds the app for production to the `build` folder.\
It correctly bundles React in production mode and optimizes the build for the best performance.

The build is minified and the filenames include the hashes.\
Your app is ready to be deployed!

See the section about [deployment](https://facebook.github.io/create-react-app/docs/deployment) for more information.

### `npm run eject`

**Note: this is a one-way operation. Once you `eject`, you can't go back!**

If you aren't satisfied with the build tool and configuration choices, you can `eject` at any time. This command will remove the single build dependency from your project.

Instead, it will copy all the configuration files and the transitive dependencies (webpack, Babel, ESLint, etc) right into your project so you have full control over them. All of the commands except `eject` will still work, but they will point to the copied scripts so you can tweak them. At this point you're on your own.

You don't have to ever use `eject`. The curated feature set is suitable for small and middle deployments, and you shouldn't feel obligated to use this feature. However we understand that this tool wouldn't be useful if you couldn't customize it when you are ready for it.

## Learn More

You can learn more in the [Create React App documentation](https://facebook.github.io/create-react-app/docs/getting-started).

To learn React, check out the [React documentation](https://reactjs.org/).

### Code Splitting

This section has moved here: [https://facebook.github.io/create-react-app/docs/code-splitting](https://facebook.github.io/create-react-app/docs/code-splitting)

### Analyzing the Bundle Size

This section has moved here: [https://facebook.github.io/create-react-app/docs/analyzing-the-bundle-size](https://facebook.github.io/create-react-app/docs/analyzing-the-bundle-size)

### Making a Progressive Web App

This section has moved here: [https://facebook.github.io/create-react-app/docs/making-a-progressive-web-app](https://facebook.github.io/create-react-app/docs/making-a-progressive-web-app)

### Advanced Configuration

This section has moved here: [https://facebook.github.io/create-react-app/docs/advanced-configuration](https://facebook.github.io/create-react-app/docs/advanced-configuration)

### Deployment

This section has moved here: [https://facebook.github.io/create-react-app/docs/deployment](https://facebook.github.io/create-react-app/docs/deployment)

### `npm run build` fails to minify

This section has moved here: [https://facebook.github.io/create-react-app/docs/troubleshooting#npm-run-build-fails-to-minify](https://facebook.github.io/create-react-app/docs/troubleshooting#npm-run-build-fails-to-minify)

### Modulos instalados

- react-number-format => para formater los numeros. ponerlos $3.000,0
- react-router-dom => para manejar las rutas en react

### Atajos

- rfc => para crear un componente de react.
- ES7+ React/Redux/React-Native snippets => es la extension utilizada para esto.

### Paculiaridades JSX

- link => <https://react.dev/learn/javascript-in-jsx-with-curly-braces>
- La palabra class esta reservada en JXS. En lugar de class hay que poner className
- La palabar for esta reservada en JXS. En lugar de for hay que poner htmlFor

<https://legacy.reactjs.org/docs/introducing-jsx.html>

### Operador spread

Permite a un elemento iterable tal como un arreglo o cadena ser expandido en lugares donde cero o más argumentos o elementos son esperados, o a un objeto ser expandido en lugares donde cero o más pares de valores clave son esperados.

function sum(x, y, z) {
  return x + y + z;
}

const numbers = [1, 2, 3];

console.log(sum(...numbers));
// Expected output: 6

<https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Spread_syntax>

### useState

useState es un hook en React que permite agregar estado a los componentes funcionales. Antes de los hooks, solo los componentes de clase podían manejar estado. Con useState, los componentes funcionales pueden recordar valores entre renderizados.

<https://react.dev/reference/react/useState>

#### Explicación:

- **useState(0):** Inicializa el estado con 0.
- **[contador, setContador]**
  - **contador**: es el valor actual del estado.
  - **setContador**: es la función para actualizarlo.
- **setContador(contador + 1)**: Modifica el estado y React vuelve a renderizar el componente con el nuevo valor.

useState es útil para manejar estados como:

- Contadores
- Formularios(inputs, checkboxes, etc)
- Mostrar y ocultar elementos (modales, menús, etc)

<https://react.dev/reference/react/useState>

### preventDefault

Es un método de los eventos en JavaScript que evita el comportamiento predeterminado de un elemento. En React, se usa comúnmente en formularios y enlaces para evitar acciones no deseadas, como el envío de un formulario o la navegación a otra página.

<https://developer.mozilla.org/en-US/docs/Web/API/Event/preventDefault>

### useEffect

Es un hook que permite manejar efectos secundarios en los componentes funcionales. Se usa para realizar tareas como:

- Llamadas a APIs
- Suscripciones a eventos
- Manipulación del DOM
- Temporizadores (setTimeout, setInterval)

useEffect(() => {  
  console.log("El contador cambió:",  contador);  
}, [contador]);  

1. **Primer argumento**: Una función que se ejecuta cuando React renderiza el componente.
2. **Segundo argumento ([contador])**: La dependencia. useEffect se ejecutará cada vez que contador cambie.
3. Para ejecutar el efecto solo una vez (por ejemplo, obtener datos de una API), se pasa(segundo argumento) un array vacío [].

<https://react.dev/reference/react/useEffect>

### react-router-dom

#### useParams

Es un **hook** de react-router-dom que permite acceder a los parámetros de la URL en un componente de React. Es útil cuando una ruta tiene valores dinámicos que cambian según el contenido.

- Es útil cuando necesitamos extraer valores de la URL en rutas dinámicas.
- Se usa comúnmente para mostrar contenido específico según el ID o categoría.
- Es parte del sistema de enrutamiento de react-router-dom y facilita la navegación en aplicaciones SPA.

#### useNavigate

Es un **hook** de react-router-dom que se usa para navegar programáticamente entre diferentes rutas en una aplicación de React.

##### Funcionamiento

El hook useNavigate devuelve una función que permite cambiar la ruta actual a otra dentro de la aplicación.

##### Conclusión

useNavigate es una herramienta poderosa en react-router-dom que permite cambiar de ruta de forma programática en React. Es la evolución del antiguo useHistory y facilita la navegación dentro de una SPA (Single Page Application).


