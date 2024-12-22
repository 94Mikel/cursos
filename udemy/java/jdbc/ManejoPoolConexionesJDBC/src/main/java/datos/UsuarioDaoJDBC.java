package datos;

import static datos.Conexion.*;
import domain.UsuarioDTO;
import java.sql.*;
import java.util.*;

/**
 *
 * @author mikel
 */
public class UsuarioDaoJDBC implements UsuarioDao{

    private static final String SQL_SELECT = "SELECT id_usuario, usuario, password FROM usuario";
    private static final String SQL_INSERT = "INSERT INTO usuario(usuario, password) VALUES(?,?)";
    private static final String SQL_UPDATE = "UPDATE usuario SET usuario=?, password=? WHERE id_usuario = ?";
    private static final String SQL_DELETE = "DELETE FROM usuario WHERE id_usuario = ?";

    @Override
    public List<UsuarioDTO> select() throws SQLException {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<UsuarioDTO> usuariosLista = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idUsuario = rs.getInt("id_usuario");
                String usuario = rs.getString("usuario");
                String password = rs.getString("password");
                usuariosLista.add(new UsuarioDTO(idUsuario, usuario, password));
            }

        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        
        return usuariosLista;
        
    }
    
    @Override
    public int insert(UsuarioDTO usuario) throws SQLException{
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getPassword());
            registros = stmt.executeUpdate();
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return registros;
        
    }
    
    @Override
    public int update(UsuarioDTO usuario) throws SQLException{
    
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getPassword());
            stmt.setInt(3,usuario.getIdUsuario());
            registros = stmt.executeUpdate();
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return registros;
        
    }
    
    @Override
    public int delete(UsuarioDTO usuario) throws SQLException{
    
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getIdUsuario());
            stmt.executeUpdate();
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return registros;
        
    }

}
