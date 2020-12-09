package com.zeta.vehicle.dto;

/**
 * @author nikhil sharma created on 09/12/20
 */
public class Customer {

    private String id;
    private String name;
    private Location address;

    public Location getAddress() {
        return address;
    }

    public void setAddress(Location address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
