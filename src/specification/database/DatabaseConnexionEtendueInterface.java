/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package specification.database;

import entites.Utilisateur;
import java.sql.SQLException;

/**
 *
 * @author Lucas
 */
public interface DatabaseConnexionEtendueInterface {
    
    public Utilisateur verifConnexion(String log, String mdp) throws SQLException;
    
}
