package cn.com.warehouse.service.goods;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.warehouse.dao.goods.GoodsDao;
import cn.com.warehouse.entity.goods.GoodsEntity;
import cn.com.warehouse.util.Paging;

/**
 * @author 货物事务管理
 *
 */
@Service
public class GoodsService {

	@Resource
	private GoodsDao goodsDao;

	/**
	 * 分页查询货物列表
	 * 
	 * @return Page
	 */
	public Paging<GoodsEntity> getGoodsList(Paging<GoodsEntity> page) {
		page.setList(goodsDao.getGoodsList(page));
		return page;
	}

	/**
	 * 根据ID查询货物
	 * 
	 * @return ServiceEntity
	 */
	public GoodsEntity getGoodsById(long goodsId) {
		return goodsDao.getGoodsById(goodsId);
	}

	/**
	 * 新增货物
	 * 
	 */
	public void createGoods(GoodsEntity goods) {
		goodsDao.createGoods(goods);
	}

	/**
	 * 修改货物
	 * 
	 */
	public void updateGoods(GoodsEntity goods) {
		goodsDao.updateGoods(goods);
	}

	/**
	 * 删除货物
	 * 
	 */
	public void deleteGoods(long goodsId) {
		goodsDao.deleteGoods(goodsId);
	}

	/**
	 * 校验货物名称是否存在
	 * 
	 * @return boolean
	 */
	public boolean checkGoodsName(GoodsEntity goods) {
		if (goods.getGoodsId() != null) {
			if (goodsDao.getGoodsById(goods.getGoodsId()).getGoodsName().equals(goods.getGoodsName())) {
				return true;
			}
		}
		int count = goodsDao.getCountByName(goods.getGoodsName());
		if (count > 0) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * 获取所有货物信息
	 * 
	 * @return Page
	 */
	public List<GoodsEntity> getAllGoods() {
		return goodsDao.getAllGoods();
	}
}
