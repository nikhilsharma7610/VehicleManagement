package com.zeta.vehicle.controllers;

import com.zeta.vehicle.dto.Booking;
import com.zeta.vehicle.request.BookingRequest;
import com.zeta.vehicle.service.IBookingService;
import com.zeta.vehicle.service.impl.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

/**
 * @author nikhil sharma created on 09/12/20
 */
@RestController
@RequestMapping("/booking")
public class BookingController {

    private IBookingService bookingService = new BookingService();

    @PostMapping(path = "/slot", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> book(@RequestBody BookingRequest bookingRequest) {

        String bookingId = "Booking could not done";
        try {
            bookingId = bookingService.book(bookingRequest);
        }
        catch (Exception e) {
            e.printStackTrace();
            bookingId = e.getMessage();
        }

        return new ResponseEntity<>(bookingId, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Booking> getBookingById(@PathVariable String id) {

        Booking booking = null;
        try {
            booking = bookingService.getBookingById(id);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

}
