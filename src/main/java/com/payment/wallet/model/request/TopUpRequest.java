package com.payment.wallet.model.request;

import jdk.nashorn.internal.objects.annotations.Property;

public class TopUpRequest {
    @Property( name = "amount")
    private Float amount;
    @Property( name = "message")
    private String message;
    @Property( name = "receiver_wallet_id")
    private Long receiver_wallet_id;
    @Property( name = "timetz")
    private String timetz;

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

    public Long getReceiver_wallet_id() {
        return receiver_wallet_id;
    }

    public void setReceiver_wallet_id(Long receiver_wallet_id) {
        this.receiver_wallet_id = receiver_wallet_id;
    }

    public String getTimetz() {
        return timetz;
    }

    public void setTimetz(String timetz) {
        this.timetz = timetz;
    }
}
