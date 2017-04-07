package cn.com.warehouse.entity.dispatch;

import java.math.BigDecimal;

/**
 * 派遣记录实体类
 *
 */
public class DispatchEntity {

	// 工号
	private String workerNumber;
	// 派遣日期
	private String dispatchDate;
	// 派遣时间
	private float dispatchTime;
	// 收款金额
	private BigDecimal receiveMoney;
	// 付款金额
	private BigDecimal payMoney;
	// 工作地点
	private String workLocation;
	// 备注
	private String remark;

	public String getWorkerNumber() {
		return workerNumber;
	}

	public void setWorkerNumber(String workerNumber) {
		this.workerNumber = workerNumber;
	}

	public String getDispatchDate() {
		return dispatchDate;
	}

	public void setDispatchDate(String dispatchDate) {
		this.dispatchDate = dispatchDate;
	}

	public float getDispatchTime() {
		return dispatchTime;
	}

	public void setDispatchTime(float dispatchTime) {
		this.dispatchTime = dispatchTime;
	}

	public BigDecimal getReceiveMoney() {
		return receiveMoney;
	}

	public void setReceiveMoney(BigDecimal receiveMoney) {
		this.receiveMoney = receiveMoney;
	}

	public BigDecimal getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(BigDecimal payMoney) {
		this.payMoney = payMoney;
	}

	public String getWorkLocation() {
		return workLocation;
	}

	public void setWorkLocation(String workLocation) {
		this.workLocation = workLocation;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}