/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package specification.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import Serveur.database.DatabaseConnection;
import entites.Utilisateur;
import java.sql.ResultSet;
import java.util.ArrayList;
import specification.enties.Canal;

/**
 *
 * @author Lucas
 */
public class DatabaseManager extends DatabaseConnection{
    
    public DatabaseManager() throws SQLException, ClassNotFoundException {
        super();
    }
    
    /**
     * Créer un utilisateur
     *
     * @param login login de l'utilisateur
     * @param password le mot de passe de l'utilisateur
     * @param couleur la couleur préféré de l'utilisateur
     * @throws SQLException
     */
    public synchronized void creationUtilisateur(String login, String password, String couleur) throws SQLException {
        Connection conn = this.getConnection();
        try (Statement stmt = conn.createStatement()) {
            //Récupère l'identifiant max
            int idMax = 0;
            ResultSet rset = stmt.executeQuery("SELECT max(idUt) from Utilisateur");
            while (rset.next()) {
                idMax = rset.getInt("max(idUt)") + 1;
            }
            //Creer l'utilisateur
            stmt.executeQuery("insert into Utilisateur(idUt, login, motDePasse, couleur) values ( " + idMax + ", '"
                    + login + "', '" + password + "', '" + couleur + "')");

            conn.commit();
            System.out.println("Utilisateur créé.");
        } catch (SQLException e) {
            conn.rollback();
            System.out.println("Erreur de création de l'utilisateur : " + e.getMessage());
        }

    }
    
    public synchronized ArrayList<Canal> recuperationCanaux() throws SQLException {
        Connection conn = this.getConnection();
        ArrayList<Canal> canaux = new ArrayList<>();
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT idC, nom FROM Conversation");
            while(rs.next()) {
                Canal c = new Canal(rs.getInt(1), rs.getString(2));
                Statement stmt1 = conn.createStatement();
                ResultSet rs1 = stmt1.executeQuery("SELECT idUt, login, motDePasse, typeUtilisateur FROM Utilisateur natural join Conversation_Utilisateur WHERE idC=" + rs.getString(1));

                while(rs1.next()){
                    c.addUser(new Utilisateur(rs1.getInt(1), rs1.getString(2), rs1.getString(3)));
                }
                canaux.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Erreur d'initialisation du serveur lors de la création des canaux : " + e.getMessage());
        }
        return canaux;

    }
}
