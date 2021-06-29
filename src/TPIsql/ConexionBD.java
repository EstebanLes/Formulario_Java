package TPIsql;

import TPIFormulario.Empleado;
import TPIFormulario.JFUsuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Date;
import javax.swing.JOptionPane;

public class ConexionBD {
   
    private Connection conexion ;
         
     public Connection conectar() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/tpiempleados", "Esteban", "Esteban");

            System.out.println("Conectando  a la base de TPIempleados...................");

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);            
             JOptionPane.showMessageDialog(null, "No puede conectarse!!" + ex.getMessage());
        }
       return conexion;
    }
    
    public void RegistrarUsuario(String Usuario, String Pass1) {

        String SQL = "INSERT INTO registro (usuario, password) values (?,?)";
        try {
            PreparedStatement pst = conexion.prepareStatement(SQL);
            pst.setString(1, Usuario);
            pst.setString(2, Pass1);
            pst.execute();                           //pst.execute(SQL); esto me genera error en la insercion y no me dejaba cargar los datos                            
        } catch (SQLException ex) {
            Logger.getLogger(JFUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//     Metodo que me devuelve V o F si el usuario y pass se encuentra en la BD   
    public boolean Login( String Usuario, String Pass1 )  {
                
        String SQL = " SELECT * FROM registro WHERE Usuario = ? AND Password = ? ";
        try {
            PreparedStatement pst = conexion.prepareStatement(SQL);
            pst.setString(1, Usuario);
            pst.setString(2, Pass1);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {                
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
    public void IngresoEmpleado (int Legajo, String Nombre, String Apellido, String FechaNac, int DNI, String Genero, String Cargo, int SueldoBruto) {  
        
        String SQL = "INSERT INTO empleados (Legajo, Nombre, Apellido, FechaNac, DNI, Genero, Cargo, SueldoBruto) values (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = conexion.prepareStatement(SQL);
            
            pst.setInt(1, Legajo);
            pst.setString(2, Nombre);
            pst.setString(3, Apellido);
            pst.setDate(4, Date.valueOf(FechaNac));
            pst.setInt(5, DNI);
            pst.setString(6, Genero);
            pst.setString(7, Cargo);
            pst.setInt(8, SueldoBruto);
            pst.execute();  
        } catch (SQLException ex) {
            Logger.getLogger(JFUsuario.class.getName()).log(Level.SEVERE, null, ex);          
        }
    }    
    
      
    public Empleado BuscarEmpleado(int BuscarLegajo) throws SQLException{
      
        Empleado empleado = null;
        
        String SQL = " SELECT Legajo,Nombre,Apellido,FechaNac,DNI,Genero,Cargo,SueldoBruto FROM empleados WHERE Legajo=?";
        
        PreparedStatement pst = conexion.prepareStatement(SQL);
        pst.setInt(1, BuscarLegajo);
        ResultSet rs = pst.executeQuery();
        
        while (rs.next()) {
            int legajo = rs.getInt("Legajo");
            String nombre = rs.getString("Nombre");
            String apellido = rs.getString("Apellido");
            Date fechaNac = rs.getDate("FechaNac");
            int dni = rs.getInt("DNI");
            String genero = rs.getString("Genero");
            String cargo = rs.getString("Cargo");
            int sueldo = rs.getInt("SueldoBruto");
             
            empleado = new Empleado(legajo,nombre,apellido,fechaNac,dni,genero,cargo,sueldo);             
        }
        return empleado;      
    } 
}
