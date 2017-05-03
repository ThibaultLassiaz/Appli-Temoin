/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package specification.database;

import Serveur.database.DatabaseConnection;
import entites.interfaces._Utilisateur;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Lucas
 */
public class DatabaseConnexionEtendu extends DatabaseConnection implements DatabaseConnexionEtendueInterface, Serializable {

    public DatabaseConnexionEtendu() throws SQLException, ClassNotFoundException {
        super();
    }

    @Override
    public boolean verifConnexion(_Utilisateur utilisateur, String login, String password) throws SQLException, RemoteException {
        try (Statement stmt = this.getConnection().createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT idUt, login, motDePasse, typeUtilisateur FROM Utilisateur WHERE login='" + login + "' AND motDePasse='" + password + "'");
            while (rs.next()) {
                String typeUser = rs.getString(4);
                switch (typeUser) {
                    case "Employe":
                        utilisateur.setId(rs.getInt(1));
                        utilisateur.setPseudo(rs.getString(2));
                        utilisateur.setMotDePasse(rs.getString(3));
                        return true;
                    case "Manager":
                        utilisateur.setId(1);
                        utilisateur.setMotDePasse("mdp");
                        utilisateur.setMotDePasse(rs.getString(3));
                        return true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Erreur de connexion : " + e.getMessage());
        }
        return false;
    }
}
