package com.kinghotel.KingHotel.service.impl;

import com.kinghotel.KingHotel.dto.OrderDTO;
import com.kinghotel.KingHotel.entity.Order;
import com.kinghotel.KingHotel.exception.OurException;
import com.kinghotel.KingHotel.repo.OrderRepository;
import com.kinghotel.KingHotel.response.Response;
import com.kinghotel.KingHotel.service.interfac.IOrderService;
import com.kinghotel.KingHotel.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Response createOrder(OrderDTO orderDTO) {
        Response response = new Response();
        try {
            Order order = Utils.mapOrderDTOToOrderEntity(orderDTO);
            Order savedOrder = orderRepository.save(order);
            response.setStatusCode(200);
            response.setOrderDTO(Utils.mapOrderEntityToOrderDTO(savedOrder));
            response.setMessage("Order created successfully");
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error creating order: " + e.getMessage());
        }
        return response;
    }

    @Override
    public Response getOrderById(Long orderId) {
        Response response = new Response();
        try {
            Order order = orderRepository.findById(orderId).orElseThrow(() -> new OurException("Order not found"));
            response.setStatusCode(200);
            response.setOrderDTO(Utils.mapOrderEntityToOrderDTO(order));
            response.setMessage("Order retrieved successfully");
        } catch (OurException e) {
            response.setStatusCode(404);
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error retrieving order: " + e.getMessage());
        }
        return response;
    }

    @Override
    public Response getAllOrders() {
        Response response = new Response();
        try {
            List<Order> orders = orderRepository.findAll();
            response.setStatusCode(200);
            response.setOrderDTOList(Utils.mapOrderListEntityToOrderListDTO(orders));
            response.setMessage("Orders retrieved successfully");
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error retrieving orders: " + e.getMessage());
        }
        return response;
    }

    @Override
    public Response updateOrder(Long orderId, OrderDTO orderDTO) {
        Response response = new Response();
        try {
            Order order = orderRepository.findById(orderId).orElseThrow(() -> new OurException("Order not found"));
            Utils.updateOrderEntityFromDTO(order, orderDTO);
            Order updatedOrder = orderRepository.save(order);
            response.setStatusCode(200);
            response.setOrderDTO(Utils.mapOrderEntityToOrderDTO(updatedOrder));
            response.setMessage("Order updated successfully");
        } catch (OurException e) {
            response.setStatusCode(404);
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error updating order: " + e.getMessage());
        }
        return response;
    }

    @Override
    public Response deleteOrder(Long orderId) {
        Response response = new Response();
        try {
            orderRepository.findById(orderId).orElseThrow(() -> new OurException("Order not found"));
            orderRepository.deleteById(orderId);
            response.setStatusCode(200);
            response.setMessage("Order deleted successfully");
        } catch (OurException e) {
            response.setStatusCode(404);
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error deleting order: " + e.getMessage());
        }
        return response;
    }
}
