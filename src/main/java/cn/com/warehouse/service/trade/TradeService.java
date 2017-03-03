package cn.com.warehouse.service.trade;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.warehouse.dao.trade.TradeDao;
import cn.com.warehouse.entity.trade.TradeEntity;
import cn.com.warehouse.util.Paging;

/**
 * @author 交易事务管理
 *
 */
@Service
public class TradeService {

	@Resource
	private TradeDao tradeDao;

	/**
	 * 分页查询交易列表
	 * 
	 * @return Page
	 */
	public Paging<TradeEntity> getTradeByShopId(Paging<TradeEntity> page, long shopId) {
		page.setList(tradeDao.getTradeByShopId(page, shopId));
		int count = tradeDao.getTradeListCountByShopId(shopId);
		page.setTotalRow(count);
		page.setTotalPage((count + page.getNumPerPage() - 1) / page.getNumPerPage());
		return page;
	}

	/**
	 * 新增发货交易
	 * 
	 */
	public void send(TradeEntity trade) {
		tradeDao.send(trade);
	}

	/**
	 * 新增收款交易
	 * 
	 */
	public void receive(TradeEntity trade) {
		tradeDao.receive(trade);
	}

	/**
	 * 新增入库交易
	 * 
	 */
	public void warehousing(long goodsId, int amount) {
		tradeDao.warehousing(goodsId, amount);
	}

}
