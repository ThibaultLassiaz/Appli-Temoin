/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package specification.enties;

import entites.Cercle;
import java.util.ArrayList;

/**
 *
 * @author Asus G75
 * @param <T>
 */
public class Groupe<T> extends Cercle{
    
    /**
     *
     * @param listeT
     * @param nomCercle
     */
    public Groupe(ArrayList<T> listeT, String nomCercle) {
        super(listeT, nomCercle);
    }
}
