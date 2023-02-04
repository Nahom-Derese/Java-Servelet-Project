package Com.db_controller;

import lombok.Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@Data
public class Ticket {
    private String ticket_id;
    private int passenger_id;
    private int flight_number;
    private Date purchase_date;
    private String seat_row;

    public static class TicketFields {
        static String ticket_id = "ticket_id";
        static String passenger_id = "userId";
        static String flight_number = "flightNumber";
        static String purchase_date = "purchase_date";
        static String seat_row = "seat_row";
    }

    public Ticket(ResultSet DataSet) throws SQLException {
        this.ticket_id = DataSet.getString("ticket_id");
        this.passenger_id = DataSet.getInt("userId");
        this.purchase_date = DataSet.getDate("flightNumber");
        this.flight_number = DataSet.getInt("purchase_date");
        this.seat_row = DataSet.getString("seat_row");
    }

}