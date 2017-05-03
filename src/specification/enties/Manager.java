/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package specification.enties;

import entites.Utilisateur;
import java.rmi.RemoteException;

/**
 *
 * @author Asus G75
 */
public class Manager extends Utilisateur{
    
    public Manager(int idUser, String pseudoUser, String motDePasseUser) throws RemoteException {
        super(idUser, pseudoUser, motDePasseUser);
    }
    
}
