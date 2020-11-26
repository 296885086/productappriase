package com.sise.productappriase.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user")
public class User {
    @Id
    private Integer id;

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    @Column(name = "real_name")
    private String realName;

    /**
     * 1：男，0：女
     */
    private Integer sex;

    /**
     * 电话
     */
    private String phone;

    /**
     * 默认收货地址
     */
    @Column(name = "default_address")
    private String defaultAddress;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 登陆时间
     */
    @Column(name = "login_time")
    private Date loginTime;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 微信账号
     */
    @Column(name = "wx_username")
    private String wxUsername;

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
     * 获取账号
     *
     * @return username - 账号
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置账号
     *
     * @param username 账号
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取昵称
     *
     * @return real_name - 昵称
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置昵称
     *
     * @param realName 昵称
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * 获取1：男，0：女
     *
     * @return sex - 1：男，0：女
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置1：男，0：女
     *
     * @param sex 1：男，0：女
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取电话
     *
     * @return phone - 电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置电话
     *
     * @param phone 电话
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取默认收货地址
     *
     * @return default_address - 默认收货地址
     */
    public String getDefaultAddress() {
        return defaultAddress;
    }

    /**
     * 设置默认收货地址
     *
     * @param defaultAddress 默认收货地址
     */
    public void setDefaultAddress(String defaultAddress) {
        this.defaultAddress = defaultAddress == null ? null : defaultAddress.trim();
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
     * 获取登陆时间
     *
     * @return login_time - 登陆时间
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * 设置登陆时间
     *
     * @param loginTime 登陆时间
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取微信账号
     *
     * @return wx_username - 微信账号
     */
    public String getWxUsername() {
        return wxUsername;
    }

    /**
     * 设置微信账号
     *
     * @param wxUsername 微信账号
     */
    public void setWxUsername(String wxUsername) {
        this.wxUsername = wxUsername == null ? null : wxUsername.trim();
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", sex=" + sex +
                ", phone='" + phone + '\'' +
                ", defaultAddress='" + defaultAddress + '\'' +
                ", createTime=" + createTime +
                ", loginTime=" + loginTime +
                ", email='" + email + '\'' +
                ", wxUsername='" + wxUsername + '\'' +
                ", pic='" + pic + '\'' +
                '}';
    }
}
