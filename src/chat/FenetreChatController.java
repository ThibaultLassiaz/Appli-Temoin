/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import Client.Client;
import entites.FileExtended;
import java.io.File;
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
import Client.Client;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import Client.Client;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private ListView<String> listFichiers;
    @FXML
    private Label labelDiscussWith;
    @FXML
    private AnchorPane idAnchor;
    @FXML
    private Button btnEnvoyer;
    
    /**
     *
     * @param arg0
     * @throws RemoteException
     */
    @FXML public void handleMouseClick(MouseEvent arg0) throws RemoteException {
        String nomFichier = listFichiers.getSelectionModel().getSelectedItem();
        downloadFile(nomFichier);
    }
    
    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void btnUploadFichier(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
        if(file!=null) {
            uploadFile(file);
            fillFichier();
            listFichiers.refresh();
        }
    }
    
    /**
     *
     * @throws RemoteException
     */
    public void InitConvName () throws RemoteException {
        labelDiscussWith.setText(Client.client.getCurrentPlateforme().getNomPlateforme());
    }
    

    private void downloadFile(String nomF) throws RemoteException {
        Client.serveur.downloadFichier(nomF);
    }


    private void uploadFile(File file) throws IOException {
        FileExtended fileExtended = new FileExtended(file);
        Client.serveur.uploadFichier(fileExtended, Client.client);
    }
    
    /**
     *
     * @throws RemoteException
     */
    public void fillFichier () throws RemoteException {
        Canal c = (Canal) Client.client.getCurrentPlateforme();
        List<String> fichiers = c.getFichiers();
        ObservableList<String> fichiersObservable = FXCollections.observableArrayList();
        
        fichiers.forEach((f) -> {
            fichiersObservable.add(f);
        });
        listFichiers.setItems(fichiersObservable);
    }
    
    /**
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws RemoteException
     * @throws NotBoundException
     * @throws MalformedURLException
     */
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
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            fillFichier();
        } catch (RemoteException ex) {
            Logger.getLogger(FenetreChatController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            fillChat();
        } catch (SQLException ex) {
            Logger.getLogger(FenetreChatController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FenetreChatController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(FenetreChatController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(FenetreChatController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(FenetreChatController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            InitConvName();
        } catch (RemoteException ex) {
            Logger.getLogger(FenetreChatController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            fillChat();
        } catch (SQLException | ClassNotFoundException | RemoteException | NotBoundException | MalformedURLException ex) {
            Logger.getLogger(FenetreChatController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            fillFichier();
        } catch (RemoteException ex) {
            Logger.getLogger(FenetreChatController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            fillChat();
        } catch (SQLException | ClassNotFoundException | RemoteException | NotBoundException | MalformedURLException ex) {
            Logger.getLogger(FenetreChatController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void onEnter(ActionEvent event) throws SQLException, ClassNotFoundException, RemoteException, NotBoundException, MalformedURLException {
        Client.serveur.SendMessageToChannel(txtFieldEnvoiMessage.getText(), Client.client);
        fillChat();
        listMessages.refresh();   
    }

    @FXML
    private void SendMessage(ActionEvent event) throws RemoteException, SQLException, ClassNotFoundException, NotBoundException, MalformedURLException {
        Client.serveur.SendMessageToChannel(txtFieldEnvoiMessage.getText(), Client.client);
        fillChat();
        listMessages.refresh(); 
    }
}
