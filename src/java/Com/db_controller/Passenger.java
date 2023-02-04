package Com.db_controller;
import lombok.Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;

@Data
public class Passenger {
    
    public static class PassengerFields {
        static String id = "userId";
        static String FirstName = "firstName";
        static String LastName = "lastName";
        static String Gender = "gender";
        static String password = "password";
        static String dateOfBirth = "dateOfBirth";
        static String PassportNumber = "passportNumber";
        static String Balance = "balance";
        static String Residence = "countryOfResidence";
        static String createdAt = "createdAt";
        static String updatedAt = "updatedAt";
        static String flight = "flight";
    }
    
    private int userId;
    private String firstName;
    private String lastName;
    private String password;
    private final Date dateOfBirth;
    private Double Balance;
    private String gender;
    private String countryOfResidence;
    private final Date createdAt;
    private Date updatedAt;
    private String passportNumber;
    private ArrayList<String> Flights;

    public Passenger(ResultSet DataSet) throws SQLException {
        this.userId = DataSet.getInt("userId");
        this.firstName = DataSet.getString("firstName");
        this.lastName = DataSet.getString("lastName");
        this.password = DataSet.getString("password");
        this.dateOfBirth = DataSet.getDate("dateOfBirth");
        this.Balance = DataSet.getDouble("balance");
        this.countryOfResidence = DataSet.getString("countryOfResidence");
        this.passportNumber = DataSet.getString("passportNumber");
        this.gender = DataSet.getString("gender");
        this.createdAt = DataSet.getDate("createdAt");
        this.updatedAt = DataSet.getDate("updatedAt");
    }
    public Passenger(){
        this.userId = 0;
        this.firstName = null;
        this.lastName = null;
        this.password = null;
        this.dateOfBirth = null;
        this.Balance = 0.0;
        this.countryOfResidence = null;
        this.passportNumber = null;
        this.gender = null;
        this.createdAt = null;
        this.updatedAt = null;
    }
    public Passenger(int id, String fname, String lname, String pass, Date birth, Double balance, String residence, String passport, String gender){
        this.userId = id;
        this.firstName = fname;
        this.lastName = lname;
        this.password = pass;
        this.dateOfBirth = birth;
        this.Balance =  balance;
        this.countryOfResidence = residence;
        this.passportNumber = passport;
        this.gender = gender;
        this.createdAt = Date.valueOf(LocalDate.now());
        this.updatedAt = Date.valueOf(LocalDate.now());
    }
    
    public String toString() { 
        return "FirstName:'" + this.firstName + 
                "'_LastName:'" + this.lastName +  
                "'_password:'" + this.password + 
                "'_Birthday:'" + this.dateOfBirth + 
                "'_Balance:'" + this.Balance +  
                "'_Country:'" + this.countryOfResidence +
                "'_Gender:'" + this.gender +  
                "'_createdAt:'" + this.createdAt +
                "'_updatedAt:'" + this.updatedAt +
                "'_passportNumber:'" + this.passportNumber + "'";
    }
}
