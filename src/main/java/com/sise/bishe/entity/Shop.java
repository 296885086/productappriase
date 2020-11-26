package com.sise.bishe.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "shop")
public class Shop {
    @Id
    private Integer id;

    private String username;

    private String password;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 名字
     */
    @Column(name = "shop_name")
    private String shopName;

    /**
     * 发货地址
     */
    private String address;

    /**
     * 店家介绍
     */
    private String content;

    /**
     * 头像
     */
    private String pic;

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
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取名字
     *
     * @return shop_name - 名字
     */
    public String getShopName() {
        return shopName;
    }

    /**
     * 设置名字
     *
     * @param shopName 名字
     */
    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    /**
     * 获取发货地址
     *
     * @return address - 发货地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置发货地址
     *
     * @param address 发货地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取店家介绍
     *
     * @return content - 店家介绍
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置店家介绍
     *
     * @param content 店家介绍
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 获取头像
     *
     * @return pic - 头像
     */
    public String getPic() {
        return pic;
    }

    /**
     * 设置头像
     *
     * @param pic 头像
     */
    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }
}