package com.zeta.vehicle.partner;

import com.zeta.vehicle.dto.ServiceCenter;
import com.zeta.vehicle.dto.TimeSlot;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.zeta.vehicle.constants.AppConstants.*;
import static com.zeta.vehicle.constants.AppConstants.location1;

/**
 * @author nikhil sharma created on 09/12/20
 */
public class Partner2 implements IPartner {

    @Override
    public List<ServiceCenter> getServiceCentres() {

        // this will be a remote call to each partner in parallel

        List<TimeSlot> sc1Slots = Arrays.asList(timeSlot1, timeSlot2);
        Map<LocalDate, List<TimeSlot>> dayWiseSlotSc1 = new HashMap<>();
        for (LocalDate date : dates) {
            dayWiseSlotSc1.put(date, sc1Slots);
        }
        ServiceCenter serviceCenter1 = new ServiceCenter("Partner2", "Partner2", location2, false, dayWiseSlotSc1);

        return Arrays.asList(serviceCenter1);
    }

}
