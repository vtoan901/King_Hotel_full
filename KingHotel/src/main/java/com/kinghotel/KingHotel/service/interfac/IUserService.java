package com.kinghotel.KingHotel.service.interfac;

import com.kinghotel.KingHotel.dto.LoginRequest;
import com.kinghotel.KingHotel.response.Response;
import com.kinghotel.KingHotel.entity.User;

public interface IUserService {
    Response register(User user);

    Response login(LoginRequest loginRequest);

    Response getAllUsers();

    Response getUserBookingHistory(String userId);

    Response deleteUser(String userId);

    Response getUserById(String userId);

    Response getMyInfo(String email);

}
