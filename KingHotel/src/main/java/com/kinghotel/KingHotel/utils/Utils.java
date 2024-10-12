package com.kinghotel.KingHotel.utils;

import com.kinghotel.KingHotel.dto.*;
import com.kinghotel.KingHotel.entity.*;

import java.security.SecureRandom;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    public  static final  String  ALPHANUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private static final SecureRandom securaRandom = new SecureRandom();


    public static String generateRandomConfirmationCode(int length){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i= 0 ; i< length ; i++ ){
            int randomIndex = securaRandom.nextInt(ALPHANUMERIC_STRING.length());
            char randomChar = ALPHANUMERIC_STRING.charAt(randomIndex);
            stringBuilder.append(randomChar);

        }
        return stringBuilder.toString();

    }

    public static UserDTO mapUserEntityToUserDTO(User user){
        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setRole(user.getRole());
        return userDTO;
    }

    public static RoomDTO mapRoomEntityToRoomDTO(Room room) {
        RoomDTO roomDTO = new RoomDTO();

        roomDTO.setId(room.getId());
        roomDTO.setRoomType(room.getRoomType());
        roomDTO.setRoomPrice(room.getRoomPrice());
        roomDTO.setRoomPhotoUrl(room.getRoomPhotoUrl());
        roomDTO.setRoomDescription(room.getRoomDescription());
        return roomDTO;
    }

    public static BookingDTO mapBookingEntityToBookingDTO(Booking booking) {
        BookingDTO bookingDTO = new BookingDTO();
        // Map simple fields
        bookingDTO.setId(booking.getId());
        bookingDTO.setCheckInDate(booking.getCheckInDate());
        bookingDTO.setCheckOutDate(booking.getCheckOutDate());
        bookingDTO.setNumOfAdults(booking.getNumOfAdults());
        bookingDTO.setNumOfChildren(booking.getNumOfChildren());
        bookingDTO.setTotalNumOfGuest(booking.getTotalNumOfGuest());
        bookingDTO.setBookingConfirmationCode(booking.getBookingConfirmationCode());
        return bookingDTO;
    }

    public static UserDTO mapUserEntityToUserDTOPlusUserBookingsAndRoom(User user){
        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setRole(user.getRole());


        if (!user.getBookings().isEmpty()){
            userDTO.setBookings(user.getBookings().stream().map(booking -> mapBookingEntityToBookingDTOPlusBookedRooms(booking,false)).collect(Collectors.toList()));
        }

        return userDTO;
    }

    public static RoomDTO mapRoomEntityToRoomDTOPlusBookings(Room room) {
        RoomDTO roomDTO = new RoomDTO();

        roomDTO.setId(room.getId());
        roomDTO.setRoomType(room.getRoomType());
        roomDTO.setRoomPrice(room.getRoomPrice());
        roomDTO.setRoomPhotoUrl(room.getRoomPhotoUrl());
        roomDTO.setRoomDescription(room.getRoomDescription());

        if (room.getBookings() != null) {
            roomDTO.setBookings(room.getBookings().stream().map(Utils::mapBookingEntityToBookingDTO).collect(Collectors.toList()));
        }
        return roomDTO;
    }

    public static BookingDTO mapBookingEntityToBookingDTOPlusBookedRooms(Booking booking, boolean mapUser) {

        BookingDTO bookingDTO = new BookingDTO();
        // Map simple fields
        bookingDTO.setId(booking.getId());
        bookingDTO.setCheckInDate(booking.getCheckInDate());
        bookingDTO.setCheckOutDate(booking.getCheckOutDate());
        bookingDTO.setNumOfAdults(booking.getNumOfAdults());
        bookingDTO.setNumOfChildren(booking.getNumOfChildren());
        bookingDTO.setTotalNumOfGuest(booking.getTotalNumOfGuest());
        bookingDTO.setBookingConfirmationCode(booking.getBookingConfirmationCode());
        if (mapUser) {
            bookingDTO.setUser(Utils.mapUserEntityToUserDTO(booking.getUser()));
        }
        if (booking.getRoom() != null) {
            RoomDTO roomDTO = new RoomDTO();

            roomDTO.setId(booking.getRoom().getId());
            roomDTO.setRoomType(booking.getRoom().getRoomType());
            roomDTO.setRoomPrice(booking.getRoom().getRoomPrice());
            roomDTO.setRoomPhotoUrl(booking.getRoom().getRoomPhotoUrl());
            roomDTO.setRoomDescription(booking.getRoom().getRoomDescription());
            bookingDTO.setRoom(roomDTO);
        }
        return bookingDTO;
    }

    public static List<UserDTO> mapUserListEntityToUserListDTO(List<User> userList) {
        return userList.stream().map(Utils::mapUserEntityToUserDTO).collect(Collectors.toList());
    }

    public static List<RoomDTO> mapRoomListEntityToRoomListDTO(List<Room> roomList) {
        return roomList.stream().map(Utils::mapRoomEntityToRoomDTO).collect(Collectors.toList());
    }

    public static List<BookingDTO> mapBookingListEntityToBookingListDTO(List<Booking> bookingList) {
        return bookingList.stream().map(Utils::mapBookingEntityToBookingDTO).collect(Collectors.toList());
    }
    //ORDER
    public static OrderDTO mapOrderEntityToOrderDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setFullName(order.getFullName());
        orderDTO.setPhoneNumber(order.getPhoneNumber());
        orderDTO.setOrderDate(order.getOrderDate());
        orderDTO.setTotalPrice(order.getTotalPrice());
        orderDTO.setPaymentMethod(order.getPaymentMethod());
        orderDTO.setStatus(order.getStatus());
        orderDTO.setOrderDetails(order.getOrderDetails());
        return orderDTO;
    }

    public static Order mapOrderDTOToOrderEntity(OrderDTO orderDTO) {
        Order order = new Order();
        order.setFullName(orderDTO.getFullName());
        order.setPhoneNumber(orderDTO.getPhoneNumber());
        order.setOrderDate(orderDTO.getOrderDate());
        order.setTotalPrice(orderDTO.getTotalPrice());
        order.setPaymentMethod(orderDTO.getPaymentMethod());
        order.setStatus(orderDTO.getStatus());
        order.setOrderDetails(orderDTO.getOrderDetails());
        return order;
    }

    public static void updateOrderEntityFromDTO(Order order, OrderDTO orderDTO) {
        order.setFullName(orderDTO.getFullName());
        order.setPhoneNumber(orderDTO.getPhoneNumber());
        order.setOrderDate(orderDTO.getOrderDate());
        order.setTotalPrice(orderDTO.getTotalPrice());
        order.setPaymentMethod(orderDTO.getPaymentMethod());
        order.setStatus(orderDTO.getStatus());
        order.setOrderDetails(orderDTO.getOrderDetails());
    }

    public static List<OrderDTO> mapOrderListEntityToOrderListDTO(List<Order> orders) {
        return orders.stream().map(Utils::mapOrderEntityToOrderDTO).collect(Collectors.toList());
    }

    //ORDER_DETAIL
    public static OrderDetailDTO mapOrderDetailEntityToOrderDetailDTO(OrderDetail orderDetail) {
        OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
        orderDetailDTO.setId(orderDetail.getId());
        orderDetailDTO.setQuantity(orderDetail.getQuantity());
        orderDetailDTO.setPrice(orderDetail.getPrice());
        orderDetailDTO.setTotal_price(orderDetail.getTotal_price());
        orderDetailDTO.setOrderDTO(mapOrderEntityToOrderDTO(orderDetail.getOrder()));
        //orderDetailDTO.setServiceDTO(mapServiceEntityToServiceDTO(orderDetail.getService()));
        orderDetailDTO.setRoomDTO(mapRoomEntityToRoomDTO(orderDetail.getRoom()));
        return orderDetailDTO;
    }

    public static OrderDetail mapOrderDetailDTOToOrderDetailEntity(OrderDetailDTO orderDetailDTO) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setQuantity(orderDetailDTO.getQuantity());
        orderDetail.setPrice(orderDetailDTO.getPrice());
        orderDetail.setTotal_price(orderDetailDTO.getTotal_price());
        orderDetail.setOrder(mapOrderDTOToOrderEntity(orderDetailDTO.getOrderDTO()));
//        orderDetail.setService(mapServiceDTOToServiceEntity(orderDetailDTO.getServiceDTO()));
//        orderDetail.setRoom(mapRoomDTOToRoomEntity(orderDetailDTO.getRoomDTO()));
        return orderDetail;
    }

    public static void updateOrderDetailEntityFromDTO(OrderDetail orderDetail, OrderDetailDTO orderDetailDTO) {
        orderDetail.setQuantity(orderDetailDTO.getQuantity());
        orderDetail.setPrice(orderDetailDTO.getPrice());
        orderDetail.setTotal_price(orderDetailDTO.getTotal_price());
        orderDetail.setOrder(mapOrderDTOToOrderEntity(orderDetailDTO.getOrderDTO()));
//        orderDetail.setService(mapServiceDTOToServiceEntity(orderDetailDTO.getServiceDTO()));
//        orderDetail.setRoom(mapRoomDTOToRoomEntity(orderDetailDTO.getRoomDTO()));
    }

    public static List<OrderDetailDTO> mapOrderDetailListEntityToOrderDetailListDTO(List<OrderDetail> orderDetails) {
        return orderDetails.stream().map(Utils::mapOrderDetailEntityToOrderDetailDTO).collect(Collectors.toList());
    }



    //SERVICE
//    public static ServiceDTO mapServiceEntityToServiceDTO(Service service){
//        ServiceDTO serviceDTO = new ServiceDTO();
//        serviceDTO.setNameSer(serviceDTO.getNameSer());
//        serviceDTO.setPriceSer(serviceDTO.getPriceSer());
//        serviceDTO.setDescription(serviceDTO.getDescription());
//
//
//        return serviceDTO;
//    }
//
//    public static Service mapServiceDTOToServiceEntity(ServiceDTO serviceDTO) {
//        Service service = new Service();
//        service.setNameSer(serviceDTO.getNameSer());
//        service.setPriceSer(serviceDTO.getPriceSer());
//        service.setDescription(serviceDTO.getDescription());
//        service.setOrderDetail();
//        return service;
//    }

}