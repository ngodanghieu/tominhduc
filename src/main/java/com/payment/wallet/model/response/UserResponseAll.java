package com.payment.wallet.model.response;

import jdk.nashorn.internal.objects.annotations.Property;

public class UserResponseAll {
    @Property(name = "user_id")
    private Integer userId;
    @Property(name = "full_name")
    private String full_name;
    @Property(name = "phone_number")
    private String phone_number;
    @Property(name = "password")
    private String password;
    @Property(name = "email")
    private String email;
    @Property(name = "timestamp")
    private String timestamp;
    @Property(name = "photo")
    private String photo;
    @Property(name = "wallet_id")
    private String walletId;
    @Property(name = "6G_reference")
    private Object _6GReference;
    @Property(name = "role")
    private String role;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    public Object get_6GReference() {
        return _6GReference;
    }

    public void set_6GReference(Object _6GReference) {
        this._6GReference = _6GReference;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
