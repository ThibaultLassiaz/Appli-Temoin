/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package specification.database;

import Serveur.database.DatabaseConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Lucas
 */
public class DatabaseConnexionEtendu extends DatabaseConnection{

    public DatabaseConnexionEtendu() throws SQLException, ClassNotFoundException {
        super();
    }
    
    public synchronized boolean checkAuthenticity(String login, String password) throws SQLException {
        try (Statement stmt = this.getConnection().createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT idUt FROM Utilisateur WHERE login='" + login + "' AND motDePasse='" + password + "'");
            return rs.next();
        } catch (SQLException e) {
            System.out.println("Erreur de connexion : " + e.getMessage());
            this.getConnection().rollback();
            return false;
        }
    }
}
