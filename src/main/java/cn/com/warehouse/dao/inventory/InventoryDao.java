package cn.com.warehouse.dao.inventory;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.com.warehouse.entity.inventory.InventoryEntity;
import cn.com.warehouse.util.Paging;

/**
 * 库存DAO
 *
 */
@Repository
public class InventoryDao {

	@Resource
	private JdbcTemplate jdbcTemplate;

	/**
	 * 新货入库
	 * 
	 */
	public void insertGoods(InventoryEntity inventory) {
		String sql = "insert into inventory(goods_id, quantity) values(?, ?)";
		jdbcTemplate.update(sql, new Object[] { inventory.getGoodsId(), inventory.getQuantity() });
	}

	/**
	 * 库存存储
	 * 
	 */
	public void updateGoods(long goodsId, int quantity) {
		String sql = "update inventory set quantity = quantity + ? where goods_id = ?";
		jdbcTemplate.update(sql, new Object[] { quantity, goodsId });
	}

	/**
	 * 查询库存列表
	 * 
	 */
	public List<InventoryEntity> getInventoryList(Paging<InventoryEntity> page) {
		String sql = "SELECT i.*, s.goods_name FROM inventory i " + "JOIN goods s on i.goods_id = s.goods_id "
				+ "LIMIT ?, ?";
		List<InventoryEntity> list = (List<InventoryEntity>) jdbcTemplate.query(sql, new Object[] { page.getStartRow(),
				page.getNumPerPage() }, new BeanPropertyRowMapper<InventoryEntity>(InventoryEntity.class));
		return list;
	}

	/**
	 * 查询库存列表数量
	 * 
	 * @return Integer
	 */
	public Integer getInventoryListCount() {
		String sql = "select count(*) from inventory";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	/**
	 * 根据货物查询库存
	 * 
	 * @return Integer
	 */
	public Integer checkGoods(long goodsId) {
		String sql = "select count(*) from inventory where goods_id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { goodsId }, Integer.class);
	}

	/**
	 * 修改库存
	 * 
	 */
	public void updateInventory(InventoryEntity inventory) {
		String sql = "update inventory set quantity = ? where goods_id = ?";
		jdbcTemplate.update(sql, new Object[] { inventory.getQuantity(), inventory.getGoodsId() });
	}

	/**
	 * 根据ID获取库存信息
	 * 
	 */
	public InventoryEntity getInventoryById(long goodsId) {
		String sql = "select * from inventory where goods_id = ?";
		return (InventoryEntity) jdbcTemplate.queryForObject(sql, new Object[] { goodsId },
				new BeanPropertyRowMapper<InventoryEntity>(InventoryEntity.class));
	}

}
