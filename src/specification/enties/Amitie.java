/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package specification.enties;

import entites.Lien;
import entites.Utilisateur;
import java.io.Serializable;

/**
 *
 * @author Asus G75
 */
public class Amitie extends Lien implements Serializable{
        
    /**
     *
     * @param s1
     * @param s2
     */
    public Amitie(Utilisateur s1, Utilisateur s2) {
       super(s1,s2);
    }  
}

