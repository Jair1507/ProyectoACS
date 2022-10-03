/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import javafx.scene.control.Alert;

/**
 *
 * @author Vaio
 */
public class Mensaje 
{
     public static void notificar(Alert.AlertType tipo, String titulo, String cabecera, String contenido){
    
    Alert notificacion = new Alert(tipo);
    notificacion.setHeaderText(cabecera);
    notificacion.setTitle(titulo);
    notificacion.setContentText(contenido);
    notificacion.showAndWait();
    
    }
}
