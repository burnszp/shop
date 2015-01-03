/**
 *AbstractController.java
 *Version1.0
 *2015-1-2
 *Copyright cnendata.com
 *
 */
package org.enilu.core.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * descript<br>
 * <!--<br>
 * 历史记录：<br>
 * --------------------------------------------------------
 * 2015-1-2,enilu(82552623@qq.com)新建文档<br>
 * 
 * -->
 * 
 * @author enilu(82552623@qq.com)
 * 
 *         since1.0
 */
public abstract class AbstractController extends HttpServlet {
	public abstract void view(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException;

	protected abstract void del(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException;

	protected abstract void add(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException;

	protected abstract void save(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException;
}
