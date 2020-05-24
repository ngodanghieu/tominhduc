package com.payment.wallet.model.response;

import jdk.nashorn.internal.objects.annotations.Property;

public class WalletResponse {
    @Property( name = "balance")
    private String balance;
    @Property( name = "user_id")
    private String user_id;
    @Property( name = "wallet_id")
    private String wallet_id;
    @Property( name = "type")
    private String type;
    @Property( name = "timestamp")
    private String timestamp;

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getWallet_id() {
        return wallet_id;
    }

    public void setWallet_id(String wallet_id) {
        this.wallet_id = wallet_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
