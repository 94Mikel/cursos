// CAPA DE DATOS
package datos;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author mikel #Caracteristicas *
 */
public class Conexion {

    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/udemydb";
    private static final String JDBC_USER = "udemy";
    private static final String JDBC_PASSWORD = "chanchito";
    private static BasicDataSource dataSource;

    public static DataSource getDataSource() {
        if (dataSource == null) {
            dataSource = new BasicDataSource();
            dataSource.setUrl(JDBC_URL);
            dataSource.setUsername(JDBC_USER);
            dataSource.setPassword(JDBC_PASSWORD);
            //Definimos el tamano inicial de pool de conexiones
            //Hay que tener cuidado de cuantas conexiones realizar ya que consume recursos.
            //Se inicia con un tamaño pequeño y se va incrementando segun demanda.
            dataSource.setInitialSize(50);
        }

        return dataSource;
    }

    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }

    //Para cerrar los objetos resulset, statement... Sobrecargamos el metodo
    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void close(Statement smtm) throws SQLException {
        smtm.close();
    }

    /*
        Objeto statement:
            - Tenemos una interface llamada PrepareStatement, 
        normalmente se usa este metodo en mayor medida porque 
        un mejor performance que el objeto statement
        
     */
    public static void close(PreparedStatement smtm) throws SQLException {
        smtm.close();
    }

    public static void close(Connection conn) throws SQLException {
        conn.close();
    }

}
