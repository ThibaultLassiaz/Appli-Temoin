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

    /**
     *
     */
    public static ServerSpecifInterface serveur;

    /**
     *
     */
    public static Utilisateur client;

    /**
     *
     */
    public static int canalId;
//    private final String pseudo;
    boolean connecte = false;
    
    /**
     *
     * @throws SQLException
     * @throws RemoteException
     * @throws ClassNotFoundException
     * @throws NotBoundException
     * @throws MalformedURLException
     */
    public Client() throws SQLException, RemoteException, ClassNotFoundException, NotBoundException, MalformedURLException {
        Client.serveur = (ServerSpecifInterface) Naming.lookup("rmi://localhost/MultiChat");
        client = new Utilisateur(0, "rien", "rien");
        canalId = 0;
    }
        
    /**
     *
     * @param log
     * @param mdp
     * @return
     * @throws SQLException
     * @throws RemoteException
     */
    public boolean check(String log, String mdp) throws SQLException, RemoteException {
            client = serveur.verifConnexion(log, mdp);
            return client!=null;
        }
    }   
