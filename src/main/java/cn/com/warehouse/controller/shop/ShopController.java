package cn.com.warehouse.controller.shop;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.warehouse.entity.shop.ShopEntity;
import cn.com.warehouse.entity.trade.TradeEntity;
import cn.com.warehouse.service.goods.GoodsService;
import cn.com.warehouse.service.shop.ShopService;
import cn.com.warehouse.service.trade.TradeService;
import cn.com.warehouse.util.Paging;

/**
 * @author 店铺控制层
 *
 */
@Controller
public class ShopController {

	@Resource
	private ShopService shopService;
	@Resource
	private GoodsService goodsService;
	@Resource
	private TradeService tradeService;

	/**
	 * 跳转到店铺列表
	 * 
	 * @return String
	 */
	@RequestMapping(value = "/shopList", method = RequestMethod.GET)
	public String shopList(Model model, Paging<ShopEntity> page) {
		model.addAttribute("page", shopService.getShopList(page));
		return "shop/shop_list";
	}

	/**
	 * 跳转到添加店铺
	 * 
	 * @return String
	 */
	@RequestMapping(value = "/createShop", method = RequestMethod.GET)
	public String createPage(Model model) {
		return "shop/shop_create";
	}

	/**
	 * 跳转到编辑店铺
	 * 
	 * @return String
	 */
	@RequestMapping(value = "/updateShop", method = RequestMethod.GET)
	public String updatePage(Model model, @RequestParam long shopId) {
		model.addAttribute("shop", shopService.getShopById(shopId));
		return "shop/shop_update";
	}
	
	/**
	 * 跳转到店铺详情
	 * 
	 * @return String
	 */
	@RequestMapping(value = "/shopDetail", method = RequestMethod.GET)
	public String shopDetail(Model model, @RequestParam long shopId, Paging<TradeEntity> page) {
		model.addAttribute("goodsList", goodsService.getAllGoods());
		model.addAttribute("shop", shopService.getShopById(shopId));
		model.addAttribute("page", tradeService.getTradeByShopId(page, shopId));
		return "shop/shop_detail";
	}

	/**
	 * 新增店铺
	 * 
	 * @return String
	 */
	@RequestMapping(value = "/createShop", method = RequestMethod.POST)
	public String createShop(ShopEntity shop) {
		shopService.createShop(shop);
		return "redirect:/shopList";
	}

	/**
	 * 编辑店铺
	 * 
	 * @return String
	 */
	@RequestMapping(value = "/updateShop", method = RequestMethod.POST)
	public String updateShop(ShopEntity shop) {
		shopService.updateShop(shop);
		return "redirect:/shopList";
	}

	/**
	 * 删除店铺
	 * 
	 * @return String
	 */
	@RequestMapping(value = "/deleteShop", method = RequestMethod.GET)
	public String deleteShop(long shopId) {
		shopService.deleteShop(shopId);
		return "redirect:/shopList";
	}

	/**
	 * 校验店铺名称是否存在
	 * 
	 * @return boolean
	 */
	@RequestMapping(value = "/checkShopName", method = RequestMethod.POST)
	@ResponseBody
	private boolean checkShopName(ShopEntity shop) {
		return shopService.checkShopName(shop);
	}
}
