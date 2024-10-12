package com.kinghotel.KingHotel.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDetailDTO {
    private long id;
    private int quantity;
    private BigDecimal price;
    private BigDecimal total_price;
    private OrderDTO orderDTO;
    private ServiceDTO serviceDTO;
    private RoomDTO roomDTO;
}
