/**
 *UserContoller.java
 *Version1.0
 *2015-1-1
 *Copyright cnendata.com
 *
 */
package org.enilu.shop.web.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.enilu.core.util.Pager;
import org.enilu.core.web.AbstractController;
import org.enilu.shop.dao.UserDao;
import org.enilu.shop.entity.User;

/**
 * 用户控制器<br>
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
@WebServlet("/admin/user")
public class UserContoller extends AbstractController {
	private UserDao userDao = new UserDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if (req.getSession().getAttribute("admin") == null) {
			req.getRequestDispatcher("/page/admin/login.jsp")
					.forward(req, resp);
		}
		String method = req.getParameter("method");
		if ("view".equals(method)) {
			this.view(req, resp);
		} else if ("del".equals(method)) {
			this.del(req, resp);
		} else if ("add".equals(method)) {
			this.add(req, resp);
		} else if ("save".equals(method)) {
			this.save(req, resp);
		} else {
			Pager pager = new Pager(req);
			pager.setPageSize(10);
			pager = userDao.findPage(pager);
			req.setAttribute("pager", pager);
			req.getRequestDispatcher("/page/admin/user.jsp").forward(req, resp);
		}
	}

	@Override
	public void view(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Long id = Long.valueOf(req.getParameter("id"));
		User entity = (User) userDao.findById(id);
		req.setAttribute("obj", entity);
		req.getRequestDispatcher("/page/admin/userForm.jsp").forward(req, resp);

	}

	@Override
	protected void del(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String idsStr = req.getParameter("ids");
		String[] ids = idsStr.split(",");
		Long[] ids2 = new Long[ids.length];
		for (int i = 0; i < ids2.length; i++) {
			ids2[i] = Long.valueOf(ids[i]);
		}
		userDao.delete(ids2);

		resp.sendRedirect("../admin/user");

	}

	@Override
	protected void add(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/page/admin/userForm.jsp").forward(req, resp);

	}

	@Override
	protected void save(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String idStr = req.getParameter("id");
		User entity = null;
		if (idStr != null && !"".equals(idStr.trim())) {
			entity = userDao.findById(Long.valueOf(idStr));
		} else {
			entity = new User();
		}

		entity.setPassword(req.getParameter("password"));
		entity.setUsername(req.getParameter("username"));
		entity.setUsertype(Short.valueOf(req.getParameter("usertype")));
		userDao.save(entity);
		resp.sendRedirect("../admin/user");
	}

}
