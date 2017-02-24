package cn.com.warehouse.service.shop;

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
		return page;
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
}
