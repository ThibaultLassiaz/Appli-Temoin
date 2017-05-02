/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import specification.enties.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hanene
 */
public class FicheInscriptionController implements Initializable {
    @FXML
    private TextField login;
    @FXML
    private TextField mdp;
    @FXML
    private Button inscripiton;
    @FXML
    private GridPane fiche;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void inscription(ActionEvent event) throws IOException {
        
        String log =login.getText();
        String motDePasse= mdp.getText();
        Stage s1 = (Stage) fiche.getScene().getWindow();
        
        if(log!=null && motDePasse!=null){
            
        }
        
        Parent root = FXMLLoader.load(getClass().getResource("AccueilChat.fxml"));
        Scene scene = new Scene(root);
        s1.setScene(scene);
        s1.show();
        
    }
    
}
