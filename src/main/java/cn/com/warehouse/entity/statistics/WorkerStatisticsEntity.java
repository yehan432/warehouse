package cn.com.warehouse.entity.statistics;

import java.math.BigDecimal;

/**
 * 统计实体类
 *
 */
public class WorkerStatisticsEntity {

	// 工号
	private String workerNumber;
	// 姓名
	private String workerName;
	// 派遣时间合计
	private Float dayTotal;
	// 收款合计
	private BigDecimal receiveTotal;
	// 付款合计
	private BigDecimal sendTotal;

	public String getWorkerNumber() {
		return workerNumber;
	}

	public void setWorkerNumber(String workerNumber) {
		this.workerNumber = workerNumber;
	}

	public String getWorkerName() {
		return workerName;
	}

	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}

	public Float getDayTotal() {
		return dayTotal;
	}

	public void setDayTotal(Float dayTotal) {
		this.dayTotal = dayTotal;
	}

	public BigDecimal getReceiveTotal() {
		return receiveTotal;
	}

	public void setReceiveTotal(BigDecimal receiveTotal) {
		this.receiveTotal = receiveTotal;
	}

	public BigDecimal getSendTotal() {
		return sendTotal;
	}

	public void setSendTotal(BigDecimal sendTotal) {
		this.sendTotal = sendTotal;
	}
}