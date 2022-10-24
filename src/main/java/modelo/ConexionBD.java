
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Vaio
 */
public class ConexionBD 
  {
        //Conexión Local
    public static Connection conectar(){
        try 
        {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/agendar_citas", "root", "");
            return cn;
        } catch (SQLException e)
        {
            System.out.println("Error en conexión local " + e);
        }
        return (null);
    }

    Object getConexion() 
    {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
