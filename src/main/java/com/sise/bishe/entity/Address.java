package com.sise.bishe.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 地址
 */
@Table(name = "address")
public class Address {
    @Id
    private Integer id;

    @Column(name = "address_name")
    private String addressName;

    @Column(name = "user_id")
    private Integer userId;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return address_name
     */
    public String getAddressName() {
        return addressName;
    }

    /**
     * @param addressName
     */
    public void setAddressName(String addressName) {
        this.addressName = addressName == null ? null : addressName.trim();
    }

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}