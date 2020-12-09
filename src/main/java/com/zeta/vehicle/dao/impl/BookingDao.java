package com.zeta.vehicle.dao.impl;

import com.zeta.vehicle.dao.IBookingDao;
import com.zeta.vehicle.dto.Booking;
import com.zeta.vehicle.exception.BookingException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.zeta.vehicle.constants.AppConstants.ID_GENERATOR;


/**
 * @author nikhil sharma created on 09/12/20
 */
public class BookingDao implements IBookingDao {

    private static Map<String, Booking> bookingById = new HashMap<>();
    private static Map<String, List<Booking>> bookingBySC = new HashMap<>();

    @Override
    public String generateBooking(Booking booking) throws BookingException {

        if (booking == null)
            throw new BookingException("Booking object cannot be null");

        booking.setId(ID_GENERATOR.get());
        bookingById.put(booking.getId(), booking);

        List<Booking> scBookings = bookingBySC.getOrDefault(booking.getServiceCenter().getId(), new ArrayList<>());
        scBookings.add(booking);
        bookingBySC.put(booking.getServiceCenter().getId(), scBookings);

        return booking.getId();
    }

    @Override
    public Booking getBookingById(String id) {
        return bookingById.get(id);
    }

    @Override
    public List<Booking> getBookingsByServiceCenter(String id) {
        return bookingBySC.get(id);
    }

}
