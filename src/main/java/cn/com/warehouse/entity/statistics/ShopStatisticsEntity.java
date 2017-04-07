package cn.com.warehouse.entity.statistics;

import java.math.BigDecimal;

/**
 * 统计实体类
 *
 */
public class ShopStatisticsEntity {

	// ID
	private Long shopId;
	// 店铺名称
	private String shopName;
	// 收费合计
	private BigDecimal receiveFeeTotal;
	// 发货合计
	private Integer sendTotal;
	// 发货金额合计
	private BigDecimal sendFeeTotal;
	
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
	public BigDecimal getReceiveFeeTotal() {
		return receiveFeeTotal;
	}
	public void setReceiveFeeTotal(BigDecimal receiveFeeTotal) {
		this.receiveFeeTotal = receiveFeeTotal;
	}
	public Integer getSendTotal() {
		return sendTotal;
	}
	public void setSendTotal(Integer sendTotal) {
		this.sendTotal = sendTotal;
	}
	public BigDecimal getSendFeeTotal() {
		return sendFeeTotal;
	}
	public void setSendFeeTotal(BigDecimal sendFeeTotal) {
		this.sendFeeTotal = sendFeeTotal;
	}

}