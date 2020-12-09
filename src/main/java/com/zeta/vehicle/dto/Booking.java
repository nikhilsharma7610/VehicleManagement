package com.zeta.vehicle.dto;


import com.zeta.vehicle.enums.VehicleType;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author nikhil sharma created on 09/12/20
 */
public class Booking {

    private String id;
    private ServiceCenter serviceCenter;
    private VehicleType vehicleType;
    private LocalDate day;
    private TimeSlot slot;

    public Booking(ServiceCenter serviceCenter, VehicleType vehicleType, LocalDate day, TimeSlot slot) {
        this.serviceCenter = serviceCenter;
        this.vehicleType = vehicleType;
        this.day = day;
        this.slot = slot;
    }

    public ServiceCenter getServiceCenter() {
        return serviceCenter;
    }

    public void setServiceCenter(ServiceCenter serviceCenter) {
        this.serviceCenter = serviceCenter;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public TimeSlot getSlot() {
        return slot;
    }

    public void setSlot(TimeSlot slot) {
        this.slot = slot;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
