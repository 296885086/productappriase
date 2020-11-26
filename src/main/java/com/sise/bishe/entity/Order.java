package com.sise.bishe.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "order")
public class Order {
    @Id
    private String id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "goods_id")
    private Integer goodsId;

    /**
     * 收货地址
     */
    private String address;

    /**
     * 商品数量
     */
    private Integer account;

    /**
     * 总价
     */
    private Double total;

    /**
     * 购买时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

    /**
     * @return goods_id
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * @param goodsId
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * 获取收货地址
     *
     * @return address - 收货地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置收货地址
     *
     * @param address 收货地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取商品数量
     *
     * @return account - 商品数量
     */
    public Integer getAccount() {
        return account;
    }

    /**
     * 设置商品数量
     *
     * @param account 商品数量
     */
    public void setAccount(Integer account) {
        this.account = account;
    }

    /**
     * 获取总价
     *
     * @return total - 总价
     */
    public Double getTotal() {
        return total;
    }

    /**
     * 设置总价
     *
     * @param total 总价
     */
    public void setTotal(Double total) {
        this.total = total;
    }

    /**
     * 获取购买时间
     *
     * @return create_time - 购买时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置购买时间
     *
     * @param createTime 购买时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}