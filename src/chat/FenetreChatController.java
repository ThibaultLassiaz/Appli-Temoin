/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import Client.Client;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import specification.enties.Canal;
import specification.enties.Message;

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
    private ListView<Message> listMessages;
    @FXML
    private Button btnUploadFichier;
    @FXML
    private ListView<?> listFichiers;
    @FXML
    private Label labelDiscussWith;
    @FXML
    private AnchorPane idAnchor;
    
    
    private void btnUploadFichier(ActionEvent event) throws IOException {
        Stage s1 = (Stage) idAnchor.getScene().getWindow();
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open File");
        chooser.showOpenDialog(new Stage());
    }
    


    
    public void fillFichier () {
        
    }
    
    public void fillChat() throws SQLException, ClassNotFoundException, RemoteException, NotBoundException, MalformedURLException {
        ArrayList<Message> messages = Client.serveur.getConversation(Client.canalId);
        ObservableList<Message> messagesObservable = FXCollections.observableArrayList();
        messages.forEach((m) -> {
            messagesObservable.add(m);
        });
        listMessages.setItems(messagesObservable);
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fillFichier();
        try {
            fillChat();
        } catch (SQLException | ClassNotFoundException | RemoteException | NotBoundException | MalformedURLException ex) {
            Logger.getLogger(FenetreChatController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
