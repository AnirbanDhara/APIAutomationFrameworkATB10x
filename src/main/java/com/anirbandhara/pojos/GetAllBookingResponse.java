package com.anirbandhara.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetAllBookingResponse {

    @SerializedName("bookingid")
    @Expose
    private Integer bookingid;  // or Booking[] bookings if you prefer array

//    public GetAllBookingResponse() {
//    }

//    public GetAllBookingResponse(int bookingid) {
//        this.bookingid = bookingid;
//    }
   

    public Integer getBookings() {
        return bookingid;
    }

    public void setBookings(Integer bookingid) {
        this.bookingid = bookingid;
    }
//
//    @Override
//    public String toString() {
//        return "Booking{" +
//                "bookingid=" + bookingid +
//                '}';
//    }
}


