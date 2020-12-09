package com.zeta.vehicle.dto;

/**
 * @author nikhil sharma created on 09/12/20
 */
public class TimeSlot {

    // number of seconds of a day
    private int from;
    private int to;

    public TimeSlot(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }
}
