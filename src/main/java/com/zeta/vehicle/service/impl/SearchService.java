package com.zeta.vehicle.service.impl;

import com.zeta.vehicle.dto.Location;
import com.zeta.vehicle.dto.ServiceCenter;
import com.zeta.vehicle.dto.TimeSlot;
import com.zeta.vehicle.exception.ServiceCenterException;
import com.zeta.vehicle.service.IProviderService;
import com.zeta.vehicle.service.ISearchService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author nikhil sharma created on 09/12/20
 */
public class SearchService implements ISearchService {

    private IProviderService providerService = new ProviderService();

    /**
     * Optimization will be provided in this api via
     *      caching list of service centers which are sent as response
     *      invalidating the list once cache miss of if any 3rd party provider added new SC in a particular location
     *
     * @param location
     * @return
     * @throws ServiceCenterException
     */
    @Override
    public List<ServiceCenter> searchByLocation(String location) throws ServiceCenterException {

        List<ServiceCenter> serviceCentersByLocation = new ArrayList<>();

        // get all service centers from the database / search store like ElasticSearch
        List<ServiceCenter> serviceCenters = providerService.getServiceCenters();
        if (serviceCenters == null || serviceCenters.isEmpty()) {
            throw new ServiceCenterException("Service Centers not found for location : "+ location);
        }

        // filter all service centers by location
        serviceCentersByLocation = serviceCenters.stream()
                .filter(sc -> serviceCenterPresentInLocation(sc, location))
                .collect(Collectors.toList());

        // return filtered list
        return serviceCentersByLocation;
    }

    /**
     * Response can be cached based on
     *      "date-to-from" as a cache key
     *
     * Optimization can be done that only slots applicable to user search can be sent
     *
     * @param date
     * @param to
     * @param from
     * @return
     * @throws ServiceCenterException
     */
    @Override
    public List<ServiceCenter> searchBySlotsInDay(LocalDate date, int to, int from) throws ServiceCenterException {

        List<ServiceCenter> serviceCentersByLocation = new ArrayList<>();

        // get all service centers from the database / search store like ElasticSearch
        List<ServiceCenter> serviceCenters = providerService.getServiceCenters();
        if (serviceCenters == null || serviceCenters.isEmpty()) {
            throw new ServiceCenterException("Service Centers not found");
        }

        // filter all service centers by date & slots
        serviceCentersByLocation = serviceCenters.stream()
                .filter(sc -> serviceCenterAvailable(sc, date, to, from))
                .collect(Collectors.toList());

        return serviceCentersByLocation;
    }

    private boolean serviceCenterPresentInLocation(ServiceCenter sc, String location) {

        if (sc != null && sc.getLocation() != null) {
            Location address = sc.getLocation();
            if (address.getCity() != null && address.getCity().equals(location))
                return true;
            else if (address.getState() != null && address.getState().equals(location))
                return true;
        }

        return false;
    }

    private boolean serviceCenterAvailable(ServiceCenter sc, LocalDate date, int to, int from) {

        if (sc != null && sc.getSlots() != null && !sc.getSlots().isEmpty()) {
            List<TimeSlot> slotsOfDay = sc.getSlots().get(date);
            if (slotsOfDay != null && !slotsOfDay.isEmpty()) {
                // check if any slot of SC lies within queried time slot
                for (TimeSlot timeSlot : slotsOfDay) {
                    if (isTimeSlotWithinInterval(timeSlot, to, from))
                        return true;
                }
            }
        }

        return false;
    }

    /*
        returns if time slot is overlapping the querying slots

        eg : from request (rFrom & rTo) : 12 to 1 pm
            SC slot (qFrom & qTo) : 12 to 3
            rFrom <= qTo && rTo >= qFrom
            12 <= 3 && 1 >= 12

            rFrom & rTo : 12 to 2
            qFrom & qTo : 1 to 2 pm
            12 <= 2 && 2 >= 1
     */
    private boolean isTimeSlotWithinInterval(TimeSlot timeSlot, int rTo, int rFrom) {

        if (timeSlot != null) {
            int qTo = timeSlot.getTo();
            int qFrom = timeSlot.getFrom();
            return rFrom <= qTo && rTo >= qFrom;
        }

        return false;
    }

}
