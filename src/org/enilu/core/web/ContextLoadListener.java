package org.enilu.core.web;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.enilu.core.datasource.DataBaseUtil;

/**
 * 启动监听器，进行其他的初始化工作<br>
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
@WebListener
public class ContextLoadListener implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public ContextLoadListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent event) {
		// 初始化数据源
		String appPath = event.getServletContext().getRealPath(
				"/WEB-INF/classes/application.properties");
		if (!"".equals(appPath)) {
			try {
				Properties prop = new Properties();
				prop.load(new FileInputStream(appPath));
				DataBaseUtil.getInstance().init(prop);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}

}
