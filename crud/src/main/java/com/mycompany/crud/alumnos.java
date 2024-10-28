
package com.mycompany.crud;

/*--==== Librería para Conexión y Manejo de SQL ====-- */
import com.mysql.cj.protocol.Resultset;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*--==== Librería para Interfaz Gráfica (Swing) ====-- */
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/*--==== Librería para Manejo Avanzado de Tablas (Swing) ====-- */
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class alumnos {


    int codigo;
    String nombreAlumnos;
    String apellidosAlumnos;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreAlumnos() {
        return nombreAlumnos;
    }

    public void setNombreAlumnos(String nombreAlumnos) {
        this.nombreAlumnos = nombreAlumnos;
    }

    public String getApellidosAlumnos() {
        return apellidosAlumnos;
    }

    public void setApellidosAlumnos(String apellidosAlumnos) {
        this.apellidosAlumnos = apellidosAlumnos;
    }
    
    
    
    
    public void InsertarAlumno(JTextField paranNombre, JTextField paranApellidos){
        setNombreAlumnos(paranNombre.getText());
        setApellidosAlumnos(paranApellidos.getText());
        
        conexion objetoConexion = new conexion();
        
        String consulta = "insert into Alumnos (nombres , apellidos ) value (?,?);";
        
        try {
            
            CallableStatement cs = objetoConexion.estableConexion().prepareCall(consulta);
            
            cs.setString(1, getNombreAlumnos());
            cs.setString(2, getApellidosAlumnos());
            
            cs.execute();
                
            JOptionPane.showMessageDialog(null, "Se insertó correctamente el alumno");
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "No se insertó correctamente el alumno: " + e.toString());
            
        }
    
    }
    
    public void MostrarAlumnos(JTable paramTablaTotalalumnos){
        
        conexion objetoConexion = new conexion();
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<TableModel>(modelo);
        paramTablaTotalalumnos.setRowSorter(OrdenarTabla);
        
        String sql = "";
        
        modelo.addColumn("Id");
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");
        
        paramTablaTotalalumnos.setModel(modelo);
        
        sql = "select * from Alumnos";
        
        String[] datos = new String[3];
        
        Statement st;
        
        try {
                
            st = objetoConexion.estableConexion().createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
                
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                
                modelo.addRow(datos);
                
                
            }
            paramTablaTotalalumnos.setModel(modelo);
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null,"No se pudo mostrar el registro" + e.toString());
        }
    }
    
    public void SeleccionarAlumnos (JTable paramTablaAlumnos, JTextField paramId, JTextField paramNombres, JTextField paramApellidos){
        
        try {
            
            int fila = paramTablaAlumnos.getSelectedRow();
            
            if ( fila >= 0) {
                paramId.setText((String) (paramTablaAlumnos.getValueAt(fila, 0)));
                paramNombres.setText((String) (paramTablaAlumnos.getValueAt(fila, 1)));
                paramApellidos.setText((String) (paramTablaAlumnos.getValueAt(fila, 2)));
            
            }
            else {
                
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
               
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de selección" + e.toString());
        }
    
    }
    
    public void ModificarAlumnos (JTextField paramCodigo,  JTextField paramNombres, JTextField paramApellidos){
        
        setCodigo(Integer.parseInt(paramCodigo.getText()));
        setNombreAlumnos(paramNombres.getText());
        setApellidosAlumnos(paramApellidos.getText());
        
        conexion objetoConexion = new conexion();
        
        String consulta = "update Alumnos set alumnos.nombres = ? , alumnos.apellidos = ?  where alumnos.id=?";
        try {
            CallableStatement cs = objetoConexion.estableConexion().prepareCall(consulta);
            cs.setString(1, getNombreAlumnos());
            cs.setString(2, getApellidosAlumnos());
            cs.setInt(3, getCodigo());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Modificación exitosa");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se modificó, error" + e.toString());
            
        }
    }
    
    public void EliminarAlumnos (JTextField paramCodigo){
        setCodigo(Integer.parseInt(paramCodigo.getText()));
        
        conexion objetoconexion = new conexion();
        
        String consulta = "delete from Alumnos where alumnos.id = ?;";
        
        try {
            CallableStatement cs = objetoconexion.estableConexion().prepareCall(consulta);
            cs.setInt(1, getCodigo());
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se eliminó correctamente el Alumno");
            
            
        } catch (Exception e) {
            
                        
            JOptionPane.showMessageDialog(null, "No se pudo eliminar : " + e.toString());
        }
    }
}
