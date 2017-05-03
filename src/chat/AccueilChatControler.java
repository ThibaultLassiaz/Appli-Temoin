/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;


import entites.Utilisateur;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
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

    
    public ObservableList<Canal> data;
    public ObservableList<Button> dataButtonJoinCanal;
    public ObservableList<Utilisateur> dataAmitie;


    @FXML public void handleMouseClick(MouseEvent arg0) {
        System.out.println("clicked on " + listCanaux.getSelectionModel().getSelectedItem().getIdPlateforme());
    }
    
    @FXML public void handleMouseClickAmis(MouseEvent arg0) {
        System.out.println("clicked on " + listAmis.getSelectionModel().getSelectedItem().getId());
    }
    
    public void fillCanaux () {
        //ObservableList<Pair<String, Button>> data = FXCollections.observableArrayList();
        
        ObservableList<Canal> data = FXCollections.observableArrayList();
        
        Canal c1 = new Canal(1, "Hello");
        data.add(c1);
        data.add(new Canal(2,"Perso"));
        data.add(new Canal(3,"Amis"));
        data.add(new Canal(4,"Drogue dure"));
        data.add(new Canal(5,"Fun"));
        data.add(new Canal(6,"Partage de fichiers"));
        listCanaux.setItems(data);
        
        
       // listCanaux.setCellValueFactory(new PropertyValueFactory<>("NomPlateforme"));
        //tableCanaux.setItems(null);
        //tableCanaux.setItems(data);  
    }
    
    public void fillAmitie() {
        ObservableList<Utilisateur> data = FXCollections.observableArrayList();
        Employe e1 = new Employe(1, "Hugo", "mdp");
        Employe e2 = new Employe(2, "Thibault", "mdp", "Thibault", "LASSIAZ", new Date(07-07-1996), homme, "thibault@gmail.com");
        data.add(e1);
        data.add(e2);
        listAmis.setItems(data);
        
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Hello");
        fillCanaux();
        fillAmitie();
    }    

    @FXML
    private void deconnexion(ActionEvent event) {
    }
}



