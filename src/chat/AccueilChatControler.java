/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;


import entites.Utilisateur;
import java.io.IOException;
import java.net.URL;
import Client.Client;
import entites.ListeLien;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Date;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import specification.enties.Amitie;
import specification.enties.Canal;
import specification.enties.Employe;
import static specification.enties.Employe.Sexe.homme;

/**
 * FXML Controller class
 *
 * @author Asus G75
 */



public class AccueilChatControler implements Initializable {

    @FXML
    private Button btnDeco;
    @FXML
    private ListView<Canal> listCanaux;
    @FXML
    private Label labelNom;
    @FXML
    private Label labelPrenom;
    @FXML
    private ListView<Utilisateur> listAmis;
    @FXML
    private AnchorPane idAnchor;


    @FXML public void handleMouseClick(MouseEvent arg0) throws IOException, RemoteException {
        System.out.println("clicked on " + listCanaux.getSelectionModel().getSelectedItem().getIdPlateforme());
        Stage s1 = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FenetreChat.fxml"));
        Scene scene = new Scene(root);
        s1.initModality(Modality.APPLICATION_MODAL);
        s1.setScene(scene);
        s1.show();
    }

    @FXML public void handleMouseClickAmis(MouseEvent arg0) throws IOException, RemoteException {
        System.out.println("clicked on " + listAmis.getSelectionModel().getSelectedItem().getId());
        Stage s1 = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FenetreChat.fxml"));
        Scene scene = new Scene(root);
        s1.initModality(Modality.APPLICATION_MODAL);
        s1.setScene(scene);
        s1.show();
    }
    
    public void fillCanaux () throws RemoteException {
        List<Canal> canaux = Client.serveur.getCanaux(Client.client.getId());
        ObservableList<Canal> canauxObservable = FXCollections.observableArrayList();
        
        canaux.forEach((c) -> {
            canauxObservable.add(c);
        });
        listCanaux.setItems(canauxObservable);
    }
    
    public void fillInfos() throws RemoteException {
        labelPrenom.setText("Vous êtes connecté en tant que " + Client.client.getPseudo());
    }
    
    public void fillAmitie() throws RemoteException, SQLException {

        ObservableList<Utilisateur> utilisateursObservable = FXCollections.observableArrayList();
        ListeLien<Amitie> listeAmis = Client.serveur.getAmitie(Client.client);
        System.out.println(listeAmis.getListelien().size());
        
        for(Amitie a : listeAmis.getListelien()) {
           utilisateursObservable.add(a.getU2());
        }
        
        listAmis.setItems(utilisateursObservable);    
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            fillCanaux();
        } catch(RemoteException e) {
            System.out.println(e.getMessage());
        }
        
        try {
            fillAmitie();
        } catch (RemoteException ex) {
            Logger.getLogger(AccueilChatControler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AccueilChatControler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            fillInfos();
        } catch (RemoteException ex) {
            Logger.getLogger(AccueilChatControler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void deconnexion(ActionEvent event) throws IOException {
        Stage s1 = (Stage) idAnchor.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
        Scene scene = new Scene(root);
        s1.setScene(scene);
        s1.show();
        Client.client = null;
        System.gc();
    }
}



