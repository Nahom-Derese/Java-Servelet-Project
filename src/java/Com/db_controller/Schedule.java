package Com.Database_Controller;
import lombok.Data;
import java.util.Date;

@Data
public class Schedule {
    private Date flightDay;
    private Date departureTime;
    private Date arrivalTime;
    private Flight flight;

    public static class ScheduleFields {
        static String flightDay = "flight_day";
        static String departureTime = "departure_time";
        static String arrivalTime = "arrival_time";
        static String flight = "flight";
    }
}
