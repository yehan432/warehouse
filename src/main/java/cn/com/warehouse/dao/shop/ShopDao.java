package cn.com.warehouse.dao.shop;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.com.warehouse.entity.shop.ShopEntity;
import cn.com.warehouse.util.Paging;

/**
 * 店铺DAO
 *
 */
@Repository
public class ShopDao {

	@Resource
	private JdbcTemplate jdbcTemplate;

	/**
	 * 分页查询店铺列表
	 * 
	 * @return List<ShopEntity>
	 */
	public List<ShopEntity> getShopList(Paging<ShopEntity> page) {
		String sql = "SELECT * FROM shop LIMIT ?,?";
		List<ShopEntity> list = (List<ShopEntity>) jdbcTemplate.query(sql,
				new Object[] { page.getStartRow(), page.getNumPerPage() }, new BeanPropertyRowMapper<ShopEntity>(
						ShopEntity.class));
		return list;
	}

	/**
	 * 查询店铺数量
	 * 
	 * @return Page
	 */
	public Integer getShopListCount() {
		String sql = "select count(*) from shop";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	/**
	 * 根据ID查询店铺
	 * 
	 * @return ShopEntity
	 */
	public ShopEntity getShopById(long shopId) {
		String sql = "select * from shop where shop_id=?";
		ShopEntity shop = (ShopEntity) jdbcTemplate.queryForObject(sql, new Object[] { shopId },
				new BeanPropertyRowMapper<ShopEntity>(ShopEntity.class));
		return shop;
	}

	/**
	 * 根据店铺名称查询店铺
	 * 
	 * @return ShopEntity
	 */
	public int getCountByName(String shopName) {
		String sql = "select count(*) from shop where shop_name=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { shopName }, Integer.class);
	}

	/**
	 * 新增店铺
	 * 
	 */
	public void createShop(ShopEntity shop) {
		String sql = "insert into shop(shop_name, shop_fee) values(?, ?)";
		jdbcTemplate.update(sql, new Object[] { shop.getShopName(), shop.getShopFee() });
	}

	/**
	 * 编辑店铺
	 * 
	 */
	public void updateShop(ShopEntity shop) {
		String sql = "update shop set shop_name=?,shop_fee=? where shop_id=?";
		jdbcTemplate.update(sql, new Object[] { shop.getShopName(), shop.getShopFee(), shop.getShopId() });
	}

	/**
	 * 删除店铺
	 * 
	 */
	public void deleteShop(long shopId) {
		String sql = "delete from shop where shop_id=?";
		jdbcTemplate.update(sql, new Object[] { shopId });
	}

	/**
	 * 店铺收付款
	 * 
	 */
	public void updateFeeById(long shopId, BigDecimal fee) {
		String sql = "update shop set shop_fee=shop_fee+? where shop_id=?";
		jdbcTemplate.update(sql, new Object[] { fee, shopId });
	}

}
