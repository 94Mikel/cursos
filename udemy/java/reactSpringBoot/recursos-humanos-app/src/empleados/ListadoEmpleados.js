import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { NumericFormat } from 'react-number-format';
import { Link } from 'react-router-dom';

export default function ListadoEmpleados() {

    const urlBase = "http://localhost:8080/rh-app/empleados";

    //Arreglo. Utilizaremos el concepto de hub para estar pendiente de cualquier cambio de este arreglo
    //useState => para estar monitoreando los cambios de este arreglo
    const [empleados, setEmpleados] = useState([]);

    //Se manda a llamar cuando se carga la pagina
    useEffect(() => {
        cargarEmpleados();//Llamos a este metodo cuando se carga la página
    }, []);//con el arreglo vacio indicamos que se ejecutara solo una vez

    /*
        async => para llamadas asincronas
        await => para esperar la respuesta del backend
    */
    const cargarEmpleados = async () => {
        const resultado = await axios.get(urlBase);
        console.log("Resultado cargar empleados");
        console.log(resultado.data);
        setEmpleados(resultado.data);//La data obtenida añadimos a nuestro arreglo de empleados
    }

    const eliminarEmpleado = async id => {
        await axios.delete(`${urlBase}/${id}`);
        cargarEmpleados();
    }

    return (
        //Se utiliza className porque no es html, sino un archivo JavaScript con html embebido
        //La palabra class en una palabra reservada y no se puede utilizar en react porque utilizar internamente

        <div className='container'>
            <div className="container text-center" style={{ margin: "30px" }}>
                <h3>Sistema de Recursos Humanos</h3>
            </div>

            {/*
                table-striped => para que cada renglon tenga un color distinto 
                table-hover => para hacer efecto cuando se pasa el puntero
                align-midel => los elementos de la tabla los alineamos al centro de forma vertical
            */}

            <table className="table table-striped table-hover align-midel">
                <thead className='table-dark'>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Empleado</th>
                        <th scope="col">Departamento</th>
                        <th scope="col">Sueldo</th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                    {
                        //Iteramos el arreglo de empleados
                        //npm i react-number-format => para dar formato(numeric format)
                        empleados.map((empleado, indice) => (
                            <tr key={indice}>
                                <th scope="row">{empleado.idEmpleado}</th>
                                <td>{empleado.nombre}</td>
                                <td>{empleado.departamento}</td>
                                <td><NumericFormat
                                    value={empleado.sueldo}
                                    displayType={'text'}
                                    thousandSeparator=','
                                    prefix={'$'}
                                    decimalScale={2}
                                    fixedDecimalScale
                                /></td>
                                <td className='text-center'>
                                    <div>
                                        <Link 
                                            to={`/editar/${empleado.idEmpleado}`}
                                            className='btn btn-warning btn-sm me-3'
                                        >
                                            Editar
                                        </Link>
                                        <button
                                            onClick={() => eliminarEmpleado(empleado.idEmpleado)}
                                            className='btn btn-danger btn-sm'    
                                        >
                                            Eliminar
                                        </button>
                                    </div>
                                </td>
                            </tr>
                        ))
                    }
                </tbody>
            </table>

        </div>

    )
}
