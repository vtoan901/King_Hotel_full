package com.kinghotel.KingHotel.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.kinghotel.KingHotel.entity.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceDTO {
    private long id;


    private String nameSer;
    private BigDecimal priceSer;
    private String description;
    private OrderDetail orderDetail;
    private List<OrderDetail> orderDetailsList = new ArrayList<>();
}
