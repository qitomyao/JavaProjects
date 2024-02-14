package com.itheima.pojo;

import java.sql.Timestamp;

// 封装Order表的数据
public class Order {
    private Integer oId;
    private Integer userId;
    private String number;
    private Timestamp createTime; //java.sql.Timestamp;
    private String note;


    public Order() {
    }

    public Order(Integer oId, Integer userId, String number, Timestamp createTime, String note) {
        this.oId = oId;
        this.userId = userId;
        this.number = number;
        this.createTime = createTime;
        this.note = note;
    }

    /**
     * 获取
     * @return oId
     */
    public Integer getOId() {
        return oId;
    }

    /**
     * 设置
     * @param oId
     */
    public void setOId(Integer oId) {
        this.oId = oId;
    }

    /**
     * 获取
     * @return userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取
     * @return number
     */
    public String getNumber() {
        return number;
    }

    /**
     * 设置
     * @param number
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * 获取
     * @return createTime
     */
    public Timestamp getCreateTime() {
        return createTime;
    }

    /**
     * 设置
     * @param createTime
     */
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取
     * @return note
     */
    public String getNote() {
        return note;
    }

    /**
     * 设置
     * @param note
     */
    public void setNote(String note) {
        this.note = note;
    }

    public String toString() {
        return "Order{oId = " + oId + ", userId = " + userId + ", number = " + number + ", createTime = " + createTime + ", note = " + note + "}";
    }
}
