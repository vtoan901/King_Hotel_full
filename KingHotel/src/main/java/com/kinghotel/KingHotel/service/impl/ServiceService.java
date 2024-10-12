//package com.kinghotel.KingHotel.service.impl;
//
//import com.kinghotel.KingHotel.dto.OrderDTO;
//import com.kinghotel.KingHotel.dto.ServiceDTO;
//import com.kinghotel.KingHotel.entity.Order;
//import com.kinghotel.KingHotel.entity.Service;
//import com.kinghotel.KingHotel.repo.ServiceRepository;
//import com.kinghotel.KingHotel.response.Response;
//import com.kinghotel.KingHotel.service.interfac.IServiceService;
//import com.kinghotel.KingHotel.utils.Utils;
//import org.springframework.beans.factory.annotation.Autowired;
//
//
//@org.springframework.stereotype.Service
//public class ServiceService implements IServiceService {
//    @Autowired
//    private ServiceRepository serviceRepository;
//
//    @Override
//    public Response createService(ServiceDTO serviceDTO) {
//        Response response = new Response();
//        try {
//            Service service = new Service();
//            service.setNameSer(nameSer);
//            ServiceDTO savedService = serviceRepository.save(service);
//            response.setStatusCode(200);
//            response.setOrderDTO(Utils.mapOrderEntityToOrderDTO(savedOrder));
//            response.setMessage("Order created successfully");
//        } catch (Exception e) {
//            response.setStatusCode(500);
//            response.setMessage("Error creating order: " + e.getMessage());
//        }
//        return response;
//    }
//
//    @Override
//    public Response getServiceById(Long serviceDTO) {
//        return null;
//    }
//
//    @Override
//    public Response getAllOrders() {
//        return null;
//    }
//
//    @Override
//    public Response updateService(Long ServiceId, ServiceDTO serviceDTO) {
//        return null;
//    }
//
//    @Override
//    public Response deleteOrder(Long ServiceId) {
//        return null;
//    }
//}
