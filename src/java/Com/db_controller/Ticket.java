package Com.Database_Controller;

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

    public static class SchduleFields {
        static String ticket_id = "ticket_id";
        static String passenger_id = "passenger_id";
        static String flight_number = "flight_number";
        static String purchase_date = "purchase_date";
        static String seat_row = "seat_row";
    }

    public Ticket(ResultSet DataSet) throws SQLException {
        this.ticket_id = DataSet.getString("ticket_id");
        this.passenger_id = DataSet.getInt("passenger_id");
        this.purchase_date = DataSet.getDate("purchase_date");
        this.flight_number = DataSet.getInt("flight_number");
        this.seat_row = DataSet.getString("seat_row");
    }

}