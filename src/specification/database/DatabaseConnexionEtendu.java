/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package specification.database;

import Serveur.database.DatabaseConnection;
import entites.Utilisateur;
import entites.interfaces._Utilisateur;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import specification.enties.Employe;
import specification.enties.Manager;

/**
 *
 * @author Lucas
 */
public class DatabaseConnexionEtendu extends DatabaseConnection implements DatabaseConnexionEtendueInterface, Serializable {

    /**
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public DatabaseConnexionEtendu() throws SQLException, ClassNotFoundException {
        super();
    }

    @Override
    public Utilisateur verifConnexion(String login, String password) throws SQLException, RemoteException {
        try (Statement stmt = this.getConnection().createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT idUt, login, motDePasse, typeUtilisateur FROM Utilisateur WHERE login='" + login + "' AND motDePasse='" + password + "'");
            while (rs.next()) {
                String typeUser = rs.getString(4);
                switch (typeUser) {
                    case "Employe":
                        Utilisateur e = new Employe(rs.getInt(1), rs.getString(2), rs.getString(3));
                        return e;
                    case "Manager":
                        Utilisateur m = new Manager(rs.getInt(1), rs.getString(2), rs.getString(3));
                        return m;
                }
            }
        } catch (SQLException e) {
            System.out.println("Erreur de connexion : " + e.getMessage());
        }
        return null;
    }
}
