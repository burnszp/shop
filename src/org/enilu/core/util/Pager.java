/**
 *Pager.java
 *Version1.0
 *2015-1-1
 *Copyright cnendata.com
 *
 */
package org.enilu.core.util;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * 分页对象<br>
 * <!--<br>
 * 历史记录：<br>
 * --------------------------------------------------------
 * 2015-1-1,enilu(82552623@qq.com)新建文档<br>
 * 
 * -->
 * 
 * @author enilu(82552623@qq.com)
 * 
 *         since1.0
 */
public class Pager<T> {
	List<T> list = new ArrayList<T>();
	/**
	 * 每页显示记录数
	 */
	private Integer pageSize = 10;
	/**
	 * 当前页码
	 */
	private Integer pageNumber = 1;
	/**
	 * 总页数
	 */
	private Integer pageCount;

	/**
	 * 总记录数
	 */
	private Integer recordCount;

	public Pager(HttpServletRequest req) {
		String pageSizeStr = req.getParameter("ps");
		String pageNumStr = req.getParameter("pn");
		if (pageSizeStr != null) {
			this.pageSize = Integer.valueOf(pageSizeStr.trim());
		}
		if (pageNumStr != null) {
			this.pageNumber = Integer.valueOf(pageNumStr.trim());
		}
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Integer getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(Integer recordCount) {
		this.recordCount = recordCount;
		double tmp = Double.valueOf(this.recordCount + "")
				/ Double.valueOf(this.pageSize + "");
		this.pageCount = ((int) Math.ceil(tmp));
	}

	public void setTotalPages(Integer totalPages) {
		this.pageCount = totalPages;
	}

}
