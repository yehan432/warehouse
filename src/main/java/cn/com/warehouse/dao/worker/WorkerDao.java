package cn.com.warehouse.dao.worker;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.com.warehouse.entity.dispatch.DispatchEntity;
import cn.com.warehouse.entity.worker.WorkerEntity;
import cn.com.warehouse.util.Paging;

/**
 * 员工DAO
 *
 */
@Repository
public class WorkerDao {

	@Resource
	private JdbcTemplate jdbcTemplate;

	/**
	 * 分页查询员工列表
	 * 
	 * @return List<WorkerEntity>
	 */
	public List<WorkerEntity> getWorkerList(Paging<WorkerEntity> page) {
		String sql = "SELECT * FROM worker order by worker_number LIMIT ?,?";
		List<WorkerEntity> list = (List<WorkerEntity>) jdbcTemplate.query(sql,
				new Object[] { page.getStartRow(), page.getNumPerPage() }, new BeanPropertyRowMapper<WorkerEntity>(
						WorkerEntity.class));
		return list;
	}

	/**
	 * 根据ID查询员工
	 * 
	 * @return WorkerEntity
	 */
	public WorkerEntity getWorkerById(long workerNumber) {
		String sql = "select * from worker where worker_number=?";
		WorkerEntity worker = (WorkerEntity) jdbcTemplate.queryForObject(sql, new Object[] { workerNumber },
				new BeanPropertyRowMapper<WorkerEntity>(WorkerEntity.class));
		return worker;
	}

	/**
	 * 根据工号查询员工是否存在
	 * 
	 * @return WorkerEntity
	 */
	public int getCountByNumber(String workerNumber) {
		String sql = "select count(*) from worker where worker_number=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { workerNumber }, Integer.class);
	}

	/**
	 * 新增员工
	 * 
	 */
	public void createWorker(WorkerEntity worker) {
		String sql = "insert into worker(worker_number, worker_name, phone, remark) values(?, ?, ?, ?)";
		jdbcTemplate.update(sql, new Object[] { worker.getWorkerNumber(), worker.getWorkerName(), worker.getPhone(),
				worker.getRemark() });
	}

	/**
	 * 编辑员工
	 * 
	 */
	public void updateWorker(WorkerEntity worker) {
		String sql = "update worker set worker_name=?,phone=?,remark=? where worker_number=?";
		jdbcTemplate
				.update(sql,
						new Object[] { worker.getWorkerName(), worker.getPhone(), worker.getRemark(),
								worker.getWorkerNumber() });
	}

	/**
	 * 删除员工
	 * 
	 */
	public void deleteWorker(long workerNumber) {
		String sql = "delete from worker where worker_number=?";
		jdbcTemplate.update(sql, new Object[] { workerNumber });
	}

	/**
	 * 新增派遣
	 * 
	 */
	public void createDispatch(DispatchEntity dispatch) {
		String sql = "insert into dispatch(worker_number, dispatch_date, dispatch_time, receive_money, pay_money, work_location, remark) values(?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(
				sql,
				new Object[] { dispatch.getWorkerNumber(), dispatch.getDispatchDate(), dispatch.getDispatchTime(),
						dispatch.getReceiveMoney(), dispatch.getPayMoney(), dispatch.getWorkLocation(),
						dispatch.getRemark() });
	}

	/**
	 * 根据工号查看派遣详细
	 * 
	 * @return WorkerEntity
	 */
	public List<DispatchEntity> dispatchList(Paging<DispatchEntity> page, String workerNumber) {
		String sql = "SELECT * FROM dispatch where worker_number = ? order by dispatch_date DESC LIMIT ?,?";
		List<DispatchEntity> list = (List<DispatchEntity>) jdbcTemplate.query(sql,
				new Object[] { workerNumber, page.getStartRow(), page.getNumPerPage() },
				new BeanPropertyRowMapper<DispatchEntity>(DispatchEntity.class));
		return list;
	}

}
