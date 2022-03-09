package DAO;


/**
 *
 * @author Natan
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexaoDAO {
    
    public Connection conectaBD(){
        
        Connection conn = null;   
        
        try{
            String url = "jdbc:mysql://localhost:3306/loja?user=root&password=";
            conn =  DriverManager.getConnection(url);
            
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Esse é o erro::" + erro.getMessage());
        }
        
    return conn;
    }   
}
