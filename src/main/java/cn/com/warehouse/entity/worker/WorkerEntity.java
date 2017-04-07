package cn.com.warehouse.entity.worker;

/**
 * 员工实体类
 *
 */
public class WorkerEntity {

	// 工号
	private String workerNumber;
	// 姓名
	private String workerName;
	// 联系方式
	private String phone;
	// 备注
	private String remark;

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}