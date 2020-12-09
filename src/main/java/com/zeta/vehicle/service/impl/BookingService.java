package com.zeta.vehicle.service.impl;


import com.zeta.vehicle.dao.IBookingDao;
import com.zeta.vehicle.dao.IServiceCenterDao;
import com.zeta.vehicle.dao.impl.BookingDao;
import com.zeta.vehicle.dto.Booking;
import com.zeta.vehicle.dto.ServiceCenter;
import com.zeta.vehicle.exception.BookingException;
import com.zeta.vehicle.factory.AppFactory;
import com.zeta.vehicle.request.BookingRequest;
import com.zeta.vehicle.service.IBookingService;

import java.awt.print.Book;

import static com.zeta.vehicle.constants.AppConstants.ID_GENERATOR;

/**
 * @author nikhil sharma created on 09/12/20
 */
public class BookingService implements IBookingService {

    // all initializations will be autowired in actual
    private IServiceCenterDao serviceCenterDao = AppFactory.getServiceCenterDao();

    private IBookingDao bookingDao = new BookingDao();

    @Override
    public String book(BookingRequest bookingRequest) throws BookingException {

        if (bookingRequest == null)
            throw new BookingException("Invalid Booking request");

        String bookingId = "";
        if (bookingRequest.isOwned()) {
            bookingId = bookServiceCenterSlot(bookingRequest);
        }
        else {
            bookingId = makeBookingRequestToSC(bookingRequest);
        }

        return bookingId;
    }

    @Override
    public Booking getBookingById(String id) {
        return bookingDao.getBookingById(id);
    }

    private String makeBookingRequestToSC(BookingRequest bookingRequest) {

        // this will be a remote call to partner to book slot
        return ID_GENERATOR.get();
    }

    private String bookServiceCenterSlot(BookingRequest bookingRequest) throws BookingException {

        ServiceCenter serviceCenter = serviceCenterDao.getById(bookingRequest.getServiceCenterId());
        Booking booking = new Booking(serviceCenter, bookingRequest.getVehicleType(), bookingRequest.getDay(), bookingRequest.getSlot());
        String bookingId = bookingDao.generateBooking(booking);

        return bookingId;
    }

}
