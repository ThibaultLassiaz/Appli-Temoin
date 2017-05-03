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
import java.sql.ResultSet;

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
    
    /** 
     * Créer un lien d'amitié entre deux utilisateurs
     * @param idUt id de l'utilisateur courant
     * @param idUtilisateur id de l'utilisateur à ajouter en amitié
     * @throws SQLException
     */
    public synchronized void AjoutAmi( int idUt, int idUtilisateur) throws SQLException {
        Connection conn = this.getConnection();
        try (Statement stmt = conn.createStatement()) {
            //Récupère l'identifiant max
            int idMax = 0;
            ResultSet rset = stmt.executeQuery("SELECT max(idA) from Ami");
            while (rset.next()) {
                idMax = rset.getInt("max(idA)") + 1;
            }
        
            //Creer le lien d'amitié
            stmt.executeQuery("insert into Ami(idA, idUt1, idUt2) values ( " + idMax + ", '"
                    + idUt + "', '" + idUtilisateur+  "')");

            conn.commit();
            System.out.println("Ami créé.");
        } catch (SQLException e) {
            conn.rollback();
            System.out.println("Erreur de création de l'amitié : " + e.getMessage());
        }
     
    }
    
    /**
     * Suppression d'un lien d'amitié
     * @param idA id de l'amitié
     * @param idUt id de l'utilisateur courant
     * @param idUtilisateur id de l'utilisateur dont le lien d'amitié doit être supprimé
     * @throws SQLException
     */
    public synchronized void SupprimerAmi(int idA) throws SQLException{
        Connection conn = this.getConnection();
        try (Statement stmt = conn.createStatement()){
            stmt.executeQuery("delete idA from Ami where idA = " +  idA );
            conn.commit();
            System.out.println("Ami supprimé");
        }catch (SQLException e) {
            conn.rollback();
            System.out.println("Erreur de création de l'amitié : " + e.getMessage());
        }
    }
        
    
    
}
