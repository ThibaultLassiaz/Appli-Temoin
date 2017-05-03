/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package specification.serveur;

import Serveur.ServerImplementation;
import entites.Utilisateur;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import specification.database.DatabaseConnexionEtendu;
import specification.enties.Canal;

/**
 *
 * @author Lucas
 */
public class ServerSpecif extends ServerImplementation implements ServerSpecifInterface{
    
    private final DatabaseConnexionEtendu dce = new DatabaseConnexionEtendu();
    private final ArrayList<Canal> canaux = new ArrayList<>();
    
    public ServerSpecif() throws RemoteException, SQLException, ClassNotFoundException {
        super();
    }

    /**
     * @return the canaux
     */
    public ArrayList<Canal> getCanaux() {
        return canaux;
    }

    @Override
    public Utilisateur verifConnexion(String log, String mdp) throws SQLException {
        return dce.verifConnexion(log, mdp);
    }
    
        /**
     * 
     * @param idUt l'identifiant d'un utilisateur de canal
     * @return une arrayList de canal où l'utilisateur d'identifiant idUt est présent
     */
    public ArrayList<Canal> getCanauxFromIdUtilisateur(int idUt){
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
    public void supprimerCanal(Canal c){
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
    public void supprimerCanal(int c){
        for(int i = 0; i < canaux.size(); i++){
            if(canaux.get(i).getIdPlateforme() == c){
                canaux.remove(i);
            }
        }
    }

    
}
