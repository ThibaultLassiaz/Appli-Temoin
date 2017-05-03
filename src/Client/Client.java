/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import entites.Utilisateur;
import java.rmi.RemoteException;
import java.sql.SQLException;
import specification.database.DatabaseConnexionEtendu;
import specification.serveur.ServerSpecifInterface;

/**
 *
 * @author Lucas
 */
public class Client{
    private final ServerSpecifInterface serveur;
    private final Utilisateur client;
    private final String pseudo;
    boolean connecte = false;
    
    public Client(ServerSpecifInterface serveur, String log, String mdp) throws SQLException, RemoteException, ClassNotFoundException {
        DatabaseConnexionEtendu dce = new DatabaseConnexionEtendu();
        this.serveur = serveur;
        this.client = dce.verifConnexion(log, mdp);
        if(client!=null) {
            this.pseudo = this.client.getPseudo();
            this.connecte = true;
        } else {
            this.pseudo = "";
            this.connecte = false;
        }
        
    }
}
