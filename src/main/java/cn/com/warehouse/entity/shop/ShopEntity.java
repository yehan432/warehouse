package cn.com.warehouse.entity.shop;


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
	private Integer shopFee;
	
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
	public Integer getShopFee() {
		return shopFee;
	}
	public void setShopFee(Integer shopFee) {
		this.shopFee = shopFee;
	}

}