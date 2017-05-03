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
import specification.enties.Amitie;


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
     * @throws SQLException
     */
    public synchronized void SupprimerAmi(int idA) throws SQLException{
        Connection conn = this.getConnection();
        try (Statement stmt = conn.createStatement()){
            stmt.executeQuery("delete idA from Ami where idA = " +  idA + " " );
            conn.commit();
            System.out.println("Ami supprimé");
        }catch (SQLException e) {
            conn.rollback();
            System.out.println("Erreur de création de l'amitié : " + e.getMessage());
        }
    }
    /**
     * Récupère la liste d'ami d'un utilisateur
     * @param idUt
     * @throws SQLException 
     */
    public synchronized ArrayList<String> getAmis(int idUt) throws SQLException{
        Connection conn = this.getConnection();
        
        ArrayList<String> listeAmi = new ArrayList<String>();
        try (Statement stmt = conn.createStatement()){
           ResultSet rs= stmt.executeQuery("select idUt2 from Ami  join Uilisateur on (idUt2=idUt) where idUt1=" + idUt + " UNION select idUt1 from Ami join on (idUt1=idUt) where idUt2= " + idUt + " " );
           while (rs.next()){
                ResultSet rs1= stmt.executeQuery("select login from Utilisateur where idUt = " +rs+" ");
               String rs1A= rs1.getString(2);
                listeAmi.add(rs1A);
           } 
            conn.commit();
            System.out.println("Ami affiché");
        }catch (SQLException e) {
            conn.rollback();
            System.out.println("Erreur d'accès à l'ami : " + e.getMessage());
        }
        return listeAmi;
    }
        
    
    
}
