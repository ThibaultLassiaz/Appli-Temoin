/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package specification.enties;

import java.io.Serializable;

/**
 *
 * @author Lucas
 */
public class Message implements Serializable{
    private int idMessage;
    private int idC;
    private int idUt;
    private String message;
    private String loginUt;
    private String couleur;

    /**
     *
     * @param idMessage
     * @param idC
     * @param idUt
     * @param message
     */
    public Message(int idMessage, int idC, int idUt, String message){
        this.idMessage = idMessage;
        this.idC = idC;
        this.idUt = idUt;
        this.message = message;
    }
    
    /**
     *
     * @param idMessage
     * @param idC
     * @param idUt
     * @param message
     * @param loginUt
     * @param couleur
     */
    public Message(int idMessage, int idC, int idUt, String message, String loginUt, String couleur){
        this.idMessage = idMessage;
        this.idC = idC;
        this.idUt = idUt;
        this.message = message;
        this.loginUt = loginUt;
        this.couleur = couleur;
    }
    
    /**
     * @return the idMessage
     */
    public int getIdMessage() {
        return idMessage;
    }

    /**
     * @param idMessage the idMessage to set
     */
    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    /**
     * @return the idC
     */
    public int getIdC() {
        return idC;
    }

    /**
     * @return the idUt
     */
    public int getIdUt() {
        return idUt;
    }

    /**
     * @param idUt the idUt to set
     */
    public void setIdUt(int idUt) {
        this.idUt = idUt;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
    
    @Override
    public String toString(){
        return this.loginUt + " : " + this.getMessage();
    }

    /**
     * @return the loginUt
     */
    public String getLoginUt() {
        return loginUt;
    }

    /**
     * @param loginUt the loginUt to set
     */
    public void setLoginUt(String loginUt) {
        this.loginUt = loginUt;
    }

    /**
     * @return the couleur
     */
    public String getCouleur() {
        return couleur;
    }

    /**
     * @param couleur the couleur to set
     */
    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
            
}
