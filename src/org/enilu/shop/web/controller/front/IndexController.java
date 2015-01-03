/**
 *IndexController.java
 *Version1.0
 *2015-1-1
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

import org.enilu.core.util.Pager;
import org.enilu.shop.dao.ProductDao;

/**
 * 首页控制器<br>
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
@WebServlet("/index")
public class IndexController extends HttpServlet {
	private ProductDao productDao = new ProductDao();;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Pager pager = new Pager(req);
		pager.setPageSize(8);
		pager = productDao.findOnPage(pager);
		req.setAttribute("pager", pager);
		req.getRequestDispatcher("page/front/index.jsp").forward(req, resp);
	}

}
