package com.zeta.vehicle.dto;

/**
 * @author nikhil sharma created on 09/12/20
 */
public class Location {

    private String id;
    private String addressLine;
    private String city;
    private String state;

    public Location(String id, String addressLine, String city, String state) {
        this.id = id;
        this.addressLine = addressLine;
        this.city = city;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
