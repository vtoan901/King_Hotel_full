package com.kinghotel.KingHotel.service.interfac;


import com.kinghotel.KingHotel.response.Response;
import com.kinghotel.KingHotel.entity.Booking;

public interface IBookingService {

    Response saveBooking(Long roomId, Long userId, Booking bookingRequest);

    Response findBookingByConfirmationCode(String confirmationCode);

    Response getAllBookings();

    Response cancelBooking(Long bookingId);

}
