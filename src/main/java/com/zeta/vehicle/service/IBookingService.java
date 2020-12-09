package com.zeta.vehicle.service;


import com.zeta.vehicle.dto.Booking;
import com.zeta.vehicle.exception.BookingException;
import com.zeta.vehicle.request.BookingRequest;

/**
 * @author nikhil sharma created on 09/12/20
 */
public interface IBookingService {

    String book(BookingRequest bookingRequest) throws BookingException;

    Booking getBookingById(String id);
}
