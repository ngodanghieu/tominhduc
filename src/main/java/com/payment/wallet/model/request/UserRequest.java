package com.payment.wallet.model.request;

public class UserRequest {
    private String email;
    private String phone_reference;
    private String full_name;
    private String password;
    private String phonenumber;

    public UserRequest(String email, String phone_reference, String full_name, String password, String phonenumber) {
        this.email = email;
        this.phone_reference = phone_reference;
        this.full_name = full_name;
        this.password = password;
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_reference() {
        return phone_reference;
    }

    public void setPhone_reference(String phone_reference) {
        this.phone_reference = phone_reference;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
