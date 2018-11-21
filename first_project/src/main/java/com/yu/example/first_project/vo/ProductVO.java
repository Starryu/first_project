package com.yu.example.first_project.vo;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 产品实体类
 * @author yuxingcheng
 * @date 2018-11-5
 */
public class ProductVO {
    /**
     * 产品Id，数据库自增主键
     */

    private String productId;

    /**
     * 产品的名称
     */
    @NotNull
    private String name;

    /**
     * 产品的库存
     */
    @NotNull
    private Integer inventory;

    /**
     * 添加的时间
     */

    private Date  addTime;

    /**
     * 添加人的ID
     */
    @NotNull
    private String userAddName;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

	public String getUserAddName() {
		return userAddName;
	}

	public void setUserAddName(String userAddName) {
		this.userAddName = userAddName;
	}

}
