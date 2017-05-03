/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import entites.Utilisateur;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import specification.database.DatabaseConnexionEtendu;
import specification.serveur.ServerSpecifInterface;

/**
 *
 * @author Lucas
 */
public class Client{
    public static ServerSpecifInterface serveur;
    public static Utilisateur client;
//    private final String pseudo;
    boolean connecte = false;
    
    public Client() throws SQLException, RemoteException, ClassNotFoundException, NotBoundException, MalformedURLException {
        Client.serveur = (ServerSpecifInterface) Naming.lookup("rmi://localhost/MultiChat");
        client = new Utilisateur(0, "rien", "rien");
    }
        
        public boolean check(String log, String mdp) throws SQLException, RemoteException {
            return serveur.verifConnexion(client, log, mdp);
        }
    }   
