package com.anirbandhara.modules;

import com.anirbandhara.pojos.*;
import com.google.gson.Gson;
import java.lang.reflect.Type;              // For Type
import java.util.List;                      // For List
import com.google.gson.reflect.TypeToken;

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


    public Booking getResponseFromJSON(String getResponse){
        gson = new Gson();
        Booking booking = gson.fromJson(getResponse,Booking.class);
        return booking;
    }

    public String fullUpdatePayloadAsString() {
        Booking booking = new Booking();
        booking.setFirstname("James");
        booking.setLastname("Brown");
        booking.setTotalprice(3765);
        booking.setDepositpaid(true);

        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-05");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");
        return gson.toJson(booking);


    }

    public List<GetAllBookingResponse> getAllBookingByIdResponse(String getAllbookingresponse){

        Gson gson = new Gson();
        Type bookingListType = new TypeToken<List<GetAllBookingResponse>>(){}.getType();
        List<GetAllBookingResponse> bookings = gson.fromJson(getAllbookingresponse, bookingListType);
        return bookings;
    }


}
