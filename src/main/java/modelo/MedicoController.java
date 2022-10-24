
package modelo;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;

/**
 * FXML Controller class
 *
 * @author Vaio
 */
public class MedicoController implements Initializable 
{

    @FXML
    private TableColumn<?, ?> id;
    @FXML
    private TableColumn<?, ?> nom;
    @FXML
    private TableColumn<?, ?> dir;
    @FXML
    private TableColumn<?, ?> email;
    @FXML
    private TableColumn<?, ?> cel;
    @FXML
    private TableColumn<?, ?> des;
    @FXML
    private TableColumn<?, ?> fec;
    @FXML
    private TableColumn<?, ?> hor;
    private String colId  = "id";
    private final String colNombre = "nom";
    private final String colDir = "dir";
    private final String colCorreo = "email";
    private final String colTelefono = "cel";
    private final String colDescripcion = "des";
    private final String colFecha = "fec";
    private final String colHora = "hor";
    @FXML
    private TableView<Map> tablaPacientes;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    } 
    
    public ObservableList<Map> getTodosPacientes()
    {
        
       var sql = "SELECT * FROM paciente";
       //crear una coleccion vacia
       ObservableList<Map> pacientesList = FXCollections.observableArrayList();
               try {
            ConexionBD conexion = new ConexionBD();
                PreparedStatement consulta = conexion.getConexion().prepareStatement(sql);
                ResultSet resultSet = consulta.executeQuery();
                while(resultSet.next()){
                    Paciente paciente  = new Paciente(); 
                    Map<String, Object> coleccion = new HashMap<>();
                    paciente.setId(Integer.parseInt(resultSet.getString("id")));
                    paciente.setNombre(resultSet.getString("nombre"));
                    paciente.setDireccion(resultSet.getString("direccion"));
                    paciente.setCorreo(resultSet.getString("correo"));
                    paciente.setCelular(resultSet.getString("celular"));
                    paciente.setDescripcion(resultSet.getString("descripcion"));
                    paciente.setFecha(resultSet.getString("fecha"));
                    paciente.setHora(resultSet.getString("hora"));
                    //por cada fila creamos una nueva colecion
                    coleccion.put(colId, String.valueOf(resultSet.getInt("id")));
                    coleccion.put(colNombre, paciente.getNombre());
                    coleccion.put(colDir, paciente.getDireccion());
                    coleccion.put(colCorreo, paciente.getCorreo());
                    coleccion.put(colTelefono, paciente.getCelular());
                    coleccion.put(colDescripcion, paciente.getDescripcion());
                    coleccion.put(colFecha, paciente.getFecha());
                    coleccion.put(colHora, paciente.getHora());
                    pacientesList.add(coleccion);
                }
                resultSet.close();
                consulta.close();
        } catch (SQLException e) 
        {
            Mensaje.notificar(Alert.AlertType.ERROR, "mysql", "MedicoController dice:", e.getMessage());
        }
     return pacientesList;
       }
    
    private void llenarTabla()
    {  
        ObservableList<Map> lista = getTodosPacientes();
        this.id.setCellValueFactory(new MapValueFactory(colId));
        this.nom.setCellValueFactory(new MapValueFactory(colNombre));
        this.dir.setCellValueFactory(new MapValueFactory(colDir));
        this.email.setCellValueFactory(new MapValueFactory(colCorreo));
        this.cel.setCellValueFactory(new MapValueFactory(colTelefono));
        this.des.setCellValueFactory(new MapValueFactory(colDescripcion));
        this.fec.setCellValueFactory(new MapValueFactory(colFecha));
        this.hor.setCellValueFactory(new MapValueFactory(colHora));
        this.tablaPacientes.setItems(lista);  
    }
    
}
