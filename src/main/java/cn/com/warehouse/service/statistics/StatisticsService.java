package cn.com.warehouse.service.statistics;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.warehouse.dao.statistics.StatisticsDao;
import cn.com.warehouse.entity.statistics.StatisticsEntity;
import cn.com.warehouse.util.Paging;

/**
 * @author 店铺事务管理
 *
 */
@Service
public class StatisticsService {

	@Resource
	private StatisticsDao statisticsDao;

	/**
	 * 分页查询店铺统计列表
	 * 
	 * @return Page
	 */
	public Paging<StatisticsEntity> getStatisticsList(Paging<StatisticsEntity> page) {
		page.setList(statisticsDao.getStatisticsList(page));
		int count = statisticsDao.getStatisticsListCount();
		page.setTotalRow(count);
		page.setTotalPage((count + page.getNumPerPage() - 1) / page.getNumPerPage());
		return page;
	}
	
}
