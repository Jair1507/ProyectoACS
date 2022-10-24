package modelo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Vaio
 */
public class MenuController implements Initializable 
{

    @FXML
    private Button btnMedico;
    @FXML
    private Button btnPaciente;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }    

    @FXML
    private void IngresarPaciente(ActionEvent event) 
    {
                 try 
                 {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/cita.fxml"));
            
            Stage secundaryStage = new Stage();
            
            Pane pane2 = (Pane) loader.load();
            
            Scene scene = new Scene (pane2);
            
            secundaryStage.initModality(Modality.APPLICATION_MODAL);
            secundaryStage.setScene(scene);
            secundaryStage.showAndWait();
        } catch (IOException ex) 
        {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @FXML
    private void IngresarMedico(ActionEvent event) 
    {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/medico.fxml"));
            
            Stage secundaryStage = new Stage();
            
            Pane pane2 = (Pane) loader.load();
            
            Scene scene = new Scene (pane2);
            
            secundaryStage.initModality(Modality.APPLICATION_MODAL);
            secundaryStage.setScene(scene);
            secundaryStage.showAndWait();
        } catch (IOException ex) 
        {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
     @FXML
    private void cerrarVentana(ActionEvent event) {
        Platform.exit();
    }
}

   
