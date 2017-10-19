/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Bruger
 */
public class Connector
{

    private static final String IP = "138.197.176.14";
    private static final String PORT = "3306";
    private static final String DATABASE = "legohus";
    private static final String USERNAME = "esben";
    private static final String PASSWORD = "e0147b";
    
    private static Connection singleton;

    public static Connection connection() throws ClassNotFoundException, SQLException
    {
        if ( singleton == null ) {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE;
        singleton = (Connection) DriverManager.getConnection(url, USERNAME, PASSWORD);
        }
        return singleton;
    }
}
