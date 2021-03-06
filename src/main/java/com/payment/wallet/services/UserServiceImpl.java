package com.payment.wallet.services;

import com.payment.wallet.entities.User;
import com.payment.wallet.entities.Wallet;
import com.payment.wallet.model.request.UserLoginRequest;
import com.payment.wallet.model.request.UserRequest;
import com.payment.wallet.model.response.UserResponse;
import com.payment.wallet.model.response.UserResponseAll;
import com.payment.wallet.repository.UserRepository;
import com.payment.wallet.repository.WalletRepository;
import com.payment.wallet.untils.Constant;
import com.payment.wallet.untils.Helper;
import com.payment.wallet.untils.JwtUltis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WalletRepository walletRepository;

    @Transactional
    @Override
    public String register(UserRequest userRequest) {
        User user = userRepository.findByPhone(userRequest.getPhonenumber());
        if (user != null) {
            return Constant.StatusCode.ERROR.getMessage();
        } else {
            try {
                Wallet wallet = walletRepository.save(modelToEntity(0L));
                User user1 = userRepository.save(createUser(userRequest, wallet));
                wallet.setUserId(user1.getUserId());
                walletRepository.save(wallet);
                return Constant.StatusCode.OK.getMessage();
            } catch (Exception ex) {
                return Constant.StatusCode.ERROR.getMessage();

            }
        }
    }

    @Override
    public ResponseEntity<List<UserResponse>> login(UserLoginRequest userRequest) {
        try {
            List<User> userList = userRepository.findAllByPhone(userRequest.getPhone_number());
            if (!CollectionUtils.isEmpty(userList) && userList.size() == 1) {
                if (checkPass(userList.get(0).getPass(), userRequest.getPass())) {
                    UserResponse userResponse = new UserResponse();
                    userResponse.setToken(generateToken(userList.get(0)));
                    return new ResponseEntity<List<UserResponse>>(Arrays.asList(userResponse), HttpStatus.OK);
                }
            }
        } catch (Exception ex) {
        }
        return new ResponseEntity<List<UserResponse>>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public List<UserResponseAll> getUSer(String token) {
        try {
            Long userId = Long.valueOf(JwtUltis.getUserId(token));
//            List<User> list = userRepository.findAllByUserId(userId);
            List<User> list = userRepository.findAll();
            if (!CollectionUtils.isEmpty(list)) {

//                return Arrays.asList(mapEntityToModel(list.get(0)));
                List<UserResponseAll> result = new ArrayList<>();
                for (User x : list) {
                    UserResponseAll userResponseAll = mapEntityToModel(x);
                    result.add(userResponseAll);
                }
                return result;
            }

        } catch (Exception ex) {

        }
        return new ArrayList<>();
    }

    private UserResponseAll mapEntityToModel(User data) {
        UserResponseAll result = new UserResponseAll();
        result.setEmail(data.getEmail());
        result.setFull_name(data.getName());
        result.setPassword(data.getPass());
        result.setPhone_number(data.getPhone());
        result.setUser_id(Integer.valueOf(data.getUserId().toString()));
        result.setWallet_id(data.getWalletId().toString());

        return result;
    }

    private User createUser(UserRequest userRequest, Wallet wallet) {
        User user = new User();
        user.setEmail(userRequest.getEmail());
        user.setPhone(userRequest.getPhonenumber());
        user.setPass(Helper.HasPw(userRequest.getPassword()));
        user.setName(userRequest.getFull_name());
        user.setWalletId(wallet.getWalletId());
        return user;
    }

    private Wallet modelToEntity(Long userId) {
        Wallet wallet = new Wallet();
        wallet.setTimestamp(new Date());
        wallet.setMoney(Float.valueOf("0"));
        wallet.setUserId(userId);
        return wallet;
    }

    private boolean checkPass(String passOld, String inputPass) {
        return Helper.CheckPw(inputPass, passOld);
    }

    String generateToken(User user) {
        return JwtUltis.generateToken(user);
    }
}
