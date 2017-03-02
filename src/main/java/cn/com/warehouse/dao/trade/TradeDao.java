package cn.com.warehouse.dao.trade;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.com.warehouse.entity.trade.TradeEntity;
import cn.com.warehouse.util.Paging;

/**
 * 交易DAO
 *
 */
@Repository
public class TradeDao {

	@Resource
	private JdbcTemplate jdbcTemplate;

	/**
	 * 新增发货交易
	 * 
	 */
	public void send(TradeEntity trade) {
		String sql = "insert into trade(goods_id, price, amount, trade_time, target, type) values(?, ?, ?, NOW(), ?, 1)";
		jdbcTemplate.update(sql,
				new Object[] { trade.getGoodsId(), trade.getPrice(), trade.getAmount(), trade.getTarget() });
	}

	/**
	 * 新增收款交易
	 * 
	 */
	public void receive(TradeEntity trade) {
		String sql = "insert into trade(price, amount, trade_time, target, type) values(?, 1, NOW(), ?, 0)";
		jdbcTemplate.update(sql, new Object[] { trade.getPrice(), trade.getTarget() });
	}

	/**
	 * 根据商户查询交易记录
	 * 
	 */
	public List<TradeEntity> getTradeByShopId(Paging<TradeEntity> page, long shopId) {
		String sql = "SELECT t.*, s.goods_name FROM trade t "
					+ "LEFT JOIN goods s on t.goods_id = s.goods_id "
					+ "where target = ? "
					+ "order by trade_time desc "
					+ "LIMIT ?, ?";
		List<TradeEntity> list = (List<TradeEntity>) jdbcTemplate.query(sql, new Object[] { shopId, page.getStartRow(),
				page.getNumPerPage() }, new BeanPropertyRowMapper<TradeEntity>(TradeEntity.class));
		return list;
	}
	
	/**
	 * 查询店铺交易数量
	 * 
	 * @return Integer
	 */
	public Integer getTradeListCountByShopId(long shopId) {
		String sql = "select count(*) from trade where target = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { shopId }, Integer.class);
	}

}
