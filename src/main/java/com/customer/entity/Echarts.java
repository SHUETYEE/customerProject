package com.customer.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.io.Serializable;

/**
 * (Echarts)实体类
 *
 * @author makejava
 * @since 2019-12-03 10:21:30
 */
@ApiModel("用户实体类")
public class Echarts implements Serializable {
    private static final long serialVersionUID = -48024620826259427L;
    
    private Integer id;

    @ApiModelProperty("名字")
    private String name;
    
    private Integer value;
    
    private Date createtime;

    private Integer price;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

}