package cn.com.warehouse.service.inventory;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.warehouse.dao.inventory.InventoryDao;
import cn.com.warehouse.entity.inventory.InventoryEntity;
import cn.com.warehouse.util.Paging;

/**
 * @author 库存事务管理
 *
 */
@Service
public class InventoryService {

	@Resource
	private InventoryDao inventoryDao;

	/**
	 * 分页查询库存列表
	 * 
	 * @return Page
	 */
	public Paging<InventoryEntity> getInventoryList(Paging<InventoryEntity> page) {
		page.setList(inventoryDao.getInventoryList(page));
		int count = inventoryDao.getInventoryListCount();
		page.setTotalRow(count);
		page.setTotalPage((count + page.getNumPerPage() - 1) / page.getNumPerPage());
		return page;
	}

	/**
	 * 入库
	 * 
	 */
	public void warehousing(InventoryEntity inventory) {
		if (inventoryDao.checkGoods(inventory.getGoodsId()) == 0) {
			inventoryDao.insertGoods(inventory);
		} else {
			inventoryDao.updateGoods(inventory.getGoodsId(), inventory.getQuantity());
		}
	}

	/**
	 * 出库
	 * 
	 */
	public void extract(long goodsId, int quantity) {
		inventoryDao.updateGoods(goodsId, -quantity);
	}

	/**
	 * 更改库存
	 * 
	 */
	public void updateGoods(long goodsId, int quantity) {
		inventoryDao.updateGoods(goodsId, quantity);
	}
	
	/**
	 * 查询库存信息
	 * 
	 */
	public InventoryEntity getInventoryById(long goodsId) {
		return inventoryDao.getInventoryById(goodsId);
	}
	
	/**
	 * 修改库存(录入错误时修改用)
	 * 
	 */
	public void updateInventory(InventoryEntity inventory) {
		inventoryDao.updateInventory(inventory);
	}

}
