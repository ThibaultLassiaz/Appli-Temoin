/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package specification.serveur;

import Serveur.ServerInterface;
import entites.ListeLien;
import entites.Utilisateur;
import entites.interfaces._Utilisateur;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import specification.database.DatabaseConnexionEtendu;
import specification.enties.Amitie;
import specification.enties.Canal;
import specification.enties.Message;
/**
 *
 * @author Lucas
 */
public interface ServerSpecifInterface extends ServerInterface{
    
    public Utilisateur verifConnexion(String log, String mdp) throws SQLException, RemoteException;
    
    public DatabaseConnexionEtendu getDCE() throws RemoteException;
    
    public ArrayList<Canal> getCanaux(int idUt) throws RemoteException;
    
    public ListeLien<Amitie> getAmitie(Utilisateur u1) throws RemoteException, SQLException;

    public ArrayList<Message> getConversation(int idCanal) throws RemoteException, SQLException;
}
