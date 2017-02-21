package cn.com.warehouse.controller.shop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 用户登录控制层
 *
 */
@Controller
public class ShopController {


	/**
	 * 跳转到商铺列表
	 * 
	 * @return String
	 */
	@RequestMapping(value = "/shop", method = RequestMethod.GET)
	public String asdasd(Model model) {
		System.out.println("shop");
		return "shop/shop_list";
	}

}
