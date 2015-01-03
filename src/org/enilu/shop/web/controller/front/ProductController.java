/**
 *ProductViewController.java
 *Version1.0
 *2015-1-2
 *Copyright cnendata.com
 *
 */
package org.enilu.shop.web.controller.front;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.enilu.shop.dao.ProductDao;
import org.enilu.shop.entity.Product;

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
@WebServlet("/product")
public class ProductController extends HttpServlet {
	private ProductDao productDao = new ProductDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		Long id = Long.valueOf(req.getParameter("id"));
		Product entity = productDao.findById(id);
		req.setAttribute("obj", entity);
		req.getRequestDispatcher("/page/front/productView.jsp").forward(req,
				resp);

	}

}
