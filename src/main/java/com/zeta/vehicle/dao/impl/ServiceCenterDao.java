package com.zeta.vehicle.dao.impl;

import com.zeta.vehicle.dao.IServiceCenterDao;
import com.zeta.vehicle.dto.ServiceCenter;
import com.zeta.vehicle.dto.TimeSlot;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.zeta.vehicle.constants.AppConstants.*;


/**
 * @author nikhil sharma created on 09/12/20
 */
public class ServiceCenterDao implements IServiceCenterDao {

    private Map<String, ServiceCenter> serviceCenterById = new HashMap<>();

    // constructor will initialize all the static data
    public ServiceCenterDao() {

        List<TimeSlot> sc1Slots = Arrays.asList(timeSlot1, timeSlot2);
        Map<LocalDate, List<TimeSlot>> dayWiseSlotSc1 = new HashMap<>();
        for (LocalDate date : dates) {
            dayWiseSlotSc1.put(date, sc1Slots);
        }
        ServiceCenter serviceCenter1 = new ServiceCenter("Self1", "Self1", location1, true, dayWiseSlotSc1);

        List<TimeSlot> sc2Slots = Arrays.asList(timeSlot1, timeSlot2);
        Map<LocalDate, List<TimeSlot>> dayWiseSlotSc2 = new HashMap<>();
        for (LocalDate date : dates) {
            dayWiseSlotSc2.put(date, sc2Slots);
        }
        ServiceCenter serviceCenter2 = new ServiceCenter("Self2", "Self2", location2, true, dayWiseSlotSc2);

        List<TimeSlot> sc3Slots = Arrays.asList(timeSlot3, timeSlot4);
        Map<LocalDate, List<TimeSlot>> dayWiseSlotSc3 = new HashMap<>();
        for (LocalDate date : dates) {
            dayWiseSlotSc3.put(date, sc3Slots);
        }
        ServiceCenter serviceCenter3 = new ServiceCenter("Self3", "Self3", location3, true, dayWiseSlotSc3);

        List<TimeSlot> sc4Slots = Arrays.asList(timeSlot3, timeSlot4);
        Map<LocalDate, List<TimeSlot>> dayWiseSlotSc4 = new HashMap<>();
        for (LocalDate date : dates) {
            dayWiseSlotSc4.put(date, sc4Slots);
        }
        ServiceCenter serviceCenter4 = new ServiceCenter("Self4", "Self4", location4, true, dayWiseSlotSc4);


        serviceCenterById.put(serviceCenter1.getId(), serviceCenter1);
        serviceCenterById.put(serviceCenter2.getId(), serviceCenter2);
        serviceCenterById.put(serviceCenter3.getId(), serviceCenter3);
        serviceCenterById.put(serviceCenter4.getId(), serviceCenter4);
    }

    /*
        This method will query database in actual
        Data like location, slots, names will be provided by Service Center via some portal
     */
    @Override
    public List<ServiceCenter> getOwnedServiceCenters() {

        return serviceCenterById.values().stream().collect(Collectors.toList());

    }

    /*
        This will be a DB call to get by id
     */
    @Override
    public ServiceCenter getById(String id) {
        return serviceCenterById.get(id);
    }

}
