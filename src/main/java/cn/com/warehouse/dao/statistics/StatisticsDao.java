package cn.com.warehouse.dao.statistics;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.com.warehouse.entity.statistics.StatisticsEntity;
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
	 * 合计
	 * 
	 */
	public List<StatisticsEntity> getStatisticsList(Paging<StatisticsEntity> page) {
		String sql = "SELECT s.shop_id," +
					        "s.shop_name," +
					        "sum(CASE t.type WHEN 0 THEN t.price*t.amount END) receiveFeeTotal," +
					        "sum(CASE t.type WHEN 1 THEN t.price*t.amount END) sendFeeTotal," +
					        "Sum(CASE t.type WHEN 1 THEN t.amount END) sendTotal " +
				 	 "FROM trade t,shop s " +
					 "WHERE t.target = s.shop_id " +
					 "GROUP BY s.shop_id,s.shop_name " +
					 "LIMIT ?,?";
		return (List<StatisticsEntity>) jdbcTemplate.query(sql,
				new Object[] { page.getStartRow(), page.getNumPerPage() }, new BeanPropertyRowMapper<StatisticsEntity>(
						StatisticsEntity.class));
	}

	/**
	 * 查询店铺数量
	 * 
	 * @return Page
	 */
	public Integer getStatisticsListCount() {
		String sql = "select count(*) from (select count(*) from trade where target > 0 GROUP BY target) c";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

}
