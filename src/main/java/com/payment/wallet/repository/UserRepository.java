package com.payment.wallet.repository;

import com.payment.wallet.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByPhone(String phone);
    List<User> findAllByPhone(String phone);

    List<User> findAllByUserId(Long userId);

}