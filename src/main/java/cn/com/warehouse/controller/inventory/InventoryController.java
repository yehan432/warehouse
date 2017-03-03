package cn.com.warehouse.controller.inventory;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.com.warehouse.entity.inventory.InventoryEntity;
import cn.com.warehouse.service.goods.GoodsService;
import cn.com.warehouse.service.inventory.InventoryService;
import cn.com.warehouse.service.trade.TradeService;
import cn.com.warehouse.util.Paging;

/**
 * @author 库存控制层
 *
 */
@Controller
public class InventoryController {

	@Resource
	private InventoryService inventoryService;
	@Resource
	private GoodsService goodsService;
	@Resource
	private TradeService tradeService;

	/**
	 * 入库
	 * 
	 * @return String
	 */
	@RequestMapping(value = "/warehousing", method = RequestMethod.POST)
	public String warehousing(Model model, InventoryEntity inventory) {
		inventoryService.warehousing(inventory);
		tradeService.warehousing(inventory.getGoodsId(), inventory.getQuantity());
		return "redirect:/inventoryList";
	}

	/**
	 * 跳转到库存管理列表
	 * 
	 * @return String
	 */
	@RequestMapping(value = "/inventoryList", method = RequestMethod.GET)
	public String shopList(Model model, Paging<InventoryEntity> page) {
		model.addAttribute("goodsList", goodsService.getAllGoods());
		model.addAttribute("page", inventoryService.getInventoryList(page));
		return "inventory/inventory_list";
	}

	/**
	 * 修改库存(录入错误时修改用)
	 * 
	 * @return String
	 */
	@RequestMapping(value = "/updateInventory", method = RequestMethod.POST)
	public String updateInventory(Model model, InventoryEntity inventory) {
		inventoryService.updateInventory(inventory);
		return "redirect:/inventoryList";
	}

	/**
	 * 根据ID获取库存信息
	 * 
	 * @return String
	 */
	@RequestMapping(value = "/updateInventory", method = RequestMethod.GET)
	public String updateInventory(Model model, long goodsId) {
		model.addAttribute("inventory", inventoryService.getInventoryById(goodsId));
		return "inventory/inventory_update";
	}
}
