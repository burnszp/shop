/**
 *DataBaseUtil.java
 *Version1.0
 *2015-1-1
 *Copyright cnendata.com
 *
 */
package org.enilu.core.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 数据库连接工具类<br>
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
public class DataBaseUtil {
	private static DataBaseUtil instance;
	private String jdbcUrl = "";
	private String username = "";
	private String password = "";
	private String driver = "";

	private DataBaseUtil() {

	}

	/**
	 * 使用资源文件初始化数据库连接
	 * 
	 * @param prop
	 * @return
	 */
	public boolean init(Properties prop) {
		if (prop == null) {
			return false;
		}
		jdbcUrl = prop.getProperty("jdbcUrl");
		username = prop.getProperty("username");
		password = prop.getProperty("password");
		driver = prop.getProperty("driver");
		Connection conn = getConn();
		if (conn != null) {
			close(conn);
			System.out.println("数据源配置正确");
			return true;
		}
		System.out.println("数据源配置错误");
		return false;
	}

	public static DataBaseUtil getInstance() {
		if (instance == null) {
			instance = new DataBaseUtil();
		}
		return instance;
	}

	/**
	 * 获取数据库连接
	 * 
	 * @return
	 */
	public Connection getConn() {

		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(jdbcUrl, username,
					password);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 关闭connection
	 * 
	 * @param conn
	 */
	public void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 关闭数据库连接相关资源
	 * 
	 * @param rs
	 * @param st
	 * @param conn
	 */
	public void close(ResultSet rs, Statement st) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
