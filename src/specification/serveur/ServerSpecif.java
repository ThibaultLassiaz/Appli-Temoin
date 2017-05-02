/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package specification.serveur;

import Serveur.ServerImplementation;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import specification.enties.Canal;

/**
 *
 * @author Lucas
 */
public class ServerSpecif extends ServerImplementation implements ServerSpecifInterface{
    
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
    
    
    
}
