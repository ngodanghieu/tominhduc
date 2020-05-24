package com.payment.wallet.services;


import com.payment.wallet.model.request.UserLoginRequest;
import com.payment.wallet.model.request.UserRequest;
import com.payment.wallet.model.response.UserResponse;
import com.payment.wallet.model.response.UserResponseAll;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    ResponseEntity<?> register(UserRequest userRequest);
    ResponseEntity<List<UserResponse>> login(UserLoginRequest userRequest);

    ResponseEntity<List<UserResponseAll>> getUSer(Long userId);
}
