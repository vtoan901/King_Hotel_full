package com.kinghotel.KingHotel.controller;

import com.kinghotel.KingHotel.dto.OrderDetailDTO;
import com.kinghotel.KingHotel.response.Response;
import com.kinghotel.KingHotel.service.interfac.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order-details")
public class OrderDetailController {

    @Autowired
    private IOrderDetailService orderDetailService;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Response> createOrderDetail(@RequestBody OrderDetailDTO orderDetailDTO) {
        Response response = orderDetailService.createOrderDetail(orderDetailDTO);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @GetMapping("/{orderDetailId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Response> getOrderDetailById(@PathVariable Long orderDetailId) {
        Response response = orderDetailService.getOrderDetailById(orderDetailId);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Response> getAllOrderDetails() {
        Response response = orderDetailService.getAllOrderDetails();
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @PutMapping("/{orderDetailId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Response> updateOrderDetail(@PathVariable Long orderDetailId, @RequestBody OrderDetailDTO orderDetailDTO) {
        Response response = orderDetailService.updateOrderDetail(orderDetailId, orderDetailDTO);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @DeleteMapping("/{orderDetailId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Response> deleteOrderDetail(@PathVariable Long orderDetailId) {
        Response response = orderDetailService.deleteOrderDetail(orderDetailId);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
}
