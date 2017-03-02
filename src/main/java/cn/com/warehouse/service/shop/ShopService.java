package cn.com.warehouse.service.shop;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.warehouse.dao.shop.ShopDao;
import cn.com.warehouse.entity.shop.ShopEntity;
import cn.com.warehouse.util.Paging;

/**
 * @author 店铺事务管理
 *
 */
@Service
public class ShopService {

	@Resource
	private ShopDao shopDao;

	/**
	 * 分页查询店铺列表
	 * 
	 * @return Page
	 */
	public Paging<ShopEntity> getShopList(Paging<ShopEntity> page) {
		page.setList(shopDao.getShopList(page));
		int count = shopDao.getShopListCount();
		page.setTotalRow(count);
		page.setTotalPage((count + page.getNumPerPage() - 1) / page.getNumPerPage());
		return page;
	}
	
	/**
	 * 查询店铺数量
	 * 
	 * @return Page
	 */
	public Integer getShopListCount() {
		return shopDao.getShopListCount();
	}

	/**
	 * 根据ID查询店铺
	 * 
	 * @return ServiceEntity
	 */
	public ShopEntity getShopById(long shopId) {
		return shopDao.getShopById(shopId);
	}

	/**
	 * 新增店铺
	 * 
	 */
	public void createShop(ShopEntity shop) {
		shopDao.createShop(shop);
	}

	/**
	 * 修改店铺
	 * 
	 */
	public void updateShop(ShopEntity shop) {
		shopDao.updateShop(shop);
	}

	/**
	 * 删除店铺
	 * 
	 */
	public void deleteShop(long shopId) {
		shopDao.deleteShop(shopId);
	}

	/**
	 * 校验店铺名称是否存在
	 * 
	 * @return boolean
	 */
	public boolean checkShopName(ShopEntity shop) {
		if (shop.getShopId() != null) {
			if (shopDao.getShopById(shop.getShopId()).getShopName().equals(shop.getShopName())) {
				return true;
			}
		}
		int count = shopDao.getCountByName(shop.getShopName());
		if (count > 0) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * 店铺收付款
	 * 
	 */
	public void updateFeeById(long shopId, BigDecimal fee) {
		shopDao.updateFeeById(shopId, fee);
	}
}
