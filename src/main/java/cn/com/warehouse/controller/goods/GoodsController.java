package cn.com.warehouse.controller.goods;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.warehouse.entity.goods.GoodsEntity;
import cn.com.warehouse.service.goods.GoodsService;
import cn.com.warehouse.util.Paging;

/**
 * @author 货物控制层
 *
 */
@Controller
public class GoodsController {

	@Resource
	private GoodsService goodsService;

	/**
	 * 跳转到货物列表
	 * 
	 * @return String
	 */
	@RequestMapping(value = "/goodsList", method = RequestMethod.GET)
	public String goodsList(Model model, Paging<GoodsEntity> page) {
		model.addAttribute("page", goodsService.getGoodsList(page));
		return "goods/goods_list";
	}

	/**
	 * 跳转到添加货物
	 * 
	 * @return String
	 */
	@RequestMapping(value = "/createGoods", method = RequestMethod.GET)
	public String createPage(Model model) {
		return "goods/goods_create";
	}

	/**
	 * 跳转到编辑货物
	 * 
	 * @return String
	 */
	@RequestMapping(value = "/updateGoods", method = RequestMethod.GET)
	public String updatePage(Model model, @RequestParam int goodsId) {
		model.addAttribute("goods", goodsService.getGoodsById(goodsId));
		return "goods/goods_update";
	}
	
	/**
	 * 跳转到货物详情
	 * 
	 * @return String
	 */
	@RequestMapping(value = "/goodsDetail", method = RequestMethod.GET)
	public String goodsDetail(Model model, @RequestParam int goodsId) {
		model.addAttribute("goods", goodsService.getGoodsById(goodsId));
		return "goods/goods_detail";
	}

	/**
	 * 新增货物
	 * 
	 * @return String
	 */
	@RequestMapping(value = "/createGoods", method = RequestMethod.POST)
	public String createGoods(GoodsEntity goods) {
		goodsService.createGoods(goods);
		return "redirect:/goodsList";
	}

	/**
	 * 编辑货物
	 * 
	 * @return String
	 */
	@RequestMapping(value = "/updateGoods", method = RequestMethod.POST)
	public String updateGoods(GoodsEntity goods) {
		goodsService.updateGoods(goods);
		return "redirect:/goodsList";
	}

	/**
	 * 删除货物
	 * 
	 * @return String
	 */
	@RequestMapping(value = "/deleteGoods", method = RequestMethod.GET)
	public String deleteGoods(long goodsId) {
		goodsService.deleteGoods(goodsId);
		return "redirect:/goodsList";
	}

	/**
	 * 校验货物名称是否存在
	 * 
	 * @return boolean
	 */
	@RequestMapping(value = "/checkGoodsName", method = RequestMethod.POST)
	@ResponseBody
	private boolean checkGoodsName(GoodsEntity goods) {
		return goodsService.checkGoodsName(goods);
	}
}
