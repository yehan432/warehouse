package cn.com.warehouse.controller.trade;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.com.warehouse.entity.trade.TradeEntity;
import cn.com.warehouse.service.shop.ShopService;
import cn.com.warehouse.service.trade.TradeService;

/**
 * @author 交易控制层
 *
 */
@Controller
public class TradeController {

	@Resource
	private TradeService tradeService;
	@Resource
	private ShopService shopService;

	/**
	 * 发货
	 * 
	 * @return String
	 */
	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public String send(Model model, TradeEntity trade) {
		tradeService.send(trade);
		shopService.updateFeeById(trade.getTarget(),
				trade.getPrice().negate().multiply(new BigDecimal(trade.getAmount())));
		return "redirect:/shopDetail?shopId=" + trade.getTarget();
	}

	/**
	 * 收款
	 * 
	 * @return String
	 */
	@RequestMapping(value = "/receive", method = RequestMethod.POST)
	public String receive(Model model, TradeEntity trade) {
		tradeService.receive(trade);
		shopService.updateFeeById(trade.getTarget(), trade.getPrice());
		return "redirect:/shopDetail?shopId=" + trade.getTarget();
	}
}
