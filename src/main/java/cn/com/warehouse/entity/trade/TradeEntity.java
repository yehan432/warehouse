package cn.com.warehouse.entity.trade;

import java.math.BigDecimal;

/**
 * 店铺实体类
 *
 */
public class TradeEntity {

	// ID
	private Long tradeId;
	// 货物ID
	private Long goodsId;
	// 货物名称
	private String goodsName;
	// 价格
	private BigDecimal price;
	// 交易数量
	private Integer amount;
	// 交易时间
	private String tradeTime;
	// 交易目标
	private Long target;
	// 交易类型（0:收款；1:付款）
	private Integer type;

	public Long getTradeId() {
		return tradeId;
	}

	public void setTradeId(Long tradeId) {
		this.tradeId = tradeId;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getTradeTime() {
		return tradeTime;
	}

	public void setTradeTime(String tradeTime) {
		this.tradeTime = tradeTime;
	}

	public Long getTarget() {
		return target;
	}

	public void setTarget(Long target) {
		this.target = target;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}