/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import Client.Client;
import java.io.IOException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import specification.serveur.ServerSpecifInterface;

/**
 *
 * @author Asus G75
 */
public class LoginScreenControler implements Initializable {
    
    @FXML
    private Button btnConnexion;
    @FXML
    private PasswordField inputPassword;
    @FXML
    private TextField inputUser;
    @FXML
    private AnchorPane idAnchor;
    @FXML
    private Button btnInscription;
    
    @FXML
    private void btnConnectAction(ActionEvent event) throws IOException, NotBoundException, SQLException {      
        ServerSpecifInterface serveur = (ServerSpecifInterface) Naming.lookup("rmi://localhost/MultiChat");
        Client client = new Client(serveur, inputUser.getText(), inputPassword.getText());
        Stage s1 = (Stage) idAnchor.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("AccueilChat.fxml"));
        Scene scene = new Scene(root);
        s1.setScene(scene);
        s1.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }        

    @FXML
    private void btnInscription(ActionEvent event) throws IOException {
        Stage s1 = (Stage) idAnchor.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("FicheInscription.fxml"));
        Scene scene = new Scene(root);
        s1.setScene(scene);
        s1.show();
    }
}
