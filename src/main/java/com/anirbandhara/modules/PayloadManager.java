package com.anirbandhara.modules;

import com.anirbandhara.pojos.*;
import com.google.gson.Gson;

public class PayloadManager {

    Gson gson;

    // Converting Java Object to JSON
    public String createPayloadBookingAsString()
    {
        Booking booking = new Booking();
        booking.setFirstname("Daniel");
        booking.setLastname("James");
        booking.setTotalprice(3465);
        booking.setDepositpaid(false);


        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2018-01-01");
        bookingDates.setCheckout("2019-01-01");
        booking.setBookingdates(bookingDates);
        booking.setAdditionalneeds("Pillows");

        //Java Object --> JSON
        gson = new Gson();
        String jsonStringBooking = gson.toJson(booking);

        return jsonStringBooking;


    }

    // Convert JSON --> Java Object
    public BookingResponse bookingResponseJava(String responseString) {
        BookingResponse bookingResponse = gson.fromJson(responseString, BookingResponse.class);
        return bookingResponse;
    }

    public String setAuthPayload() {
        Auth auth = new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");
        gson = new Gson();
        String jsonPayloadString = gson.toJson(auth);
        System.out.println("Payload set to the -> " + jsonPayloadString);
        return jsonPayloadString;
    }

    public String getTokenFromJSON(String tokenResponse) {
        gson = new Gson();
        TokenResponse tokenResponse1  = gson.fromJson(tokenResponse, TokenResponse.class);
        return tokenResponse1.getToken().toString();
    }
}
