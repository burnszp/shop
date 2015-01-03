/**
 *ProductDao.java
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
import org.enilu.shop.entity.Product;

/**
 * 商品dao<br>
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
public class ProductDao implements IBaseDao {
	DataBaseUtil ds = DataBaseUtil.getInstance();
	Connection conn = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	public ProductDao() {
		conn = ds.getConn();
	}

	@Override
	public void delete(Long pk) {
		// TODO Auto-generated method stub

	}

	@Override
	public Product findById(Long id) {
		List list = this.queryBySql("select * from tb_product where id=" + id);
		if (list != null && list.size() > 0) {
			Product entity = (Product) list.get(0);
			return entity;
		}
		return null;
	}

	@Override
	public List queryAll() {
		return queryBySql("select * from tb_product");
	}

	@Override
	public void save(Object entity) {
		Product pro = (Product) entity;
		String sql = "";
		if (pro.getId() == null) {
			sql = "insert into tb_product(pname,descript,stock,price,pstatus,img,`update`) values(?,?,?,?,?,?,now())";
		} else {
			sql = "update tb_product set pname=?,descript=?,stock=?,price=?,pstatus=?,img=? where id="
					+ pro.getId();
		}
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, pro.getPname());
			st.setString(2, pro.getDescript());
			st.setInt(3, pro.getStock());
			st.setBigDecimal(4, pro.getPrice());
			st.setShort(5, pro.getPstatus());
			st.setString(6, pro.getImg());
			st.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ds.close(null, st);
		}
	}

	/**
	 * 下架商品
	 * 
	 * @param ids
	 *            商品id集合
	 */
	@Override
	public void delete(Long[] ids) {

		try {
			for (int i = 0; i < ids.length; i++) {
				st = conn
						.prepareStatement("update tb_product set pstatus=2 where id="
								+ ids[i]);
				st.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ds.close(null, st);
		}

	}

	@Override
	public Pager findPage(Pager pager) {
		int count = getCount();
		int start = (pager.getPageNumber() - 1) * pager.getPageSize();

		List data = queryBySql("select * from tb_product limit " + start + ","
				+ pager.getPageSize());
		pager.setList(data);
		pager.setRecordCount(count);
		return pager;
	}

	@Override
	public Integer getCount() {
		try {
			st = conn.prepareStatement("select count(*) cc from tb_product");
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

	@Override
	public List queryBySql(String sql) {
		List list = new ArrayList<Product>();
		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				Product entity = new Product();
				entity.setId(rs.getLong("id"));
				entity.setDescript(rs.getString("descript"));
				entity.setImg(rs.getString("img"));
				entity.setPname(rs.getString("pname"));
				entity.setStock(rs.getInt("stock"));
				entity.setUpdate(rs.getDate("update"));
				entity.setPrice(rs.getBigDecimal("price"));
				entity.setPstatus(rs.getShort("pstatus"));
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
	 * 将指定id的商品重新上架
	 * 
	 * @param ids
	 *            商品id集合
	 */
	public void upload(Long[] ids) {

		try {
			for (int i = 0; i < ids.length; i++) {
				st = conn
						.prepareStatement("update tb_product set pstatus=1 where id="
								+ ids[i]);
				st.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ds.close(null, st);
		}
	}

	/**
	 * 分页查询所有上架商品
	 * 
	 * @param pager
	 * @return
	 */
	public Pager findOnPage(Pager pager) {
		int count = getOnCount();
		int start = (pager.getPageNumber() - 1) * pager.getPageSize();

		List data = queryBySql("select * from tb_product where pstatus=1 limit "
				+ start + "," + pager.getPageSize());
		pager.setList(data);
		pager.setRecordCount(count);
		return pager;
	}

	/**
	 * 查询上架商品记录数
	 * 
	 * @return
	 */
	public Integer getOnCount() {
		try {
			st = conn
					.prepareStatement("select count(*) cc from tb_product where pstatus=1");
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
}
