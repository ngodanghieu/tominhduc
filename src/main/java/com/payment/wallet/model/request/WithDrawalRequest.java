package com.payment.wallet.model.request;

import jdk.nashorn.internal.objects.annotations.Property;

public class WithDrawalRequest {
    @Property( name = "amount")
    private Float amount;
    @Property( name = "message")
    private String message;
    @Property( name = "timetz")
    private String timetz;
    @Property( name = "sender_wallet_id")
    private Long sender_wallet_id;

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

    public String getTimetz() {
        return timetz;
    }

    public void setTimetz(String timetz) {
        this.timetz = timetz;
    }

    public Long getSender_wallet_id() {
        return sender_wallet_id;
    }

    public void setSender_wallet_id(Long sender_wallet_id) {
        this.sender_wallet_id = sender_wallet_id;
    }
}
