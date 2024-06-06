package web;

import datos.ClienteDaoJDBC;
import dominio.Cliente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author mikel
 */
@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.accionDefault(request, response);
    }
    
    private void accionDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Cliente> clientes = new ClienteDaoJDBC().listar();
        System.out.println("clientes = " + clientes);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("clientes", clientes);
        sesion.setAttribute("totalClientes", clientes.size());
        sesion.setAttribute("saldoTotal", this.calcularSaldoTotal(clientes));
        //Fordward genera que el url no cambie, 
        //insertando otra vez el cliente en la bd al refrescar la pagina
        //request.getRequestDispatcher("clientes.jsp").forward(request, response);
        response.sendRedirect("clientes.jsp");
    }
    
    private double calcularSaldoTotal(List<Cliente> clientes){
        double saldoTotal = 0;
        for (Cliente cliente : clientes) {
            saldoTotal += cliente.getSaldo();
        }
        return saldoTotal;
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
         
        String accion = request.getParameter("accion");
        if(accion != null){
            switch (accion) {
                case "insertar":
                    this.insertarCliente(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
                    break;
            }
        }else{
            this.accionDefault(request, response);
        }
    }
    
    private void insertarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //Recuperamos los valores del formulario agregarCliente
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = 0;
        String saldoString = request.getParameter("saldo");
        if(saldoString != null && !"".equals(saldoString)){
            saldo = Double.parseDouble(saldoString);
        }
        
        //Creamos el objeto de cliente (modelo)
        Cliente cliente= new Cliente(nombre, apellido, email, telefono, saldo);
        
        //Insertamos el nuevo objeto en la base de datos
        int registrosModificados = new ClienteDaoJDBC().insertar(cliente);
        System.out.println("registrosModificados = " + registrosModificados);
        
        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
    
}
