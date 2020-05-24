package com.payment.wallet.entities;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "chuyen_tien", catalog = "6g")
public class Transaction {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "transaction_id")
    private Long transactionId;

    @Column(name = "sender_wallet_id")
    private Long sender_wallet_id;

    @Column(name = "beneficiary_id")
    private Long beneficiary_id;
    @Column(name = "wallet_id")
    private Long wallet_id;
    @Column(name = "timestamp")
    private Date timestamp;

    @Column(name = "ghi_chu")
    private String reason;

    @Column(name = "money")
    private BigDecimal amount;

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transaction_id) {
        this.transactionId = transaction_id;
    }

    public Long getSender_wallet_id() {
        return sender_wallet_id;
    }

    public void setSender_wallet_id(Long sender_wallet_id) {
        this.sender_wallet_id = sender_wallet_id;
    }

    public Long getBeneficiary_id() {
        return beneficiary_id;
    }

    public void setBeneficiary_id(Long beneficiary_id) {
        this.beneficiary_id = beneficiary_id;
    }

    public Long getWallet_id() {
        return wallet_id;
    }

    public void setWallet_id(Long wallet_id) {
        this.wallet_id = wallet_id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
