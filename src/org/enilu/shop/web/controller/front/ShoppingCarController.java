/**
 *ShoppingCarController.java
 *Version1.0
 *2015-1-3
 *Copyright cnendata.com
 *
 */
package org.enilu.shop.web.controller.front;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.enilu.core.web.AbstractController;
import org.enilu.shop.dao.ProductDao;
import org.enilu.shop.entity.Customer;
import org.enilu.shop.entity.OrderItem;
import org.enilu.shop.entity.Product;

/**
 * 购物车控制器<br>
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
@WebServlet("/shoppingcar")
public class ShoppingCarController extends AbstractController {
	private static final String SHOPPINGCAR = "shoppingcar";
	private ProductDao productDao = new ProductDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		if (req.getSession().getAttribute("user") == null) {

			req.getRequestDispatcher("/page/front/login.jsp")
					.forward(req, resp);
			return;

		}
		Customer customer = (Customer) req.getSession().getAttribute("user");
		String method = req.getParameter("method");
		if ("add".equals(method)) {
			this.addCar(req, resp);
		} else {
			Object obj = req.getSession().getAttribute(SHOPPINGCAR);
			if (obj != null) {
				List list = (List) obj;
				req.setAttribute("items", list);
			}
			req.getRequestDispatcher("/page/front/shoppingcar.jsp").forward(
					req, resp);
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

	/**
	 * 将商品添加到购物车
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void addCar(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Object obj = req.getSession().getAttribute(SHOPPINGCAR);
		List<OrderItem> list = new ArrayList<OrderItem>();
		if (obj != null) {
			list = (List<OrderItem>) obj;
		}
		Long productId = Long.valueOf(req.getParameter("productId"));
		Product pro = productDao.findById(productId);
		OrderItem item = new OrderItem();
		item.setAmount(Integer.valueOf(req.getParameter("amount")));
		item.setPrice(pro.getPrice());
		item.setProductId(productId);
		item.setProductName(pro.getPname());
		list.add(item);
		resp.sendRedirect("/product?id=" + productId);
	}
}
