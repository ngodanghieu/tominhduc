package com.payment.wallet.model.request;

public class UserLoginRequest {
    private  String phone_number;
    private String pass;
    private String phone_reference;

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPhone_reference() {
        return phone_reference;
    }

    public void setPhone_reference(String phone_reference) {
        this.phone_reference = phone_reference;
    }
}
