/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import framework.java.Amitie;
import framework.java.Canal;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Asus G75
 */



public class AccueilChatControler implements Initializable {

    @FXML
    private TableView<Canal> tableCanaux;
    @FXML
    private TableView<?> friendList;
    @FXML
    private Button btnDeco;
    @FXML
    private TableColumn<Canal, String> listCanaux;
    @FXML
    private TableColumn<Button, Boolean> btnJoinCanal;
    @FXML
    private Label labelNom;
    @FXML
    private Label labelPrenom;

    
    public ObservableList<Canal> data;
    public ObservableList<Button> dataButtonJoinCanal;
    public ObservableList<Amitie> dataAmitie;
    
    
    public ArrayList getUserFromBD () {
        ArrayList listParam = new ArrayList();
        // JDBC getUser
        return listParam;
    }
    
    public void instanceUser( String typeUser, ArrayList ar) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> classPourInstance = Class.forName(typeUser);
        Object instance = classPourInstance.newInstance();
        //Penser a créer un type grade
        // Mettre un case pour instancier ?
    }
    
    public void fillCanaux () {
          
        //ObservableList<Pair<String, Button>> data = FXCollections.observableArrayList();
        Canal c1 = new Canal(1, "Hello");
        ObservableList<Canal> data = FXCollections.observableArrayList();
        
        data.add(c1);
        
        dataButtonJoinCanal = FXCollections.observableArrayList();
        dataButtonJoinCanal.add(new Button("Test"));
        data.add(new Canal(2,"Perso"));
        data.add(new Canal(3,"Amis"));
        data.add(new Canal(4,"Drogue dure"));
        data.add(new Canal(5,"Fun"));
        data.add(new Canal(6,"Partage de fichiers"));
        
        listCanaux.setCellValueFactory(new PropertyValueFactory<>("NomPlateforme"));
        btnJoinCanal.setCellValueFactory(new PropertyValueFactory<>("btnPlateforme"));
        tableCanaux.setItems(null);
        tableCanaux.setItems(data);
    }
    
    public void fillAmitie() {
        data = FXCollections.observableArrayList();  
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Hello");
        fillCanaux();
    }    

    @FXML
    private void deconnexion(ActionEvent event) {
    }
    
}



