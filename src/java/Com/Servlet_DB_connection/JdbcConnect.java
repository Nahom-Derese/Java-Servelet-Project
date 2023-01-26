package com.Servlet_DB_connection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class JdbcConnect {
    
    static Connection con;
    
    public Connection CreateConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/User";
            String usr="root";
            con = DriverManager.getConnection(url,usr,"");
            
        }catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(JdbcConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}