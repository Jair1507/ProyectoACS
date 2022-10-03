/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package controlador;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Vaio
 */
public class NewFXMain extends Application 
   {
   private static Scene scene;
    
    @Override
    public void start(Stage primaryStage) throws IOException 
    {
        scene = new Scene(LoadFXML("/vista/menu"));
        primaryStage.setScene(scene);
        primaryStage.show();        
    }
    
    private static Parent LoadFXML(String fxml) throws IOException 
    {
        FXMLLoader fxmlLoader = new FXMLLoader(NewFXMain.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
        }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
    }    
}
