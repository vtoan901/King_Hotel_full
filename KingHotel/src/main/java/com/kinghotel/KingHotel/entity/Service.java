package com.kinghotel.KingHotel.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String nameSer;
    private BigDecimal priceSer;
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_detail_id")
    private OrderDetail orderDetail;

    @OneToMany(mappedBy = "service", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetailsList = new ArrayList<>();

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", nameSer='" + nameSer + '\'' +
                ", priceSer=" + priceSer +
                ", description='" + description + '\'' +
                ", orderDetail=" + orderDetail +
                ", orderDetailsList=" + orderDetailsList +
                '}';
    }
}
