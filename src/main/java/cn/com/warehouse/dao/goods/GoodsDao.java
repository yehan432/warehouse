package cn.com.warehouse.dao.goods;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.com.warehouse.entity.goods.GoodsEntity;
import cn.com.warehouse.util.Paging;

/**
 * 货物DAO
 *
 */
@Repository
public class GoodsDao {

	@Resource
	private JdbcTemplate jdbcTemplate;

	/**
	 * 分页查询货物列表
	 * 
	 * @return List<GoodsEntity>
	 */
	public List<GoodsEntity> getGoodsList(Paging<GoodsEntity> page) {
		String sql = "SELECT * FROM goods order by goods_id desc LIMIT ?,?";
		List<GoodsEntity> list = (List<GoodsEntity>) jdbcTemplate.query(sql,
				new Object[] { page.getStartRow(), page.getNumPerPage() }, new BeanPropertyRowMapper<GoodsEntity>(
						GoodsEntity.class));
		return list;
	}

	/**
	 * 根据ID查询货物
	 * 
	 * @return GoodsEntity
	 */
	public GoodsEntity getGoodsById(long goodsId) {
		String sql = "select * from goods where goods_id=?";
		GoodsEntity goods = (GoodsEntity) jdbcTemplate.queryForObject(sql, new Object[] { goodsId },
				new BeanPropertyRowMapper<GoodsEntity>(GoodsEntity.class));
		return goods;
	}

	/**
	 * 根据货物名称查询货物
	 * 
	 * @return GoodsEntity
	 */
	public int getCountByName(String goodsName) {
		String sql = "select count(*) from goods where goods_name=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { goodsName }, Integer.class);
	}

	/**
	 * 新增货物
	 * 
	 */
	public void createGoods(GoodsEntity goods) {
		String sql = "insert into goods(goods_name, brand, specification, remark) values(?, ?, ?, ?)";
		jdbcTemplate.update(sql,
				new Object[] { goods.getGoodsName(), goods.getBrand(), goods.getSpecification(), goods.getRemark() });
	}

	/**
	 * 编辑货物
	 * 
	 */
	public void updateGoods(GoodsEntity goods) {
		String sql = "update goods set goods_name=?,brand=?,specification=?,remark=? where goods_id=?";
		jdbcTemplate.update(sql,
				new Object[] { goods.getGoodsName(), goods.getBrand(), goods.getSpecification(), goods.getRemark(),
						goods.getGoodsId() });
	}

	/**
	 * 删除货物
	 * 
	 */
	public void deleteGoods(long goodsId) {
		String sql = "delete from goods where goods_id=?";
		jdbcTemplate.update(sql, new Object[] { goodsId });
	}

	/**
	 * 获取所有货物信息
	 * 
	 */
	public List<GoodsEntity> getAllGoods() {
		String sql = "SELECT goods_id, goods_name FROM goods";
		List<GoodsEntity> list = (List<GoodsEntity>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<GoodsEntity>(
				GoodsEntity.class));
		return list;
	}

}
