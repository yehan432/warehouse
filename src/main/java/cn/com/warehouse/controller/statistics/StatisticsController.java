package cn.com.warehouse.controller.statistics;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.com.warehouse.entity.statistics.StatisticsEntity;
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
	 * 跳转到统计页面
	 * 
	 * @return String
	 */
	@RequestMapping(value = "/statisticsList", method = RequestMethod.GET)
	public String shopList(Model model, Paging<StatisticsEntity> page) {
		model.addAttribute("page", statisticsService.getStatisticsList(page));
		return "statistics/statistics_list";
	}

}
