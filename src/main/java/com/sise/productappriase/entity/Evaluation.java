package com.sise.productappriase.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "evaluation")
public class Evaluation {
    @Id
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "goods_id")
    private Integer goodsId;

    /**
     * 评价内容
     */
    private String comment;

    /**
     * 好评分数
     */
    private Integer score;

    /**
     * 评价时间
     */
    @Column(name = "create_time")
    private Date createTime;

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
     * 获取评价内容
     *
     * @return comment - 评价内容
     */
    public String getComment() {
        return comment;
    }

    /**
     * 设置评价内容
     *
     * @param comment 评价内容
     */
    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    /**
     * 获取好评分数
     *
     * @return score - 好评分数
     */
    public Integer getScore() {
        return score;
    }

    /**
     * 设置好评分数
     *
     * @param score 好评分数
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * 获取评价时间
     *
     * @return create_time - 评价时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置评价时间
     *
     * @param createTime 评价时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}