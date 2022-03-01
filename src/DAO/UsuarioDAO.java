
package DAO;

import DTO.UsuarioDTO;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;

/**
 *
 * @author Natan
 */
public class UsuarioDAO {
    Connection conn;
    
    public ResultSet autentificaUsuario(UsuarioDTO objusuariodto){
        conn = new ConexaoDAO().conectaBD();
        try{
           String sql = "SELECT * FROM usuario WHERE user = ? AND senha = ?";
           
           PreparedStatement pstm = conn.prepareStatement(sql);
           pstm.setString(1, objusuariodto.getUser());
           pstm.setString(2, objusuariodto.getSenha());
           
           ResultSet rs = pstm.executeQuery();
    
           return rs;
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"UsuarioDAO erro::" + erro.getMessage());
            return null;
        }
    }     
}
