import React from 'react'

export default function ListadoEmpleados() {
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
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th scope="row">1</th>
                        <td>Mark</td>
                        <td>Otto</td>
                        <td>@mdo</td>
                    </tr>
                    <tr>
                        <th scope="row">2</th>
                        <td>Jacob</td>
                        <td>Thornton</td>
                        <td>@fat</td>
                    </tr>
                    <tr>
                        <th scope="row">3</th>
                        <td colspan="2">Larry the Bird</td>
                        <td>@twitter</td>
                    </tr>
                </tbody>
            </table>

        </div>

    )
}
