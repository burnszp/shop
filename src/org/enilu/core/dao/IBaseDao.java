/**
 *IBaseDao.java
 *Version1.0
 *2015-1-1
 *Copyright cnendata.com
 *
 */
package org.enilu.core.dao;

import java.util.List;

import org.enilu.core.util.Pager;

/**
 * descript<br>
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
public interface IBaseDao {

	/**
	 * 保存实体
	 * 
	 * @param entity
	 */
	public void save(Object entity);

	/**
	 * 根据主键删除实体
	 * 
	 * @param pk
	 */
	public void delete(Long pk);

	/**
	 * 根据实体删除之
	 * 
	 * @param entity
	 */
	public void delete(Long[] ids);

	/**
	 * 根据主键查找一个实体
	 * 
	 * @param pk
	 *            主键
	 * @return
	 */
	public Object findById(Long pk);

	/**
	 * 返回某个实体对应表的全部数据
	 * 
	 * @return
	 */
	public List<Object> queryAll();

	/**
	 * 查询数据，返回分页对象
	 * 
	 * @return
	 */
	public Pager findPage(Pager pager);

	/**
	 * 获取总记录数
	 * 
	 * @return
	 */
	public Integer getCount();

	/**
	 * 根据sql语句返回数据集合
	 * 
	 * @param sql
	 * @return
	 */
	public List<Object> queryBySql(String sql);

}
