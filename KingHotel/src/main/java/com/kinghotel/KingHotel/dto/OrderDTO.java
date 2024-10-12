package com.kinghotel.KingHotel.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.kinghotel.KingHotel.entity.OrderDetail;
import jakarta.persistence.Column;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    private long id;
    private String fullName;
    private String phoneNumber;
    private Date orderDate;
    private BigDecimal totalPrice;
    private String paymentMethod;
    private String status;
    private List<OrderDetail> orderDetails=new ArrayList<>();
}
