// CAPA DE DATOS

package datos;

import java.sql.*;

/**
 *
 * @author mikel
 * #Caracteristicas
 * * 
 */
public class Conexion {
    
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/udemydb";
    private static final String JDBC_USER = "udemy";
    private static final String JDBC_PASSWORD = "chanchito";
    
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(JDBC_URL,JDBC_USER, JDBC_PASSWORD);
    }
    
    //Para cerrar los objetos resulset, statement... Sobrecargamos el metodo
    public static void close(ResultSet rs) throws SQLException{
        rs.close();
    }
    
    public static void close(Statement smtm) throws SQLException{
        smtm.close();
    }
    
    /*
        Objeto statement:
            - Tenemos una interface llamada PrepareStatement, 
        normalmente se usa este metodo en mayor medida porque 
        un mejor performance que el objeto statement
        
        */
    
    public static void close(PreparedStatement smtm) throws SQLException{
        smtm.close();
    }
    
    public static void close(Connection conn) throws SQLException{
        conn.close();
    }
    
    
}
