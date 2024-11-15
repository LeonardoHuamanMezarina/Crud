package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class conexiones {
    
    String bd = "crud";
    String user = "root";
    String password = "logan695";
    String puerto = "3306";
    String hostname = "127.0.0.1";
    
    String  jdbc= "jdbc:mysql://" + hostname + ":" +puerto+ "/" + bd;
    
    Connection con;
    
    public conexiones(){
    
            try {
                
                con = DriverManager.getConnection(jdbc, user, password);
                
                JOptionPane.showMessageDialog(null, "La base de datos conectado");

            } catch (Exception e) {
                
                JOptionPane.showMessageDialog(null, "Fallo la conexion" + e);
                
            }
}
    
    public Connection getConexion(){
        
        return con;
    
    
    }
    
}
