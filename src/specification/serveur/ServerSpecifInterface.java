/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package specification.serveur;

import Serveur.ServerInterface;
import entites.FileExtended;
import entites.ListeLien;
import entites.Utilisateur;
import entites.interfaces._Utilisateur;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import specification.enties.Amitie;
import specification.enties.Canal;
import specification.enties.Message;
/**
 *
 * @author Lucas
 */
public interface ServerSpecifInterface extends ServerInterface{
    
    /**
     *
     * @param log
     * @param mdp
     * @return
     * @throws SQLException
     * @throws RemoteException
     */
    public Utilisateur verifConnexion(String log, String mdp) throws SQLException, RemoteException;
    
    /**
     *
     * @param idUt
     * @return
     * @throws RemoteException
     */
    public ArrayList<Canal> getCanaux(int idUt) throws RemoteException;
    
    /**
     *
     * @param u1
     * @return
     * @throws RemoteException
     * @throws SQLException
     */
    public ListeLien<Amitie> getAmitie(Utilisateur u1) throws RemoteException, SQLException;

    /**
     *
     * @param idCanal
     * @return
     * @throws RemoteException
     * @throws SQLException
     */
    public ArrayList<Message> getConversation(int idCanal) throws RemoteException, SQLException;
    
    /**
     *
     * @param fe
     * @param client
     * @throws RemoteException
     */
    public void uploadFichier(FileExtended fe, _Utilisateur client) throws RemoteException;
    
    /**
     *
     * @param fileName
     * @throws RemoteException
     */
    public void downloadFichier(String fileName) throws RemoteException;
    
    /**
     *
     * @param Message
     * @param user
     * @throws RemoteException
     */
    public void SendMessageToChannel(String Message, _Utilisateur user) throws RemoteException;

    /**
     *
     * @param login
     * @param password
     * @param couleur
     * @throws SQLException
     * @throws RemoteException
     */
    public void createUser(String login, String password, String couleur) throws SQLException, RemoteException;
    
    /**
     *
     * @param u
     * @throws SQLException
     * @throws RemoteException
     */
    public void eraseUser(Utilisateur u) throws SQLException, RemoteException;

}
