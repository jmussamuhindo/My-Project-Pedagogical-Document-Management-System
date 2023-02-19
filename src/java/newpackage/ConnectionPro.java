/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.sql.*;

/**
 *
 * @author IPRC KARONGI
 */
public class ConnectionPro {
    
    private static Connection con;
    
    public static Connection getConnection(){
        try{
	    
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pedagogical","root","");
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
