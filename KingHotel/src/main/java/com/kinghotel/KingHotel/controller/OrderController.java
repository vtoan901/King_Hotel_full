package com.kinghotel.KingHotel.controller;

import com.kinghotel.KingHotel.dto.OrderDTO;
import com.kinghotel.KingHotel.response.Response;
import com.kinghotel.KingHotel.service.interfac.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @PostMapping
    public ResponseEntity<Response> createOrder(@RequestBody OrderDTO orderDTO) {
        Response response = orderService.createOrder(orderDTO);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Response> getOrderById(@PathVariable Long orderId) {
        Response response = orderService.getOrderById(orderId);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @GetMapping
    public ResponseEntity<Response> getAllOrders() {
        Response response = orderService.getAllOrders();
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<Response> updateOrder(@PathVariable Long orderId, @RequestBody OrderDTO orderDTO) {
        Response response = orderService.updateOrder(orderId, orderDTO);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Response> deleteOrder(@PathVariable Long orderId) {
        Response response = orderService.deleteOrder(orderId);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
}
