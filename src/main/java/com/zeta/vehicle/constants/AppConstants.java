package com.zeta.vehicle.constants;


import com.zeta.vehicle.dto.Location;
import com.zeta.vehicle.dto.TimeSlot;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author nikhil sharma created on 09/12/20
 */
public class AppConstants {

    // for understanding purpose it is 1, otherwise it will be 3600
    public static final int SECONDS_IN_HOUR = 1;
    public static final Function<Integer, Integer> HOUR_TO_SECOND = (hour) -> hour * SECONDS_IN_HOUR;

    // static data for slots
    public static TimeSlot timeSlot1 = new TimeSlot(HOUR_TO_SECOND.apply(9), HOUR_TO_SECOND.apply(12)); // 9 am to 12 pm
    public static TimeSlot timeSlot2 = new TimeSlot(HOUR_TO_SECOND.apply(14), HOUR_TO_SECOND.apply(17)); // 2 pm to 5 pm
    public static TimeSlot timeSlot3 = new TimeSlot(HOUR_TO_SECOND.apply(9), HOUR_TO_SECOND.apply(11)); // 9 am to 11 am
    public static TimeSlot timeSlot4 = new TimeSlot(HOUR_TO_SECOND.apply(13), HOUR_TO_SECOND.apply(15)); // 1 pm to 3 pm

    // static data for location
    public static Location location1 = new Location("location1", "address1", "New Delhi", "Delhi");
    public static Location location2 = new Location("location2", "address2", "Gurgaon", "Harayan");
    public static Location location3 = new Location("location3", "address3", "Bengaluru", "Karnataka");
    public static Location location4 = new Location("location4", "address4", "Noida", "Uttar Pradesh");

    // static data for dates
    public static List<LocalDate> dates = new ArrayList<>();
    private static int numberOfDaysDataToGenerate = 3;
    static {
        LocalDate today = LocalDate.now();
        for (int i=0; i<numberOfDaysDataToGenerate; i++) {
            dates.add(today.plusDays(i+1));
        }
    }

    public static Supplier<String> ID_GENERATOR = () -> UUID.randomUUID().toString();

}
