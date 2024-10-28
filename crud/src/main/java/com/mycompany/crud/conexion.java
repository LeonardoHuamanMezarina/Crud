
package com.mycompany.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class conexion {
    
    Connection conectar = null;
    
    String usuario = "root";
    String contraseña = "logan695";
    String bd = "crud";
    String ip = "127.0.0.1";
    String puerto = "3306";
    
    String cadena = "jdbc:mysql://" + ip + ":" + puerto + "/" + bd ;

    public Connection estableConexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection(cadena, usuario, contraseña);
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos" + e.toString());
        }
        return conectar;
    }
    
    
}
