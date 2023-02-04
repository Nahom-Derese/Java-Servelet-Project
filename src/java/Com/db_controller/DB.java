package Com.db_controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ibatis.jdbc.ScriptRunner;

public class DB {

    public static final DB instance = new DB();

    private static Connection connection;
    public static String dbName = "airlines_db";
    final String tablePassenger = "Passenger";
    final String tableFlight = "Flight";
    final String tableSchedule = "Schedule";
    final String tableTicket = "Ticket";
    private ResultSet rs = null;

    public Connection getconnection() {

        // Trying to Connect to MYSQL DATABASE ON LOCALHOST
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/";
            String user = "root";
            DB.connection = DriverManager.getConnection(url, user, "");
            System.out.println("DB Connection established......");
        } // If connection failed
        catch (SQLException | ClassNotFoundException ex) {
            System.out.println("DB Connection failed, Check XAMPP Server at port 3306 ....");
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        try {
            boolean dbExists = false;
            // If DB Connection Established Check if the Database Exists
            if (DB.connection != null) {
                System.out.println("Checking If The Database Exists ... ");
                rs = DB.connection.getMetaData().getCatalogs();
                while (rs.next()) {
                    String catalogs = rs.getString(1);

                    //  If the Database Exists, Great return the Connection
                    if (dbName.equals(catalogs)) {
                        dbExists = true;
                        System.out.println("The Database " +  dbName + " Exists !");
                        break;
                    }
                 } 
                    // If the Database Doesn"t Exist, Run the "CREATE database Airlines_DB"
                    if(!dbExists){
                        System.out.println("The Database " + dbName + " Doesn't Exist , Creating DB...");
                        Statement stmt = DB.connection.createStatement();
                        try{
                            stmt.execute("CREATE DATABASE " + dbName);
                            createTables(DB.connection, dbName);
                            System.out.println("Database with Tables Created");
                        }
                        catch(SQLException e){
                            System.out.println("Error Creating Database");
                        }
                    }   
                }
             else {
                System.out.println("Unable To Create Database Connection");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try{
            String url = "jdbc:mysql://localhost:3306/"+ dbName;
            String user = "root";
            String password = "";
            Connection con = DriverManager.getConnection(url, user, password);
            DB.connection = con;
        }catch(Exception e){
            System.err.println("DB NOT EXISTS!!");
        }
        return DB.connection;
    }

    private DB() {}
  
    void createTables(Connection db, String dbName) throws SQLException, IOException {
        String url = "jdbc:mysql://localhost:3306/"+ dbName;
        String user = "root";
        String password = "";
        Connection con = DriverManager.getConnection(url, user, password);

        
        //Initialize the script runner
        ScriptRunner sr = new ScriptRunner(con);
        //Creating a reader object
        Reader reader = new BufferedReader(new FileReader("DB.sql"));
        //Running the script
        sr.runScript(reader);
        //Closing the reader object
        reader.close();
        //Closing the connection
        sr.closeConnection();
    }

    void clearDB(){
        try{
            final Statement db = DB.connection.createStatement();
            db.execute(String.format("DROP TABLE IF EXISTS {};", tablePassenger));
            db.execute(String.format("DROP TABLE IF EXISTS {};", tableFlight));
            db.execute(String.format("DROP TABLE IF EXISTS {};", tableTicket));
            db.execute(String.format("DROP TABLE IF EXISTS {};", tableSchedule));

            createTables(DB.connection, dbName);
        }catch(SQLException e){
            System.out.println(String.format("Error : {0}", e));
        }catch(FileNotFoundException e){
            System.out.println(String.format("Error : {0}", e));
        }catch(IOException e){
            System.out.println(String.format("Error : {0}", e));
        }
  }
  
    static void close() {
        final Connection db = instance.getconnection();
        try {
            db.close();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
