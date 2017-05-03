/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package specification.serveur;

import Serveur.ServerImplementation;
import entites.Utilisateur;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import specification.database.DatabaseConnexionEtendu;
import specification.enties.Canal;

/**
 *
 * @author Lucas
 */
public class ServerSpecif extends ServerImplementation implements ServerSpecifInterface{
    
    private final DatabaseConnexionEtendu dce = new DatabaseConnexionEtendu();
    private final ArrayList<Canal> canaux = new ArrayList<>();
    
    public ServerSpecif() throws RemoteException, SQLException, ClassNotFoundException {
        super();
    }

    /**
     * @return the canaux
     */
    public ArrayList<Canal> getCanaux() {
        return canaux;
    }

    @Override
    public Utilisateur verifConnexion(String log, String mdp) throws SQLException, RemoteException {
        return dce.verifConnexion(log, mdp);
    }
    
    
    
}
