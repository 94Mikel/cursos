package mx.com.gm.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import mx.com.gm.domain.Alumno;
import mx.com.gm.domain.Contacto;
import mx.com.gm.domain.Domicilio;
import mx.com.gm.service.ServicioAlumno;

@WebServlet("/ServletModificar")
public class ServletModificar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String IdAlumnoS = request.getParameter("idAlumno");
        Integer idAlumno = Integer.parseInt(IdAlumnoS);

        Alumno alumno = new Alumno();
        alumno.setIdAlumno(idAlumno);

        ServicioAlumno servicioAlumno = new ServicioAlumno();
        alumno = servicioAlumno.encontrarAlumno(alumno);

        //request.setAttribute("alumno", alumno);
        //guardamos en una session el alumno para seguir obteniendo el valor en el metodo doPost
        HttpSession sesion = request.getSession();
        sesion.setAttribute("alumno", alumno);

        request.getRequestDispatcher("/WEB-INF/modificarAlumno.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Creamos la instacia de ServicioAlumno para realizar acciones.
        ServicioAlumno servicioAlumno = new ServicioAlumno();
        
        String modificar = request.getParameter("Modificar");
        
        if (modificar != null) {
            //--- CASO DE MODIFICAR ---
            
            //Alumno
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");

            //Domicilio
            String calle = request.getParameter("calle");
            String noCalle = request.getParameter("noCalle");
            String pais = request.getParameter("pais");

            //Contacto
            String email = request.getParameter("email");
            String telefono = request.getParameter("telefono");

            //Recuperamos los objetos desde la sesion
            HttpSession sesion = request.getSession();
            Alumno alumno = (Alumno) sesion.getAttribute("alumno");

            alumno.setNombre(nombre);
            alumno.setApellido(apellido);
            alumno.getDomicilio().setCalle(calle);
            alumno.getDomicilio().setNoCalle(noCalle);
            alumno.getDomicilio().setPais(pais);
            alumno.getContacto().setEmail(email);
            alumno.getContacto().setTelefono(telefono);

            //Se guardara de forma automatica el domicilio y el contacto ya que tenemo la persistencia en cascada
            
            //Este servicio se comunicara con la capa de datos para insertar los datos en la base de datos
            servicioAlumno.guardarAlumno(alumno);

            //Quitamos el objeto de alumno que esta en la sesion. Dejamos de propagarlo.
            sesion.removeAttribute("alumno");
        } else {
            //Caso de eliminar
            //Recuperamos el idAlumno
            String idAlumnoS = request.getParameter("idAlumno");
            Integer idAlumno = Integer.parseInt(idAlumnoS);
            Alumno alumno = new Alumno();
            alumno.setIdAlumno(idAlumno);
            servicioAlumno.eliminarAlumno(alumno);
        }

        //redireccionamos a la pagina principal index
        request.getRequestDispatcher("/index.jsp").forward(request, response);

    }

}
