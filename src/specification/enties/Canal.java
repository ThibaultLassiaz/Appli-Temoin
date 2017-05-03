/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package specification.enties;

import entites.Plateforme;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Asus G75
 */
public class Canal extends Plateforme implements Serializable{
    
    public Canal(int id, String nom) throws RemoteException {
        super(id, nom);
    }
    
    public String toString() { 
        try {
            return this.getNomPlateforme();
        } catch (RemoteException ex) {
            Logger.getLogger(Canal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    } 
    
}