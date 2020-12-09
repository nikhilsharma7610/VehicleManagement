package com.zeta.vehicle.request;


import com.zeta.vehicle.dto.TimeSlot;
import com.zeta.vehicle.enums.VehicleType;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author nikhil sharma created on 09/12/20
 */
public class BookingRequest {

    private String serviceCenterId;
    private boolean owned;
    private VehicleType vehicleType;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate day;

    private TimeSlot slot;

    public String getServiceCenterId() {
        return serviceCenterId;
    }

    public void setServiceCenterId(String serviceCenterId) {
        this.serviceCenterId = serviceCenterId;
    }

    public boolean isOwned() {
        return owned;
    }

    public void setOwned(boolean owned) {
        this.owned = owned;
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
}
