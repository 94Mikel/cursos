package test;

import java.sql.*;

/**
 *
 * @author mikel
 */
public class TestPsqlJDBC {
    
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/udemy_java_s45";
    private static final String USER = "udemy";
    private static final String PASSWORD = "chanchito";
    private static final String SQL_SELECT = "SELECT id_persona, nombre, apellido, email, telefono FROM persona";
    
    public static void main(String[] args) {
        // -- Cadena de conexión --
        //useSSl => utilizar conexión segura.
        //useTimezone => utilizar zona horaria
        //serverTimezone => zona horaria
        try {
            //Para trabajar con aplicaciones web no locales. Si no se puede conectar lanzar excepcion.
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(DB_URL,USER, PASSWORD);
            Statement instruccion = conexion.createStatement();
            ResultSet resultado  = instruccion.executeQuery(SQL_SELECT);
            while (resultado.next()) {//si tenemos mas elemento que iterar                
                System.out.print("Id persona: "+resultado.getInt("id_persona"));
                System.out.print(" Nombre: "+resultado.getString("nombre"));
                System.out.print(" Apellido: "+resultado.getString("apellido"));
                System.out.print(" Email: "+resultado.getString("email"));
                System.out.print(" Telefono: "+resultado.getString("telefono"));
                System.out.println("");
            }
            resultado.close();
            instruccion.close();
            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
        
    }
}
