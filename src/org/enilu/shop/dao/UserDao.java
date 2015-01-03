/**
 *UserDao.java
 *Version1.0
 *2015-1-1
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
import org.enilu.shop.entity.User;

/**
 * 用户dao<br>
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
public class UserDao implements IBaseDao {
	DataBaseUtil ds = DataBaseUtil.getInstance();
	Connection conn = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	public UserDao() {
		conn = ds.getConn();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.enilu.core.dao.IBaseDao#save(java.lang.Object)
	 */
	@Override
	public void save(Object entity) {
		User user = (User) entity;
		String sql = "";
		if (user.getId() == null) {
			sql = "insert into tb_user(username,password,usertype) values(?,?,?)";
		} else {
			sql = "update tb_user set username=?,password=?,usertype=? where id=?";

		}
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, user.getUsername());
			st.setString(2, user.getPassword());
			st.setInt(3, user.getUsertype());
			if (user.getId() != null) {
				st.setLong(4, user.getId());
			}
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ds.close(null, st);
		}
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
	 * @see org.enilu.core.dao.IBaseDao#delete(java.lang.Object)
	 */
	@Override
	public void delete(Long[] ids) {

		try {
			for (int i = 0; i < ids.length; i++) {
				st = conn.prepareStatement("delete from tb_user where id=?");
				st.setLong(1, ids[i]);
				st.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ds.close(null, st);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.enilu.core.dao.IBaseDao#findById(java.lang.Long)
	 */
	@Override
	public User findById(Long id) {
		List list = this.queryBySql("select * from tb_user where id=" + id);
		if (list != null && list.size() > 0) {
			User entity = (User) list.get(0);
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
		return queryBySql("select * from tb_product");
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

		List data = queryBySql("select * from tb_user limit " + start + ","
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
			st = conn.prepareStatement("select count(*) cc from tb_user");
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
	public List queryBySql(String sql) {
		List list = new ArrayList<User>();
		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				User entity = new User();
				entity.setId(rs.getLong("id"));
				entity.setUsername(rs.getString("username"));
				entity.setPassword(rs.getString("password"));
				entity.setUsertype(rs.getShort("usertype"));
				list.add(entity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ds.close(rs, st);
		}
		return list;
	}

	public User login(String username, String password) {
		List list = queryBySql("select * from tb_user where username='"
				+ username + "' and password ='" + password + "'");
		if (list != null && list.size() > 0) {
			User entity = (User) list.get(0);
			return entity;
		}
		return null;
	}

}
