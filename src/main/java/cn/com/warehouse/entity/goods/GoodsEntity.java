package cn.com.warehouse.entity.goods;

/**
 * 货物实体类
 *
 */
public class GoodsEntity {

	// ID
	private Long goodsId;
	// 货物名称
	private String goodsName;
	// 货物品牌
	private String brand;
	// 产品规格
	private String specification;
	// 备注
	private String remark;

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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}