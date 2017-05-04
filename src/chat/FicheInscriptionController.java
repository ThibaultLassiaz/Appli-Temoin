/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;


import Client.Client;
import specification.enties.*;
import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import specification.database.DatabaseManager;

/**
 * FXML Controller class
 *
 * @author hanene
 */
public class FicheInscriptionController implements Initializable {
    @FXML
    private TextField login;
    
    @FXML
    private Button inscripiton;
    @FXML
    private GridPane fiche;
    @FXML
    private TextField couleur;
    @FXML
    private PasswordField mdp;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void inscription(ActionEvent event) throws IOException, NotBoundException, SQLException, RemoteException, ClassNotFoundException {

        String log =login.getText();
        String motDePasse= mdp.getText();
        String colour = couleur.getText();
        Stage s1 = (Stage) fiche.getScene().getWindow();
       
        if(log!=null && motDePasse!=null && colour!=null){
           
            //DatabaseManager dtb= new DatabaseManager();
            Client client = new Client();
               
            //dtb.getConnection();
            Client.serveur.createUser(log, colour, colour);
            Parent root = FXMLLoader.load(getClass().getResource("AccueilChat.fxml"));
            Scene scene = new Scene(root);
            s1.setScene(scene);
            s1.show();
        }
    }
   
}
