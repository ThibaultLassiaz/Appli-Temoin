/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package specification.database;

import entites.Utilisateur;
import entites.interfaces._Utilisateur;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

/**
 *
 * @author Lucas
 */
public interface DatabaseConnexionEtendueInterface extends Remote {
    
    /**
     *
     * @param log
     * @param mdp
     * @return
     * @throws SQLException
     * @throws RemoteException
     */
    public Utilisateur verifConnexion(String log, String mdp) throws SQLException, RemoteException;
    
}
