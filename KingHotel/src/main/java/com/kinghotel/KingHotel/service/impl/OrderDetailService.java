package com.kinghotel.KingHotel.service.impl;

import com.kinghotel.KingHotel.dto.OrderDetailDTO;
import com.kinghotel.KingHotel.entity.OrderDetail;
import com.kinghotel.KingHotel.exception.OurException;
import com.kinghotel.KingHotel.repo.OrderDetailRepository;
import com.kinghotel.KingHotel.response.Response;
import com.kinghotel.KingHotel.service.interfac.IOrderDetailService;
import com.kinghotel.KingHotel.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService implements IOrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public Response createOrderDetail(OrderDetailDTO orderDetailDTO) {
        Response response = new Response();
        try {
            OrderDetail orderDetail = Utils.mapOrderDetailDTOToOrderDetailEntity(orderDetailDTO);
            OrderDetail savedOrderDetail = orderDetailRepository.save(orderDetail);
            response.setStatusCode(200);
            response.setOrderDetailDTO(Utils.mapOrderDetailEntityToOrderDetailDTO(savedOrderDetail));
            response.setMessage("OrderDetail created successfully");
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error creating order detail: " + e.getMessage());
        }
        return response;
    }

    @Override
    public Response getOrderDetailById(Long orderDetailId) {
        Response response = new Response();
        try {
            OrderDetail orderDetail = orderDetailRepository.findById(orderDetailId).orElseThrow(() -> new OurException("OrderDetail not found"));
            response.setStatusCode(200);
            response.setOrderDetailDTO(Utils.mapOrderDetailEntityToOrderDetailDTO(orderDetail));
            response.setMessage("OrderDetail retrieved successfully");
        } catch (OurException e) {
            response.setStatusCode(404);
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error retrieving order detail: " + e.getMessage());
        }
        return response;
    }

    @Override
    public Response getAllOrderDetails() {
        Response response = new Response();
        try {
            List<OrderDetail> orderDetails = orderDetailRepository.findAll();
            response.setStatusCode(200);
            response.setOrderDetailDTOList(Utils.mapOrderDetailListEntityToOrderDetailListDTO(orderDetails));
            response.setMessage("OrderDetails retrieved successfully");
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error retrieving order details: " + e.getMessage());
        }
        return response;
    }

    @Override
    public Response updateOrderDetail(Long orderDetailId, OrderDetailDTO orderDetailDTO) {
        Response response = new Response();
        try {
            OrderDetail orderDetail = orderDetailRepository.findById(orderDetailId).orElseThrow(() -> new OurException("OrderDetail not found"));
            Utils.updateOrderDetailEntityFromDTO(orderDetail, orderDetailDTO);
            OrderDetail updatedOrderDetail = orderDetailRepository.save(orderDetail);
            response.setStatusCode(200);
            response.setOrderDetailDTO(Utils.mapOrderDetailEntityToOrderDetailDTO(updatedOrderDetail));
            response.setMessage("OrderDetail updated successfully");
        } catch (OurException e) {
            response.setStatusCode(404);
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error updating order detail: " + e.getMessage());
        }
        return response;
    }

    @Override
    public Response deleteOrderDetail(Long orderDetailId) {
        Response response = new Response();
        try {
            orderDetailRepository.findById(orderDetailId).orElseThrow(() -> new OurException("OrderDetail not found"));
            orderDetailRepository.deleteById(orderDetailId);
            response.setStatusCode(200);
            response.setMessage("OrderDetail deleted successfully");
        } catch (OurException e) {
            response.setStatusCode(404);
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error deleting order detail: " + e.getMessage());
        }
        return response;
    }
}
