/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package specification.enties;

import entites.Plateforme;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Asus G75
 */
public class Canal extends Plateforme implements Serializable{
    
    private List<String> fichiersAssocies;
    
    /**
     *
     * @param id
     * @param nom
     * @throws RemoteException
     */
    public Canal(int id, String nom) throws RemoteException {
        super(id, nom);
        this.fichiersAssocies = new ArrayList<>();
    }
    
    public String toString() { 
        try {
            return this.getNomPlateforme();
        } catch (RemoteException ex) {
            Logger.getLogger(Canal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     *
     * @param fichiers
     */
    public void initFichiers(List<String> fichiers) {
        fichiersAssocies = fichiers;
    }
    
    /**
     *
     * @return
     */
    public List<String> getFichiers() {
        return this.fichiersAssocies;
    }
}