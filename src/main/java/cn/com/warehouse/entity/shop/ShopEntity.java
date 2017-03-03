package cn.com.warehouse.entity.shop;

import java.math.BigDecimal;


/**
 * 店铺实体类
 *
 */
public class ShopEntity {

	// ID
	private Long shopId;
	// 店铺名称
	private String shopName;
	// 加盟费
	private BigDecimal shopFee;
	
	public Long getShopId() {
		return shopId;
	}
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public BigDecimal getShopFee() {
		return shopFee;
	}
	public void setShopFee(BigDecimal shopFee) {
		this.shopFee = shopFee;
	}

}