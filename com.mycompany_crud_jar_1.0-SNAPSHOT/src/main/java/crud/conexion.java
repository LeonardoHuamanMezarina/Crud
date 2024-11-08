
package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class conexion {
    
    String host = "127.0.0.1";
    String bd = "crud";
    String puerto = "3306";
    String jdbc = "jdbc:mysql://"+ host + ":" + puerto + "/" + bd;
    String user = "root";
    String password = "logan695";
    
    Connection con = null;
    
    public conexion(){
        try {
            
            con = DriverManager.getConnection(jdbc, user, password);
            
            if (con != null)
            
            JOptionPane.showMessageDialog(null, "La conexion fue todo un éxito");
            
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "La conexion de base de datos ha fallado");
        }
        
    }
    
    
    public Connection getConexion (){
        
        return con;
    
    }
   
  
    
    
}
