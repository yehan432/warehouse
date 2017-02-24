package cn.com.warehouse.util;

import java.util.List;

/**
 * 
 * @author 分页类
 *
 */
@SuppressWarnings("unused")
public class Paging<T> {

	public static final int NUMBERS_PER_PAGE = 10;

	// 一页显示的记录数
	private int numPerPage = NUMBERS_PER_PAGE;
	// 记录总数
	private int totalRow;
	// 总页数
	private int totalPage;
	// 当前页码
	private int currentPage = 1;
	// 起始行数
	private int startRow;
	// 结束行数
	private int endRow;
	// 结果集存放List
	private List<T> list;

	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}

	public int getTotalRow() {
		return totalRow;
	}

	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getStartRow() {
		return numPerPage * (this.currentPage - 1) + 1;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return numPerPage * (this.currentPage - 1) + numPerPage;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
