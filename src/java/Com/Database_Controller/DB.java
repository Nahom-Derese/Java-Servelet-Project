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
            DB.connection = DriverManager.getConnection(url, user, "");
            System.out.println("DB Connection established......");
        } // If connection failed
        catch (SQLException | ClassNotFoundException ex) {
            System.out.println("DB Connection failed, Check XAMPP Server at port 3306 ....");
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        try {
            // If DB Connection Established Check if the Database Exists
            if (DB.connection != null) {
                System.out.println("Checking If The Database Exists ... ");
                rs = DB.connection.getMetaData().getCatalogs();
                while (rs.next()) {
                    String catalogs = rs.getString(1);

                    //  If the Database Exists, Great return the Connection
                    if (dbName.equals(catalogs)) {
                        System.out.println("The Database " + dbName + " Exists !");
                    } // If the Database Doesn't Exist, Run the "CREATE database Airlines_DB"
                    else {
                        System.out.println("The Database " + dbName + " Doesn't Exist , Creating DB...");
                        Statement stmt = DB.connection.createStatement();
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
        return DB.connection;
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
        // TABLE NAMES
        final String tablePassenger = "Passenger";
        final String tableFlight = "Flight";
        final String tableAirplane = "Airplane";
        final String tableReservation = "Reservation";
        final String tableTicket = "Ticket";
        final String tableAirline = "Airline";
        
        // DB DATA TYPES
        final String idType = "INTEGER PRIMARY KEY AUTOINCREMENT";
        final String boolType = "BOOLEAN NOT NULL";
        final String integerType = "INTEGER NOT NULL";
        final String dateTime = "DATETIME";
        final String textType = "VARCHAR(50)";
        final String longText = "VARCHAR(60)";
        final String doubleType = "NUMERIC NOT NULL";
        
        // CREATE TABLES IF THEY DON'T EXIST
        try{
            final Statement stmt = DB.connection.createStatement();
            stmt.execute(String.format("CREATE TABLE {} ( {} {}, {} {}, {} {})", tablePassenger, Passenger.PassengerFields.id, idType, Passenger.PassengerFields.creditCard, integerType, Passenger.PassengerFields.dateOfBirth, dateTime, Passenger.PassengerFields.email, textType, Passenger.PassengerFields.name, textType, Passenger.PassengerFields.password, textType, Passenger.PassengerFields.phoneNumber, textType));
            stmt.execute(String.format("CREATE TABLE {} ( {} {}, {} {}, {} {})", tableFlight, Flight.id, ));
            stmt.execute(String.format("CREATE TABLE {] ( {} {}, {} {}, {} {})", tableAirplane, Airplane.id, ));
            stmt.execute(String.format("CREATE TABLE {] ( {} {}, {} {}, {} {})", tableReservation, Reservation.id, ));
            stmt.execute(String.format("CREATE TABLE {] ( {} {}, {} {}, {} {})", tableTicket, Ticket.id, ));
            stmt.execute(String.format("CREATE TABLE {] ( {} {}, {} {}, {} {})", tableAirline, Airline.id, ));

        }catch(SQLException e){
            System.out.println(String.format("Error : {0}", e));
        }
  }

}
