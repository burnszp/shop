/**
 *OrderController.java
 *Version1.0
 *2015-1-3
 *Copyright cnendata.com
 *
 */
package org.enilu.shop.web.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.enilu.core.dao.Cond;
import org.enilu.core.util.Pager;
import org.enilu.core.web.AbstractController;
import org.enilu.shop.dao.OrderInfoDao;
import org.enilu.shop.dao.OrderItemDao;
import org.enilu.shop.entity.OrderInfo;
import org.enilu.shop.entity.User;

/**
 * 订单管理控制器<br>
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
@WebServlet("/admin/order")
public class OrderController extends AbstractController {
	private OrderInfoDao orderDao = new OrderInfoDao();
	private OrderItemDao itemDao = new OrderItemDao();

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
		} else if ("handle".equals(method)) {
			this.handle(req, resp);

		} else if ("print".equals(method)) {

			this.print(req, resp);
		} else {
			Pager pager = new Pager(req);
			pager.setPageSize(10);
			String ostatus = req.getParameter("ostatus");
			if (ostatus != null && !"".equals(ostatus)) {
				Cond cnd = new Cond();
				cnd.where("ostatus", Short.valueOf(ostatus));
				pager = orderDao.findPage(pager, cnd);
			} else {
				pager = orderDao.findPage(pager);
			}
			req.setAttribute("pager", pager);
			req.getRequestDispatcher("/page/admin/order.jsp")
					.forward(req, resp);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.enilu.core.web.AbstractController#view(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void view(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Long id = Long.valueOf(req.getParameter("id"));
		OrderInfo entity = (OrderInfo) orderDao.findById(id);
		List items = itemDao.queryByOrderId(entity.getOrderId());
		req.setAttribute("obj", entity);
		req.setAttribute("items", items);
		req.getRequestDispatcher("/page/admin/orderForm.jsp")
				.forward(req, resp);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.enilu.core.web.AbstractController#del(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void del(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.enilu.core.web.AbstractController#add(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void add(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.enilu.core.web.AbstractController#save(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void save(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * 处理订单
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void handle(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		User admin = (User) req.getSession().getAttribute("admin");
		if (admin.getUsertype().intValue() == User.USERTYPE_ADMIN) {
			req.setAttribute("msg", "您不是收款员，请登录收款员账号");
			req.getRequestDispatcher("/page/admin/login.jsp")
					.forward(req, resp);
			return;

		}
		Long id = Long.valueOf(req.getParameter("id"));
		orderDao.handle(id, admin.getId());
		resp.sendRedirect("order?method=view&id=" + id);

	}

	/**
	 * 打印预览
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void print(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		Long id = Long.valueOf(req.getParameter("id"));
		OrderInfo entity = (OrderInfo) orderDao.findById(id);
		List items = itemDao.queryByOrderId(entity.getOrderId());
		req.setAttribute("obj", entity);
		req.setAttribute("items", items);
		req.getRequestDispatcher("/page/admin/orderPrint.jsp").forward(req,
				resp);

	}
}
