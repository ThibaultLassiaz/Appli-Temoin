/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package specification.enties;

import entites.Plateforme;
/**
 *
 * @author Asus G75
 */
public class Canal extends Plateforme{
    
    public Canal(int id, String nom) {
        super(id, nom);
    }
    
    public String toString() { 
    return this.getNomPlateforme();
} 
    
}