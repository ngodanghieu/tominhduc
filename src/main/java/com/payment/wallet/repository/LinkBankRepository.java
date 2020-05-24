package com.payment.wallet.repository;

import com.payment.wallet.entities.LinkBank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LinkBankRepository extends JpaRepository<LinkBank,Long> {

    List<LinkBank> findAllByUserId(Long userId);
}
