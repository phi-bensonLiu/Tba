package service;

import java.util.ArrayList;
import java.util.List;

public class Page {

	int firstRownum = 0; // 起始筆數
	int lastRownum = 0; // 結束筆數
	int pageSize = 5; // 每頁筆數
	int currentPage = 1; // 當前頁數
	int totalCount = 0; // 總筆數
	int totalPage = 0; // 總頁數

	public Page(int tCount, int cPage) {
		setPage(tCount, cPage);
	}

	public Page(int tCount, int cPage, int pSize) {
		setPage(tCount, cPage, pSize);
	}

	public void setPage(int tCount, int cPage) {
		totalCount = tCount;
		currentPage = cPage;
		totalPage = tCount % pageSize == 0 ? tCount / pageSize
				: (tCount / pageSize) + 1;
		
		if (totalPage == cPage) {
			firstRownum = ((currentPage - 1) * pageSize) + 1;
			lastRownum = tCount;			
		} else {
			if (cPage > totalPage) {
				currentPage = totalPage;
			}
			firstRownum = ((currentPage - 1) * pageSize) + 1;
			lastRownum = (currentPage * pageSize) -1 ;			
		}
	}

	public void setPage(int tCount, int cPage, int pSize) {
		totalCount = tCount;
		currentPage = cPage;
		pageSize = pSize;
		totalPage = tCount % pageSize == 0 ? tCount / pageSize
				: (tCount / pageSize) + 1;
		if (totalPage == cPage) {
			firstRownum = ((currentPage - 1) * pageSize) + 1;
			lastRownum = tCount;			
		} else {
			if (cPage > totalPage) {
				currentPage = totalPage;
			}
			firstRownum = ((currentPage - 1) * pageSize) + 1;
			lastRownum = (currentPage * pageSize) -1;			
		}		
	}

	public int getFirstRownum() {
		return firstRownum;
	}

	public void setFirstRownum(int firstRownum) {
		this.firstRownum = firstRownum;
	}

	public int getLastRownum() {
		return lastRownum;
	}

	public void setLastRownum(int lastRownum) {
		this.lastRownum = lastRownum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * for DB first query
	 * @return int
	 */
	public int getQueryFirstRownum() {
		return getFirstRownum()-1;
	}

	// pre page
	public int getPrePage() {
		int pre = currentPage;
		if (currentPage != 1) {
			pre -= 1;
		}
		return pre;
	}

	// next page
	public int getNextPage() {
		int next = currentPage;
		if (totalPage != next) {
			next += 1;
		}
		return next;
	}

	// show pre page
	// show first page
	public boolean getShowPrePage() {
		if (currentPage == 1) {
			return false;
		}
		return true;
	}

	// show next page
	// show last page
	public boolean getShowNextPage() {
		if (currentPage == totalPage) {
			return false;
		}
		return true;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List getPageSizeList() {
		List pageList = new ArrayList<Integer>();
		for (int i = 5; i < 55; i += 5) {
			pageList.add(i);
		}
		return pageList;
	}

	// 頁數列表
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List getPageList() {
		List pageList = new ArrayList<Integer>();
		int startPage = (currentPage - 5) < 1 ? 1 : (currentPage - 5);
		int endPage = (startPage + 9) > totalPage ? totalPage : (startPage + 9);
		System.out.println("===>>> startPage=" + startPage);
		System.out.println("===>>> endPage=" + endPage);
		if (startPage == endPage) {
			pageList.add(startPage);
		} else {
			for (int i = startPage; i < endPage + 1; i++) {
				pageList.add(i);
			}
		}
		return pageList;
	}

	@Override
	public String toString() {
		return "Page [firstRownum=" + firstRownum + ", lastRownum="
				+ lastRownum + ", pageSize=" + pageSize + ", currentPage="
				+ currentPage + ", totalCount=" + totalCount + ", totalPage="
				+ totalPage + "]";
	}

}
