
package modelo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import javafx.application.Platform;
import javafx.scene.control.DatePicker;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Vaio
 */
public class CitaController implements Initializable {

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtDireccion;
    @FXML
    private TextField txtCorreo;
    @FXML
    private TextField txtNumero;
    @FXML
    private TextArea txtDescripcion;
    @FXML
    private TextField txtHora;
    @FXML
    private Button botonAgendar;
    @FXML
    private DatePicker txtFecha;
 
 

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }   
    @FXML
    private void agendarCita(ActionEvent event) 
    {
  
    int validacion = 0;
    String nombre, direccion, correo, numero, descripcion, fecha, hora;
    nombre = txtNombre.getText();
    direccion = txtDireccion.getText();
    correo = txtCorreo.getText();
    numero = txtNumero.getText();
    descripcion = txtDescripcion.getText();
    fecha = txtFecha.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    hora = txtHora.getText();
    //Todos los campos se tiene que llenar forzosamente
    if(nombre.equals(""))
    {
        validacion++;
    }
      if(direccion.equals(""))
      {
        validacion++;
    }
        if(correo.equals(""))
        {
        validacion++;
    }
          if(numero.equals(""))
          {
        validacion++;
    }
            if(descripcion.equals(""))
            {
        validacion++;
    }
              if(fecha.equals(""))
              {
        validacion++;
    }
                if(hora.equals(""))
                {
        validacion++;
    }
            try
            {
                Connection cn = ConexionBD.conectar();
                 PreparedStatement pst = cn.prepareStatement(
                         "select nombre from paciente where Fecha = '" + fecha + "'");
                 ResultSet rs = pst.executeQuery();
                 if (rs.next()) 
                 {
                     JOptionPane.showMessageDialog(null, "La cita ya ha sido agendada");
                     cn.close();
                } else 
                 {
                     cn.close();
                     if (validacion == 0) 
                     {
                         try {
                             Connection cn2 = ConexionBD.conectar();
                             PreparedStatement pst2 = cn2.prepareStatement("insert into paciente values(?,?,?,?,?,?,?,?)");
                             //Capturar los datos en la BD
            pst2.setInt(1,0);    
            pst2.setString(2,nombre);
            pst2.setString(3,direccion);
            pst2.setString(4,correo);
            pst2.setString(5,numero);
            pst2.setString(6,descripcion);
            pst2.setString(7,fecha);
            pst2.setString(8,hora);
            pst2.executeUpdate();
            cn2.close();
            Limpiar();
            JOptionPane.showMessageDialog(null, "Cita agendada");
            
                         } catch (Exception e) 
                         {
                             System.err.println("Error en registrar paciente" + e);
                              JOptionPane.showMessageDialog(null, "Error");
                         }
                     } else 
                     {
                         JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
                     }
                }
            }catch(SQLException e)
            {
                System.err.println("Error en validar nombre de paciente." + e);
                JOptionPane.showMessageDialog(null, "Error");
            }    
    }
public void Limpiar()
{
    //Los campos de vacian despues de agendar una cita
    txtNombre.setText("");
    txtDireccion.setText("");
    txtCorreo.setText("");
    txtNumero.setText("");
    txtDescripcion.setText("");
    txtFecha.getEditor().clear();
    txtHora.setText("");
}    

    @FXML
    private void cerrarAplicacion(ActionEvent event) 
    {
          Platform.exit();
    }
}
