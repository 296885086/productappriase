package com.sise.bishe.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "goods")
public class Goods {
    @Id
    private Integer id;

    /**
     * 商品名字
     */
    @Column(name = "goods_name")
    private String goodsName;

    /**
     * 商品类型
     */
    @Column(name = "goods_type")
    private Integer goodsType;

    /**
     * 商品标题
     */
    @Column(name = "goods_title")
    private String goodsTitle;

    /**
     * 商品内容介绍
     */
    @Column(name = "goods_content")
    private String goodsContent;

    /**
     * 浏览数
     */
    @Column(name = "goods_look")
    private Integer goodsLook;

    /**
     * 价格
     */
    private Double price;

    /**
     * 店铺id
     */
    @Column(name = "shop_id")
    private Integer shopId;

    /**
     * 海报
     */
    private String pic;

    /**
     * 购买量
     */
    @Column(name = "buy_account")
    private String buyAccount;

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
     * 获取商品名字
     *
     * @return goods_name - 商品名字
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * 设置商品名字
     *
     * @param goodsName 商品名字
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    /**
     * 获取商品类型
     *
     * @return goods_type - 商品类型
     */
    public Integer getGoodsType() {
        return goodsType;
    }

    /**
     * 设置商品类型
     *
     * @param goodsType 商品类型
     */
    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    /**
     * 获取商品标题
     *
     * @return goods_title - 商品标题
     */
    public String getGoodsTitle() {
        return goodsTitle;
    }

    /**
     * 设置商品标题
     *
     * @param goodsTitle 商品标题
     */
    public void setGoodsTitle(String goodsTitle) {
        this.goodsTitle = goodsTitle == null ? null : goodsTitle.trim();
    }

    /**
     * 获取商品内容介绍
     *
     * @return goods_content - 商品内容介绍
     */
    public String getGoodsContent() {
        return goodsContent;
    }

    /**
     * 设置商品内容介绍
     *
     * @param goodsContent 商品内容介绍
     */
    public void setGoodsContent(String goodsContent) {
        this.goodsContent = goodsContent == null ? null : goodsContent.trim();
    }

    /**
     * 获取浏览数
     *
     * @return goods_look - 浏览数
     */
    public Integer getGoodsLook() {
        return goodsLook;
    }

    /**
     * 设置浏览数
     *
     * @param goodsLook 浏览数
     */
    public void setGoodsLook(Integer goodsLook) {
        this.goodsLook = goodsLook;
    }

    /**
     * 获取价格
     *
     * @return price - 价格
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 设置价格
     *
     * @param price 价格
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * 获取店铺id
     *
     * @return shop_id - 店铺id
     */
    public Integer getShopId() {
        return shopId;
    }

    /**
     * 设置店铺id
     *
     * @param shopId 店铺id
     */
    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    /**
     * 获取海报
     *
     * @return pic - 海报
     */
    public String getPic() {
        return pic;
    }

    /**
     * 设置海报
     *
     * @param pic 海报
     */
    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    /**
     * 获取购买量
     *
     * @return buy_account - 购买量
     */
    public String getBuyAccount() {
        return buyAccount;
    }

    /**
     * 设置购买量
     *
     * @param buyAccount 购买量
     */
    public void setBuyAccount(String buyAccount) {
        this.buyAccount = buyAccount == null ? null : buyAccount.trim();
    }
}