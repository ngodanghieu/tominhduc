package com.payment.wallet.controller;

import com.payment.wallet.constant.RestApiConstant;
import com.payment.wallet.model.request.UserLoginRequest;
import com.payment.wallet.model.request.UserRequest;
import com.payment.wallet.model.response.UserResponseAll;
import com.payment.wallet.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(RestApiConstant.Base)
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("register_user")
    String register(@RequestBody UserRequest userRequest){
        return userService.register(userRequest);
    }

    @PostMapping("login")
    ResponseEntity<?> login(@RequestBody UserLoginRequest userRequest){
        return userService.login(userRequest);
    }

    @GetMapping("users")
    List<UserResponseAll> getUser(@RequestParam("user_id")  String token){
        return userService.getUSer(token);
    }
}
