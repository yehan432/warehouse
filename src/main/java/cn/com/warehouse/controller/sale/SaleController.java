package cn.com.warehouse.controller.sale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 用户登录控制层
 *
 */
@Controller
public class SaleController {


	/**
	 * 跳转到销售列表
	 * 
	 * @return String
	 */
	@RequestMapping(value = "/sale", method = RequestMethod.GET)
	public String asdasd(Model model) {
		System.out.println("sale");
		return "sale/sale_list";
	}

}
