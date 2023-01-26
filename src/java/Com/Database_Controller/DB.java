package Com.Database_Controller;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DB {

    static final DB instance = new DB();

    private static Connection connection;
    private static String dbName = "Airlines_DB";
    private ResultSet rs = null;

    public Connection getconnection() {

        // Trying to Connect to MYSQL DATABASE ON LOCALHOST
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/User";
            String user = "root";
            this.connection = DriverManager.getConnection(url, user, "");
            System.out.println("DB Connection established......");
        } // If connection failed
        catch (SQLException | ClassNotFoundException ex) {
            System.out.println("DB Connection failed, Check XAMPP Server at port 3306 ....");
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        try {
            // If DB Connection Established Check if the Database Exists
            if (this.connection != null) {
                System.out.println("Checking If The Database Exists ... ");
                rs = this.connection.getMetaData().getCatalogs();
                while (rs.next()) {
                    String catalogs = rs.getString(1);

                    //  If the Database Exists, Great return the Connection
                    if (dbName.equals(catalogs)) {
                        System.out.println("The Database " + dbName + " Exists !");
                    } // If the Database Doesn't Exist, Run the "CREATE database Airlines_DB"
                    else {
                        System.out.println("The Database " + dbName + " Doesn't Exist , Creating DB...");
                        Statement stmt = this.connection.createStatement();
                        try{
                            stmt.execute("CREATE DATABASE " + dbName);
                            System.out.println("Database Created");
                        }
                        catch(SQLException e){
                            System.out.println("Error Creating Database");
                        }
                    }   
                    }
                }
             else {
                System.out.println("Unable To Create Database Connection");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return this.connection;
    }

    private DB() {}
    
    void close() {
        final Connection db = instance.getconnection();
        try {
            db.close();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
  

    void createTables(Connection db) {
        
        final String idType = "INTEGER PRIMARY KEY AUTOINCREMENT";
        final String boolType = "BOOLEAN NOT NULL";
        final String integerType = "INTEGER NOT NULL";
        final String nullabaleinteger = "INTEGER";
        final String textType = "TEXT NOT NULL";
        final String nullabaleText = "TEXT";
        final String doubleType = "NUMERIC NOT NULL";
        final Statement stmt = this.connection.createStatement();
        
        // CREATE TABLES IF THEY DON'T EXIST
        try{
            
            stmt.execute("PRAGMA foreign_keys = ON;");

            stmt.execute("CREATE TABLE $tableSubject ( ${SubjectFields.id} $idType, ${SubjectFields.name} $textType, ${SubjectFields.stream} $textType)");
            stmt.execute("CREATE TABLE $tableSubject ( ${SubjectFields.id} $idType, ${SubjectFields.name} $textType, ${SubjectFields.stream} $textType)");
            stmt.execute("CREATE TABLE $tableSubject ( ${SubjectFields.id} $idType, ${SubjectFields.name} $textType, ${SubjectFields.stream} $textType)");
            stmt.execute("CREATE TABLE $tableSubject ( ${SubjectFields.id} $idType, ${SubjectFields.name} $textType, ${SubjectFields.stream} $textType)");

        }catch(SQLException e){
            System.out.println(String.format("Error : {0}", e));
        }
  }

}
