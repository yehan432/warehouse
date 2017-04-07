package cn.com.warehouse.service.worker;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.warehouse.dao.worker.WorkerDao;
import cn.com.warehouse.entity.dispatch.DispatchEntity;
import cn.com.warehouse.entity.worker.WorkerEntity;
import cn.com.warehouse.util.Paging;

/**
 * @author 货物事务管理
 *
 */
@Service
public class WorkerService {

	@Resource
	private WorkerDao workerDao;

	/**
	 * 分页查询员工列表
	 * 
	 * @return List<WorkerEntity>
	 */
	public Paging<WorkerEntity> getWorkerList(Paging<WorkerEntity> page) {
		page.setList(workerDao.getWorkerList(page));
		return page;
	}

	/**
	 * 根据ID查询员工
	 * 
	 * @return WorkerEntity
	 */
	public WorkerEntity getWorkerById(long workerNumber) {
		return workerDao.getWorkerById(workerNumber);
	}

	/**
	 * 新增员工
	 * 
	 */
	public void createWorker(WorkerEntity worker) {
		workerDao.createWorker(worker);
	}

	/**
	 * 编辑员工
	 * 
	 */
	public void updateWorker(WorkerEntity worker) {
		workerDao.updateWorker(worker);
	}

	/**
	 * 删除员工
	 * 
	 */
	public void deleteWorker(long workerNumber) {
		workerDao.deleteWorker(workerNumber);
	}

	/**
	 * 根据工号查询员工是否存在
	 * 
	 * @return WorkerEntity
	 */
	public boolean checkWorkerNumber(String workerNumber) {
		int count = workerDao.getCountByNumber(workerNumber);
		if (count > 0) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * 新增派遣
	 * 
	 */
	public void createDispatch(DispatchEntity dispatch) {
		workerDao.createDispatch(dispatch);
	}

	/**
	 * 根据工号查看派遣详细
	 * 
	 * @return WorkerEntity
	 */
	public Paging<DispatchEntity> dispatchList(Paging<DispatchEntity> page, String workerNumber) {
		page.setList(workerDao.dispatchList(page, workerNumber));
		return page;
	}
}
