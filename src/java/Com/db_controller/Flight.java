package Com.db_controller;
import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@Data
public class Flight {

    private int flightNumber;
    private String AirlineId;
    private double flightPrice;
    private String flightFrom;
    private String flightTo;
    private Date flightStartTime;
    private Date flightEndTime;

    public static class FlightFields {
        static String flightNumber = "flightNumber";
        static String AirlineId = "AirlineId";
        static String flightPrice = "flightPrice";
        static String flightFrom = "flightFrom";
        static String flightTo = "flightTo";
        static String flightStartTime = "flightStartTime";
        static String flightEndTime = "flightEndTime";
    }

    public Flight(ResultSet DataSet) throws SQLException {
        this.flightNumber = DataSet.getInt("flightNumber");
        this.flightPrice = DataSet.getDouble("flightPrice");
        this.AirlineId = DataSet.getString("AirlineId");
        this.flightEndTime = DataSet.getDate("flightEndTime");
        this.flightStartTime = DataSet.getDate("flightStartTime");
        this.flightTo = DataSet.getString("flightTo");
        this.flightFrom = DataSet.getString("flightFrom");
    }

    public Flight(){
        this.flightNumber = 0;
        this.flightPrice = 0.0;
        this.AirlineId = " ";
        this.flightEndTime = new Date();
        this.flightStartTime = new Date();
        this.flightTo = " ";
        this.flightFrom = " ";
    }
}