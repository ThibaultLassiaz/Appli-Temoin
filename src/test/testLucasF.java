/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entites.Utilisateur;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import specification.enties.Canal;
import specification.serveur.ServerSpecif;

/**
 *
 * @author Lucas
 */
public class testLucasF {
    public static void main(String[] args) throws RemoteException, SQLException, ClassNotFoundException{
        System.out.print("Test Lucas...");
        ServerSpecif ss = new ServerSpecif();
        
        Canal c1 = new Canal(1, "canal1");
        Canal c2 = new Canal(2, "canal2");
        Canal c3 = new Canal(3, "canal3");
        Canal c4 = new Canal(4, "canal4");   
        
        Utilisateur u1 = new Utilisateur(1, "freyssil", "aaa");
        Utilisateur u2 = new Utilisateur(2, "guezel", "bbb");
        Utilisateur u3 = new Utilisateur(3, "lassiazt", "ccc");
        Utilisateur u4 = new Utilisateur(4, "hedrachh", "ddd");
        Utilisateur u5 = new Utilisateur(5, "bodianga", "eee");
        Utilisateur u6 = new Utilisateur(6, "charroan", "fff");
        
        c1.addUser(u1);
        c1.addUser(u2);
        c1.addUser(u3);
        c1.addUser(u4);
        
        c2.addUser(u1);
        c2.addUser(u2);
        c2.addUser(u3);
        
        c3.addUser(u4);
        c3.addUser(u5);
        c3.addUser(u6);
        
        c4.addUser(u1);
        c4.addUser(u2);
        c4.addUser(u3);
        c4.addUser(u4);
        c4.addUser(u5);
        c4.addUser(u6);
        
        ss.ajoutCanal(c1);
        ss.ajoutCanal(c2);
        ss.ajoutCanal(c3);
        ss.ajoutCanal(c4);
        
        /*
        ArrayList<Canal> arc = ss.getCanauxFromIdUtilisateur(5);
        for (Canal arc1 : arc) {
            System.out.println("A");
        }
        System.out.println("Alors?");
        */
        
        System.out.println("ccc");
        System.out.println(ss.getCanaux().size());
        ss.supprimerCanal(c1);
        System.out.println(ss.getCanaux().size());
                
    }
}