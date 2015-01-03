/**
 *OrderController.java
 *Version1.0
 *2015-1-2
 *Copyright cnendata.com
 *
 */
package org.enilu.shop.web.controller.front;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.enilu.core.dao.Cond;
import org.enilu.core.util.Pager;
import org.enilu.core.web.AbstractController;
import org.enilu.shop.dao.OrderInfoDao;
import org.enilu.shop.dao.OrderItemDao;
import org.enilu.shop.entity.Customer;

/**
 * 个人订单管理控制器<br>
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
@WebServlet("/order")
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
		Customer customer = null;
		if (req.getSession().getAttribute("user") == null) {

			req.getRequestDispatcher("/page/front/login.jsp")
					.forward(req, resp);
			return;
		}
		customer = (Customer) req.getSession().getAttribute("user");

		String method = req.getParameter("method");
		if ("buy".equals(method)) {
			this.buy(req, resp);
		} else {

			Pager pager = new Pager(req);
			pager.setPageSize(10);
			String ostatus = req.getParameter("ostatus");
			Cond cnd = new Cond();
			if (ostatus != null && !"".equals(ostatus)) {
				cnd.where("ostatus", Short.valueOf(ostatus));
			}
			cnd.where("customer_id", customer.getId());
			pager = orderDao.findPage(pager, cnd);
			req.setAttribute("pager", pager);
			req.getRequestDispatcher("/page/front/order.jsp")
					.forward(req, resp);

		}
	}

	/**
	 * 购买商品
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void buy(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

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
		// TODO Auto-generated method stub

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

}
