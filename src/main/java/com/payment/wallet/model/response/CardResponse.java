package com.payment.wallet.model.response;

public class CardResponse {
    private String debitcard_id;
    private String card_number;
    private String full_name;
    private String start_date;
    private String expire_date;
    private String birthdate;
    private String sex;
    private String user_id;
    private String timestamp;
    private String bank_id;
    private String id_number;

    public String getDebitcard_id() {
        return debitcard_id;
    }

    public String getCard_number() {
        return card_number;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getExpire_date() {
        return expire_date;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getSex() {
        return sex;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getBank_id() {
        return bank_id;
    }

    public String getId_number() {
        return id_number;
    }

    public void setDebitcard_id(String debitcard_id) {
        this.debitcard_id = debitcard_id;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public void setExpire_date(String expire_date) {
        this.expire_date = expire_date;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setBank_id(String bank_id) {
        this.bank_id = bank_id;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }
}
