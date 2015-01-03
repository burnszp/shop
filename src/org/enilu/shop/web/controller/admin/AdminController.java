/**
 *IndexController.java
 *Version1.0
 *2015-1-1
 *Copyright cnendata.com
 *
 */
package org.enilu.shop.web.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.enilu.shop.dao.UserDao;
import org.enilu.shop.entity.User;

/**
 * 后台管理首页<br>
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
@WebServlet("/admin")
public class AdminController extends HttpServlet {
	private UserDao userDao = new UserDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String method = req.getParameter("method");
		if ("login".equals(method)) {
			this.login(req, resp);
		} else if ("logout".equals(method)) {

			this.logout(req, resp);
		} else {
			// 如果管理员没有登录不能操作系统管理模块
			if (req.getSession().getAttribute("admin") == null) {
				req.getRequestDispatcher("/page/admin/login.jsp").forward(req,
						resp);
			} else {
				req.getRequestDispatcher("/page/admin/admin.jsp").forward(req,
						resp);
			}
		}
	}

	protected void login(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		User admin = userDao.login(username, password);
		if (admin != null) {
			req.getSession().setAttribute("admin", admin);
			// 移除session的当前顾客信息，一个人不能作为顾客和管理员同时登录系统
			req.getSession().removeAttribute("user");
			resp.sendRedirect("admin");
		} else {
			req.setAttribute("msg", "用户名或密码错误");
			req.getRequestDispatcher("/page/admin/login.jsp")
					.forward(req, resp);
		}
	}

	protected void logout(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.getSession().removeAttribute("admin");
		resp.sendRedirect("index");
	}

}
