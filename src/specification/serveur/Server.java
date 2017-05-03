/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package specification.serveur;

import Serveur.database.DatabaseSQLRunner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import specification.database.DatabaseConnexionEtendu;

/**
 *
 * @author Lucas
 */
public class Server {
    
    public static void main(String[] args) throws RemoteException, MalformedURLException, SQLException, ClassNotFoundException, Exception {
        ServerSpecif server = new ServerSpecif();
        DatabaseConnexionEtendu dce = new DatabaseConnexionEtendu();
        DatabaseSQLRunner sqlrunner = new DatabaseSQLRunner(dce.getConnection());
        //sqlrunner.runSQLScript(new BufferedReader(new FileReader("D:\\RMI\\deleteBdChat.sql")));
        //sqlrunner.runSQLScript(new BufferedReader(new FileReader("D:\\RMI\\bdChat.sql")));
        
        server.start("localhost", "MultiChat");
    }
}
