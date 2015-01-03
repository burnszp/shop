/**
 *OrderInfoDao.java
 *Version1.0
 *2015-1-3
 *Copyright cnendata.com
 *
 */
package org.enilu.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.enilu.core.dao.Cond;
import org.enilu.core.dao.IBaseDao;
import org.enilu.core.datasource.DataBaseUtil;
import org.enilu.core.util.Pager;
import org.enilu.shop.entity.OrderInfo;

/**
 * 订单dao<br>
 * <!--<br>
 * 历史记录：<br>
 * --------------------------------------------------------
 * 2015-1-3,enilu(82552623@qq.com)新建文档<br>
 * 
 * -->
 * 
 * @author enilu(82552623@qq.com)
 * 
 *         since1.0
 */
public class OrderInfoDao implements IBaseDao {
	DataBaseUtil ds = DataBaseUtil.getInstance();
	Connection conn = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	public OrderInfoDao() {
		conn = ds.getConn();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.enilu.core.dao.IBaseDao#save(java.lang.Object)
	 */
	@Override
	public void save(Object entity) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.enilu.core.dao.IBaseDao#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long pk) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.enilu.core.dao.IBaseDao#delete(java.lang.Long[])
	 */
	@Override
	public void delete(Long[] ids) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.enilu.core.dao.IBaseDao#findById(java.lang.Long)
	 */
	@Override
	public OrderInfo findById(Long id) {
		List list = this.queryBySql("select * from tb_order where id=" + id);
		if (list != null && list.size() > 0) {
			OrderInfo entity = (OrderInfo) list.get(0);
			return entity;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.enilu.core.dao.IBaseDao#queryAll()
	 */
	@Override
	public List<Object> queryAll() {
		return queryBySql("select * from tb_order");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.enilu.core.dao.IBaseDao#findPage(org.enilu.core.util.Pager)
	 */
	@Override
	public Pager findPage(Pager pager) {
		int count = getCount();
		int start = (pager.getPageNumber() - 1) * pager.getPageSize();

		List data = queryBySql("select * from tb_order limit " + start + ","
				+ pager.getPageSize());
		pager.setList(data);
		pager.setRecordCount(count);
		return pager;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.enilu.core.dao.IBaseDao#getCount()
	 */
	@Override
	public Integer getCount() {
		try {
			st = conn.prepareStatement("select count(*) cc from tb_order");
			rs = st.executeQuery();
			if (rs.next()) {
				return Integer.valueOf(rs.getInt("cc"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ds.close(rs, st);
		}
		return -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.enilu.core.dao.IBaseDao#queryBySql(java.lang.String)
	 */
	@Override
	public List<Object> queryBySql(String sql) {
		List list = new ArrayList<OrderInfo>();
		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				OrderInfo entity = new OrderInfo();
				entity.setId(rs.getLong("id"));
				entity.setCustomerId(rs.getLong("customer_id"));
				entity.setAdminId(rs.getLong("admin_id"));
				entity.setCreateDate(rs.getDate("create_date"));
				entity.setOstatus(rs.getShort("ostatus"));
				entity.setScore(rs.getBigDecimal("score"));
				entity.setTotalPrice(rs.getBigDecimal("total_price"));
				entity.setOrderId(rs.getString("order_id"));
				list.add(entity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ds.close(rs, st);
		}
		return list;
	}

	public Pager findPage(Pager pager, Cond cnd) {
		int count = getCount(cnd);
		int start = (pager.getPageNumber() - 1) * pager.getPageSize();

		List data = queryBySql("select * from tb_order " + cnd.toSql()
				+ " limit " + start + "," + pager.getPageSize());
		pager.setList(data);
		pager.setRecordCount(count);
		return pager;
	}

	private int getCount(Cond cnd) {
		try {
			st = conn.prepareStatement("select count(*) cc from tb_order"
					+ cnd.toSql());
			rs = st.executeQuery();
			if (rs.next()) {
				return Integer.valueOf(rs.getInt("cc"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ds.close(rs, st);
		}
		return -1;
	}

	/**
	 * 处理订单，将订单状态更改为已处理
	 * 
	 * @param id
	 */
	public void handle(Long id, Long admin) {
		try {
			st = conn
					.prepareStatement("update tb_order set ostatus=2,admin_id=? where id=?");
			st.setLong(1, admin);
			st.setLong(2, id);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ds.close(null, st);
		}

	}

}
