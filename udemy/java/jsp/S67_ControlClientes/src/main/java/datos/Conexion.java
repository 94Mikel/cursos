package datos;

import jakarta.activation.DataSource;
import java.sql.*;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author mikel
 */
public class Conexion {
    
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/control_clientes?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    
    private static final String JDBC_USER = "udemy";
    private static final String JDBC_PASSWORD = "chanchito";
    
    public static BasicDataSource getDataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(JDBC_URL);
        ds.setUsername(JDBC_USER);
        ds.setPassword(JDBC_PASSWORD);
        ds.setInitialSize(50);
        return ds;
    }
    
    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }
    
    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(PreparedStatement stmt){
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(Connection conn){
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
}
