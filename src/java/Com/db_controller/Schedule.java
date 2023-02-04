package Com.db_controller;
import lombok.Data;
import java.util.Date;

@Data
public class Schedule {
    private Date flightDay;
    private Date departureTime;
    private Date arrivalTime;
    private Flight flight;

    public static class ScheduleFields {
        static String flightDay = "flightDay";
        static String departureTime = "departureTime";
        static String arrivalTime = "arrivalTime";
        static String flight = "flight";
    }
}
