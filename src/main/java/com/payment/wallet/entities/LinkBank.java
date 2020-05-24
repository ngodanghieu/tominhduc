package com.payment.wallet.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "the_ngan_hang", catalog = "6g")
public class LinkBank {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "link_bank_id")
    private Long link_bank_id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "name")
    private String name;

    @Column(name = "card_number")
    private String card_number;
    @Column(name = "start_date")
    private Date start_date;

    @Column(name = "expire_date")
    private Date expire_date;

    @Column(name = "birthdate")
    private Date birthdate;

    @Column(name = "sex")
    private String sex;

    @Column(name = "timestamp")
    private Date timestamp;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLink_bank_id() {
        return link_bank_id;
    }

    public void setLink_bank_id(Long link_bank_id) {
        this.link_bank_id = link_bank_id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long user_id) {
        this.userId = user_id;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getExpire_date() {
        return expire_date;
    }

    public void setExpire_date(Date expire_date) {
        this.expire_date = expire_date;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
