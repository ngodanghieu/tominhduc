package com.payment.wallet.repository;

import com.payment.wallet.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WalletRepository extends JpaRepository<Wallet,Long> {

    List<Wallet> findAllByUserId(Long userId);
    List<Wallet> findAllByWalletId(Long walletId);
}
