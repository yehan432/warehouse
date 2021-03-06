package cn.com.warehouse.service.statistics;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.warehouse.dao.statistics.StatisticsDao;
import cn.com.warehouse.entity.statistics.ShopStatisticsEntity;
import cn.com.warehouse.entity.statistics.WorkerStatisticsEntity;
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
	public Paging<ShopStatisticsEntity> getShopStatisticsList(Paging<ShopStatisticsEntity> page, Integer type, String startTime, String endTime) {
		page.setList(statisticsDao.getShopStatisticsList(page, type, startTime, endTime));
		int count = statisticsDao.getShopStatisticsListCount(type, startTime, endTime);
		page.setTotalRow(count);
		page.setTotalPage((count + page.getNumPerPage() - 1) / page.getNumPerPage());
		return page;
	}

	/**
	 * 分页查询人员统计列表
	 * 
	 * @return Page
	 */
	public Paging<WorkerStatisticsEntity> getWorkerStatisticsList(Paging<WorkerStatisticsEntity> page, Integer type, String startTime, String endTime) {
		page.setList(statisticsDao.getWorkerStatisticsList(page, type, startTime, endTime));
		int count = statisticsDao.getWorkerStatisticsListCount(type, startTime, endTime);
		page.setTotalRow(count);
		page.setTotalPage((count + page.getNumPerPage() - 1) / page.getNumPerPage());
		return page;
	}

}
