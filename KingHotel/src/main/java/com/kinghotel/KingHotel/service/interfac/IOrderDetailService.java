package com.kinghotel.KingHotel.service.interfac;

import com.kinghotel.KingHotel.dto.OrderDetailDTO;
import com.kinghotel.KingHotel.response.Response;

public interface IOrderDetailService {
    Response createOrderDetail(OrderDetailDTO orderDetailDTO);
    Response getOrderDetailById(Long orderDetailId);
    Response getAllOrderDetails();
    Response updateOrderDetail(Long orderDetailId, OrderDetailDTO orderDetailDTO);
    Response deleteOrderDetail(Long orderDetailId);
}
