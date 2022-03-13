
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
    PreparedStatement pstm;
    public ResultSet rs;
    
    public ResultSet autentificaUsuario(UsuarioDTO objusuariodto){
        conn = new ConexaoDAO().conectaBD();
        try{
           String sql = "SELECT * FROM usuario WHERE user = ? AND senha = ?";
           
           pstm = conn.prepareStatement(sql);
           
           pstm.setString(1, objusuariodto.getUser());
           pstm.setString(2, objusuariodto.getSenha());
           
           rs = pstm.executeQuery();
    
           return rs;
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"autentificaUsuario erro::" + erro.getMessage());
            return null;
        }
    }
    
    public ResultSet cadastrarUsuario(UsuarioDTO objcadastraruser){
        conn = new ConexaoDAO().conectaBD();
        try{
           String sql = "INSERT INTO usuario (nome, user, senha)" 
                +  "VALUES (?, ?, ?)";
           
           pstm = conn.prepareStatement(sql);
           
           pstm.setString(1, objcadastraruser.getNome());
           pstm.setString(2, objcadastraruser.getUser());
           pstm.setString(3, objcadastraruser.getSenha());
           
           pstm.executeUpdate();
    
           return null;       
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"cadastrarUsuario erro::" + erro.getMessage());
            return null;
        }
    }
    
    public ResultSet listarUsuario(){
        conn = new ConexaoDAO().conectaBD();
        String sql = ("SELECT id FROM usuario");
        
        try{               
           pstm = conn.prepareStatement(sql);
           
           return pstm.executeQuery();
           
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "listarUsuario erro:: " + erro.getMessage());
            return null;
        }
    }
    
    public ResultSet carregarCampos(UsuarioDTO objusuariodto){
        int id;
        String sql = ("SELECT * FROM usuario WHERE id = ?");
                     
        try{                 
           pstm = conn.prepareStatement(sql);
           
           pstm.setInt(1, objusuariodto.getId());
           
           rs = pstm.executeQuery();
           
           UsuarioDTO objUsuarioDTO = new UsuarioDTO();
           objUsuarioDTO.setNome(rs.getString("nome"));
           objUsuarioDTO.setSenha(rs.getString("senha"));
           objUsuarioDTO.setUser(rs.getString("user"));
           
           return rs;
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "carregarCampos erro:: " + erro.getMessage());
            return null;
        }
    }
    
    public ResultSet atualizarUsuario(UsuarioDTO objatualizaruser){
        conn = new ConexaoDAO().conectaBD();
        try{
           String sql = ("UPDATE usuario SET nome = ?, user = ?, senha = ? "
                   + "WHERE id = ?");
           
           pstm = conn.prepareStatement(sql);
           
           pstm.setString(1, objatualizaruser.getNome());
           pstm.setString(2, objatualizaruser.getUser());
           pstm.setString(3, objatualizaruser.getSenha());
           pstm.setInt   (4, objatualizaruser.getId());
           
           pstm.executeUpdate();
    
           return null;       
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"atualizarUsuario erro::" + erro.getMessage());
            return null;
        }
    }
    
}
