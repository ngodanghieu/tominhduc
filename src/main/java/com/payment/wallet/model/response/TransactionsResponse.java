package com.payment.wallet.model.response;

import jdk.nashorn.internal.objects.annotations.Property;

public class TransactionsResponse {
    @Property( name = "transaction_id")
    private String transaction_id;
    @Property( name = "sender_wallet_id")
    private String sender_wallet_id;
    @Property( name = "receiver_wallet_id")
    private String receiver_wallet_id;
    @Property( name = "amount")
    private String amount;
    @Property( name = "timestamp")
    private String timestamp;
    @Property( name = "message")
    private String message;
    @Property( name = "sender_full_name")
    private String sender_full_name;
    @Property( name = "receiver_full_name")
    private String receiver_full_name;
    @Property( name = "sender_phone_number")
    private String sender_phone_number;
    @Property( name = "receiver_phone_number")
    private String receiver_phone_number;
    @Property( name = "type")
    private String type;

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getSender_wallet_id() {
        return sender_wallet_id;
    }

    public void setSender_wallet_id(String sender_wallet_id) {
        this.sender_wallet_id = sender_wallet_id;
    }

    public String getReceiver_wallet_id() {
        return receiver_wallet_id;
    }

    public void setReceiver_wallet_id(String receiver_wallet_id) {
        this.receiver_wallet_id = receiver_wallet_id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSender_full_name() {
        return sender_full_name;
    }

    public void setSender_full_name(String sender_full_name) {
        this.sender_full_name = sender_full_name;
    }

    public String getReceiver_full_name() {
        return receiver_full_name;
    }

    public void setReceiver_full_name(String receiver_full_name) {
        this.receiver_full_name = receiver_full_name;
    }

    public String getSender_phone_number() {
        return sender_phone_number;
    }

    public void setSender_phone_number(String sender_phone_number) {
        this.sender_phone_number = sender_phone_number;
    }

    public String getReceiver_phone_number() {
        return receiver_phone_number;
    }

    public void setReceiver_phone_number(String receiver_phone_number) {
        this.receiver_phone_number = receiver_phone_number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
