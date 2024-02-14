package com.itheima.pojo;

// 封装user_info表的数据
public class UserInfo {
    private Integer id;
    private Double height;
    private Double weight;
    private Integer married;


    public UserInfo() {
    }

    public UserInfo(Integer id, Double height, Double weight, Integer married) {
        this.id = id;
        this.height = height;
        this.weight = weight;
        this.married = married;
    }

    /**
     * 获取
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取
     * @return height
     */
    public Double getHeight() {
        return height;
    }

    /**
     * 设置
     * @param height
     */
    public void setHeight(Double height) {
        this.height = height;
    }

    /**
     * 获取
     * @return weight
     */
    public Double getWeight() {
        return weight;
    }

    /**
     * 设置
     * @param weight
     */
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    /**
     * 获取
     * @return married
     */
    public Integer getMarried() {
        return married;
    }

    /**
     * 设置
     * @param married
     */
    public void setMarried(Integer married) {
        this.married = married;
    }

    public String toString() {
        return "UserInfo{id = " + id + ", height = " + height + ", weight = " + weight + ", married = " + married + "}";
    }
}
