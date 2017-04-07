package cn.com.warehouse.controller.statistics;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.com.warehouse.entity.statistics.ShopStatisticsEntity;
import cn.com.warehouse.entity.statistics.WorkerStatisticsEntity;
import cn.com.warehouse.service.statistics.StatisticsService;
import cn.com.warehouse.util.Paging;

/**
 * @author 统计控制层
 *
 */
@Controller
public class StatisticsController {

	@Resource
	private StatisticsService statisticsService;

	/**
	 * 跳转到店铺统计页面
	 * 
	 * @return String
	 */
	@RequestMapping(value = "/shopStatisticsList", method = RequestMethod.GET)
	public String shopStatisticsList(Model model, Paging<ShopStatisticsEntity> page, Integer type) {
	
		model.addAttribute("page", statisticsService.getShopStatisticsList(page, type));
		return "statistics/statistics_shop";
	}
	
	/**
	 * 跳转到人员统计页面
	 * 
	 * @return String
	 */
	@RequestMapping(value = "/workerStatisticsList", method = RequestMethod.GET)
	public String workerStatisticsList(Model model, Paging<WorkerStatisticsEntity> page, Integer type) {
		model.addAttribute("page", statisticsService.getWorkerStatisticsList(page, type));
		return "statistics/statistics_worker";
	}

}
