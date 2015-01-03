/**
 *Cond.java
 *Version1.0
 *2015-1-3
 *Copyright cnendata.com
 *
 */
package org.enilu.core.dao;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据库查询条件工具类<br>
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
public class Cond {
	private static List conds = new ArrayList();

	public Cond() {
		conds = new ArrayList();

	}

	public void where(String key, Object value) {
		this.where(key, "=", value);
	}

	public void where(String key, String symbol, Object value) {
		String type = value.getClass().toString().toLowerCase();
		Object[] item = new Object[3];
		item[0] = key;
		item[1] = symbol;
		if (type.contains("int") || type.contains("short")
				|| type.contains("double") || type.contains("decimal")
				|| type.contains("long")) {

			item[2] = value;
		} else if (type.contains("string")) {
			item[2] = "'" + value + "'";
		}
		conds.add(item);
	}

	public String toSql() {
		StringBuilder builder = new StringBuilder(" where 0=0 ");
		if (conds != null && conds.size() > 0) {
			for (int i = 0; i < conds.size(); i++) {
				Object[] item = (Object[]) conds.get(i);
				builder.append(" and ").append(item[0]).append(" ")
						.append(item[1]).append(" ").append(item[2]);
			}
		}
		return builder.toString();
	}

}
