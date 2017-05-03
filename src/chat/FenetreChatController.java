/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import entites.FileExtended;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import Client.Client;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import specification.enties.Canal;

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
    private ListView<String> listFichiers;
    @FXML
    private Label labelDiscussWith;
    @FXML
    private AnchorPane idAnchor;
    
    @FXML
    public void btnUploadFichier(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
        if(file!=null) {
            uploadFile(file);
        }
    }
    

    private void uploadFile(File file) throws IOException {
        FileExtended fileExtended = new FileExtended(file);
        Client.serveur.uploadFichier(fileExtended, Client.client);
    }
    
    public void fillFichier () throws RemoteException {
        Canal c = (Canal) Client.client.getCurrentPlateforme();
        List<String> fichiers = c.getFichiers();
        ObservableList<String> fichiersObservable = FXCollections.observableArrayList();
        
        fichiers.forEach((f) -> {
            fichiersObservable.add(f);
        });
        listFichiers.setItems(fichiersObservable);
    }
    
    public void fillChat() {
        
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            fillFichier();
        } catch (RemoteException ex) {
            Logger.getLogger(FenetreChatController.class.getName()).log(Level.SEVERE, null, ex);
        }
        fillChat();
    }    
    
}
