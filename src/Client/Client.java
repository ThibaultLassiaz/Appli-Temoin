/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import entites.Utilisateur;
import java.sql.SQLException;
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
    
    public Client(ServerSpecifInterface serveur, String log, String mdp) throws SQLException {
        this.serveur = serveur;
        this.client = this.serveur.verifConnexion(log, mdp);
        if(client!=null) {
            this.pseudo = this.client.getPseudo();
            this.connecte = true;
        } else {
            throw new RuntimeException("Echec de la connexion du client");
        }
        
    }
}
