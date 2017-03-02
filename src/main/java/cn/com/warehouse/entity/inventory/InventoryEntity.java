package cn.com.warehouse.entity.inventory;

/**
 * 库存实体类
 *
 */
public class InventoryEntity {

	// 货物ID
	private Long goodsId;;
	// 库存量
	private Integer quantity;

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}