package cn.com.warehouse.dao.statistics;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.com.warehouse.entity.statistics.ShopStatisticsEntity;
import cn.com.warehouse.entity.statistics.WorkerStatisticsEntity;
import cn.com.warehouse.util.Paging;

/**
 * 统计DAO
 *
 */
@Repository
public class StatisticsDao {

	@Resource
	private JdbcTemplate jdbcTemplate;

	/**
	 * 店铺合计
	 * 
	 */
	public List<ShopStatisticsEntity> getShopStatisticsList(Paging<ShopStatisticsEntity> page, Integer type) {
		String str = "";
		switch (type) {
		case 1:
			str = "and YEAR(trade_time)=YEAR(NOW())";
			break;
		case 2:
			str = "and date_format(trade_time,'%Y-%m')=date_format(now(),'%Y-%m') ";
			break;
		default:
			str = "";
			break;
		}
		String sql = "SELECT s.shop_id," +
					        "s.shop_name," +
					        "sum(CASE t.type WHEN 0 THEN t.price*t.amount END) receiveFeeTotal," +
					        "sum(CASE t.type WHEN 1 THEN t.price*t.amount END) sendFeeTotal," +
					        "sum(CASE t.type WHEN 1 THEN t.amount END) sendTotal " +
				 	 "FROM trade t,shop s " +
					 "WHERE t.target = s.shop_id " + 
				 	 str +
					 "GROUP BY s.shop_id,s.shop_name " +
					 "LIMIT ?,?";
		return (List<ShopStatisticsEntity>) jdbcTemplate.query(sql,
				new Object[] { page.getStartRow(), page.getNumPerPage() }, new BeanPropertyRowMapper<ShopStatisticsEntity>(
						ShopStatisticsEntity.class));
	}

	/**
	 * 查询店铺数量
	 * 
	 * @return Page
	 */
	public Integer getShopStatisticsListCount(Integer type) {
		String str = "";
		switch (type) {
		case 1:
			str = "and YEAR(trade_time)=YEAR(NOW())";
			break;
		case 2:
			str = "and date_format(trade_time,'%Y-%m')=date_format(now(),'%Y-%m') ";
			break;
		default:
			str = "";
			break;
		}
		String sql = "select count(*) from (select count(*) from trade where target > 0 " + str + "GROUP BY target) c";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	/**
	 * 人员合计
	 * 
	 */
	public List<WorkerStatisticsEntity> getWorkerStatisticsList(Paging<WorkerStatisticsEntity> page, Integer type) {
		String str = "";
		switch (type) {
		case 1:
			str = "and YEAR(dispatch_date)=YEAR(NOW())";
			break;
		case 2:
			str = "and date_format(dispatch_date,'%Y-%m')=date_format(now(),'%Y-%m') ";
			break;
		default:
			str = "";
			break;
		}
		String sql = "select d.worker_number,w.worker_name,sum(d.dispatch_time) dayTotal,sum(d.receive_money) receiveTotal,sum(d.pay_money) sendTotal from dispatch d,worker w where d.worker_number = w.worker_number "
				+ str + " LIMIT ?,?";
		return (List<WorkerStatisticsEntity>) jdbcTemplate.query(sql,
				new Object[] { page.getStartRow(), page.getNumPerPage() },
				new BeanPropertyRowMapper<WorkerStatisticsEntity>(WorkerStatisticsEntity.class));
	}
	
	/**
	 * 查询人员数量
	 * 
	 * @return Page
	 */
	public Integer getWorkerStatisticsListCount(Integer type) {
		String str = "";
		switch (type) {
		case 1:
			str = "and YEAR(dispatch_date)=YEAR(NOW())";
			break;
		case 2:
			str = "and date_format(dispatch_date,'%Y-%m')=date_format(now(),'%Y-%m') ";
			break;
		default:
			str = "";
			break;
		}
		String sql = "select count(*) from (select count(*) from dispatch where 1 = 1 " + str + " GROUP BY worker_number) c";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

}
