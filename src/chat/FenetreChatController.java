/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Asus G75
 */
public class FenetreChatController implements Initializable {

    @FXML
    private TextField txtFieldEnvoiMessage;
    @FXML
    private Label labelListUser;
    @FXML
    private ListView<?> listMessages;
    @FXML
    private Button btnUploadFichier;
    @FXML
    private ListView<?> listFichiers;
    @FXML
    private Label labelDiscussWith;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
