package com.payment.wallet.model.request;

import java.math.BigDecimal;
import java.util.Date;

public class PaymentRequest {
    private Long sender_wallet_id;
    private Long receiver_wallet_id;
    private Float amount;
    private Date timestamp;
    private String message;
    private String request_status;

    public Long getSender_wallet_id() {
        return sender_wallet_id;
    }

    public void setSender_wallet_id(Long sender_wallet_id) {
        this.sender_wallet_id = sender_wallet_id;
    }

    public Long getReceiver_wallet_id() {
        return receiver_wallet_id;
    }

    public void setReceiver_wallet_id(Long receiver_wallet_id) {
        this.receiver_wallet_id = receiver_wallet_id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRequest_status() {
        return request_status;
    }

    public void setRequest_status(String request_status) {
        this.request_status = request_status;
    }
}
