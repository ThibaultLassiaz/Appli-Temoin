/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package specification.enties;

/**
 *
 * @author Lucas
 */
public class Message {
    private int idMessage;
    private int idC;
    private int idUt;
    private String message;

    public Message(int idMessage, int idC, int idUt, String message){
        this.idMessage = idMessage;
        this.idC = idC;
        this.idUt = idUt;
        this.message = message;
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
    
    
            
}
