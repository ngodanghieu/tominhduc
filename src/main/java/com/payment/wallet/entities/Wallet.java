package com.payment.wallet.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import java.math.BigDecimal;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "wallet", catalog = "6g")
public class Wallet {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "wallet_id")
    private Long walletId;

    @Column(name = "money")
    private Float money;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "timestamp")
    private Date timestamp;

    public Long getWalletId() {
        return walletId;
    }

    public void setWalletId(Long wallet_id) {
        this.walletId = wallet_id;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long user_id) {
        this.userId = user_id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
