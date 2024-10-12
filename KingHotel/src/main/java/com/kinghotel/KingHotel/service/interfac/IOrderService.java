package com.kinghotel.KingHotel.service.interfac;

import com.kinghotel.KingHotel.dto.OrderDTO;
import com.kinghotel.KingHotel.response.Response;

public interface IOrderService {
    Response createOrder(OrderDTO orderDTO);
    Response getOrderById(Long orderId);
    Response getAllOrders();
    Response updateOrder(Long orderId, OrderDTO orderDTO);
    Response deleteOrder(Long orderId);
}
