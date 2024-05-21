
$(document).ready(function(){

	$.ajax({
		url: 'http://localhost:8080/peliculas',
		type: 'get',
		dataType: 'json'
	}).done(function (data){
		
		const peliculas = data;
		console.log(peliculas);

		var tableString = "<table>",

		body = document.getElementsByTagName('body')[0],
		div = document.createElement('div');
		div.setAttribute('class', 'table');
		tableString += "<th>";
		tableString += "<td><strong>" + "Titulo" + "</td></strong>" + "<td><strong>" + "Director" + "</strong></td>" 
		    + "<td><strong>" + "Fecha estreno" + "</strong></td>" + "<td><strong>" + "Descripcion" + "</strong></td>"
		    + "<td><strong>" + "Disponibilidad" + "</strong></td>" + "<td><strong>" + "Precio_alquiler" + "</strong></td>"
		tableString += "</th>";


		for (row = 0; row < peliculas.length; row += 1) {
			var pelicula = peliculas[row];
		    tableString += "<tr>";
		    tableString += "<td>" + pelicula.idpelicula + "</td>" +"<td>" + pelicula.titulo + "</td>" + "<td>" + pelicula.director + "</td>" 
		    + "<td>" + pelicula.fecha_estreno + "</td>" + "<td>" + pelicula.descripcion + "</td>"
		    + "<td>" + pelicula.disponibilidad + "</td>" + "<td>" + pelicula.precio_alquiler+"€" + "</td>";
		    
		    tableString += "</tr>";
		}

		tableString += "</table>";
		div.innerHTML = tableString;
		body.appendChild(div);
	   
	})

});