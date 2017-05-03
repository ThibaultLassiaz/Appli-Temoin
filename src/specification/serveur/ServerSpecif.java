/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package specification.serveur;

import Serveur.ServerImplementation;
import entites.ListeLien;
import entites.Utilisateur;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import specification.database.DatabaseConnexionEtendu;
import specification.database.DatabaseManager;
import specification.enties.Amitie;
import specification.enties.Canal;

/**
 *
 * @author Lucas
 */
public class ServerSpecif extends ServerImplementation implements ServerSpecifInterface{
    
    private final DatabaseConnexionEtendu dce = new DatabaseConnexionEtendu();
    private ArrayList<Canal> canaux = new ArrayList<>();
    private DatabaseManager dbm;
    
    public ServerSpecif() throws RemoteException, SQLException, ClassNotFoundException {
        super();
        initialiseServerSpecif();
        this.dbm = new DatabaseManager();
    }

    /**
     * @return the canaux
     * @throws java.rmi.RemoteException
     */
    @Override
    public ArrayList<Canal> getCanaux(int idUt) throws RemoteException{
        return this.getCanauxFromIdUtilisateur(idUt);
    }

    @Override
    public Utilisateur verifConnexion(String log, String mdp) throws SQLException, RemoteException {
        return dce.verifConnexion(log, mdp);
    }
    
    @Override
    public DatabaseConnexionEtendu getDCE() throws RemoteException{
        return this.dce;
    }

        /**
     * 
     * @param idUt l'identifiant d'un utilisateur de canal
     * @return une arrayList de canal où l'utilisateur d'identifiant idUt est présent
     */
    
    @Override
    public ListeLien<Amitie> getAmitie(Utilisateur u1) throws RemoteException, SQLException {
        ListeLien<Amitie> listeAmitie = dbm.getAmis(u1);
        return listeAmitie;
    }
    
    public ArrayList<Canal> getCanauxFromIdUtilisateur(int idUt) throws RemoteException{
        ArrayList<Canal> canauxUtilisateur = new ArrayList<>();
        for (Canal c : canaux) {
            if(c.contientUtilisateur(idUt)){
                canauxUtilisateur.add(c);
            }
        }
        
        return canauxUtilisateur;
    }
    
    /**
     * 
     * @param c un canal à ajouter à la liste de canals
     */
    public void ajoutCanal(Canal c){
        canaux.add(c);
    }
    
    /**
     * 
     * @param c un canal à supprimer de la liste de canals
     */
    public void supprimerCanal(Canal c) throws RemoteException{
        for(int i = 0; i < canaux.size(); i++){
            if(canaux.get(i).getIdPlateforme() == c.getIdPlateforme()){
                canaux.remove(i);
            }
        }
    }
    
    /**
     * 
     * @param c l'identifiant du canal à supprimer de la liste de canals
     */
    public void supprimerCanal(int c) throws RemoteException{
        for(int i = 0; i < canaux.size(); i++){
            if(canaux.get(i).getIdPlateforme() == c){
                canaux.remove(i);
            }
        }
    }
    /**
     * Creer les canaux et ce qu'ils contiennent à partir des données en base en appelant la fonction recuperationCanaux de DatabaseManager.
     * @throws SQLException 
     */
    private void initialiseServerSpecif() throws SQLException, RemoteException {
        ArrayList<Canal> arc;
        DatabaseManager dbm;
        try {
            dbm = new DatabaseManager();
            arc = dbm.recuperationCanaux();
            canaux.addAll(arc);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServerSpecif.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

}
