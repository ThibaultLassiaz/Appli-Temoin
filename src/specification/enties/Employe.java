/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package specification.enties;

import entites.Utilisateur;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hanene
 */
public class Employe extends Utilisateur {
    //private int id;
   // private String pseudo;
    private String nom;
    private String prenom;
    private Date dateNais;

    /**
     *
     */
    public enum Sexe{

        /**
         *
         */
        homme, 

        /**
         *
         */
        femme};
    private Sexe sexe;
    private String email;
   // private String motDePasse;
    
    /**
     *
     * @param id
     * @param pseudo
     * @param mdp
     * @throws RemoteException
     */
    public Employe(int id, String pseudo, String mdp) throws RemoteException {
        super(id, pseudo, mdp);
    }
    
    /**
     *
     * @param id
     * @param pseudo
     * @param mdp
     * @param prenom
     * @param nom
     * @param dateNais
     * @param sexe
     * @param email
     * @throws RemoteException
     */
    public Employe(int id, String pseudo, String mdp, String prenom, String nom, Date dateNais, Sexe sexe, String email) throws RemoteException {
        super(id, pseudo, mdp);
        this.prenom=prenom;
        this.nom=nom;
        this.dateNais=dateNais;
        this.sexe=sexe;
        this.email=email;
        
    }
    
    
    public String toString(){ 
    if(this.getNom() != null && this.getPrenom() != null)
    {
    return this.getNom() + " " + this.getPrenom();
    }
    else {
        try {
            return this.getPseudo();
        } catch (RemoteException ex) {
            Logger.getLogger(Employe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        return null;
} 
    
    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the dateNais
     */
    public Date getDateNais() {
        return dateNais;
    }

    /**
     * @param dateNais the dateNais to set
     */
    public void setDateNais(Date dateNais) {
        this.dateNais = dateNais;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
