/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package specification.enties;

import entites.Lien;
import entites.Utilisateur;

/**
 *
 * @author Asus G75
 */
public class Famille extends Lien{
    
    /**
     *
     * @param u1
     * @param u2
     */
    public Famille(Utilisateur u1, Utilisateur u2) {
        super(u1, u2);
    }
    
}
