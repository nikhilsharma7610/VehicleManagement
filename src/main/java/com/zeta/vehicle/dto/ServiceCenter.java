package com.zeta.vehicle.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * @author nikhil sharma created on 09/12/20
 */
public class ServiceCenter {

    private String id;
    private String name;
    private Location location;
    private boolean owned;  // property to distinguish owned service centers and other service centers
    private Map<LocalDate, List<TimeSlot>> slots;

    public ServiceCenter(String id, String name, Location location, boolean owned, Map<LocalDate, List<TimeSlot>> slots) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.owned = owned;
        this.slots = slots;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean isOwned() {
        return owned;
    }

    public void setOwned(boolean owned) {
        this.owned = owned;
    }

    public Map<LocalDate, List<TimeSlot>> getSlots() {
        return slots;
    }

    public void setSlots(Map<LocalDate, List<TimeSlot>> slots) {
        this.slots = slots;
    }

}
