/**
 *OrderItemDao.java
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

import org.enilu.core.dao.IBaseDao;
import org.enilu.core.datasource.DataBaseUtil;
import org.enilu.core.util.Pager;
import org.enilu.shop.entity.OrderItem;

/**
 * 订单明细<br>
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
public class OrderItemDao implements IBaseDao {
	DataBaseUtil ds = DataBaseUtil.getInstance();
	Connection conn = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	public OrderItemDao() {
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
	public Object findById(Long pk) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.enilu.core.dao.IBaseDao#queryAll()
	 */
	@Override
	public List<Object> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.enilu.core.dao.IBaseDao#findPage(org.enilu.core.util.Pager)
	 */
	@Override
	public Pager findPage(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.enilu.core.dao.IBaseDao#getCount()
	 */
	@Override
	public Integer getCount() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.enilu.core.dao.IBaseDao#queryBySql(java.lang.String)
	 */
	@Override
	public List<Object> queryBySql(String sql) {
		List list = new ArrayList<OrderItem>();
		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				OrderItem entity = new OrderItem();
				entity.setId(rs.getLong("id"));
				entity.setAmount(rs.getInt("amount"));
				entity.setOrderId(rs.getString("order_id"));
				entity.setPrice(rs.getBigDecimal("price"));
				entity.setProductId(rs.getLong("product_id"));
				entity.setProductName(rs.getString("product_name"));
				list.add(entity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ds.close(rs, st);
		}
		return list;
	}

	/**
	 * 根据订单编号查询订单明细
	 * 
	 * @param orderId
	 * @return
	 */
	public List queryByOrderId(String orderId) {
		return queryBySql("select * from tb_order_item where order_id='"
				+ orderId + "'");
	}

}
