package com.zeta.vehicle.dao;


import com.zeta.vehicle.dto.Booking;
import com.zeta.vehicle.exception.BookingException;

import java.util.List;

/**
 * @author nikhil sharma created on 09/12/20
 */
public interface IBookingDao {

    String generateBooking(Booking booking) throws BookingException;

    Booking getBookingById(String id);

    List<Booking> getBookingsByServiceCenter(String id);
}
