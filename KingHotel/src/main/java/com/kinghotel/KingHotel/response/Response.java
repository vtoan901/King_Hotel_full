package com.kinghotel.KingHotel.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.kinghotel.KingHotel.dto.*;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    private int statusCode;
    private String message;

    private String token;
    private String role;
    private String expirationTime;
    private String bookingConfirmationCode;

    private UserDTO user;
    private RoomDTO room;
    private BookingDTO booking;
    private List<UserDTO> userList;
    private List<RoomDTO> roomList;
    private List<BookingDTO> bookingList;

    private OrderDTO orderDTO;
    private OrderDetailDTO orderDetailDTO;
    private ServiceDTO serviceDTO;
    private  List<OrderDTO> orderDTOList;
    private List<OrderDetailDTO> orderDetailDTOList;
    private List<ServiceDTO> serviceDTOS;


}