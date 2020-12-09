package com.zeta.vehicle.dto;

import com.zeta.vehicle.enums.VehicleType;

/**
 * @author nikhil sharma created on 09/12/20
 */
public class Vehicle {

    private String id;
    private VehicleType type;
    private String vehicleNumer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public String getVehicleNumer() {
        return vehicleNumer;
    }

    public void setVehicleNumer(String vehicleNumer) {
        this.vehicleNumer = vehicleNumer;
    }
}
