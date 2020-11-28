package com.sise.bishe.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 图片路径
 */
@Table(name = "pic")
public class Pic {
    @Id
    private Integer id;

    /**
     * 商品图片路径
     */
    private String pic;

    /**
     * 商品IP
     */
    @Column(name = "goods_id")
    private Integer goodsId;

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
     * 获取商品图片路径
     *
     * @return pic - 商品图片路径
     */
    public String getPic() {
        return pic;
    }

    /**
     * 设置商品图片路径
     *
     * @param pic 商品图片路径
     */
    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    /**
     * 获取商品IP
     *
     * @return goods_id - 商品IP
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * 设置商品IP
     *
     * @param goodsId 商品IP
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }
}