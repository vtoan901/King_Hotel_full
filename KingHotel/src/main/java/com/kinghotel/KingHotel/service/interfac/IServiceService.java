package com.kinghotel.KingHotel.service.interfac;


import com.kinghotel.KingHotel.dto.ServiceDTO;
import com.kinghotel.KingHotel.response.Response;


public interface IServiceService {
    Response createService(ServiceDTO serviceDTO);
    Response getServiceById(Long serviceDTO);
    Response getAllOrders();
    Response updateService(Long ServiceId, ServiceDTO serviceDTO);
    Response deleteOrder(Long ServiceId);
}
