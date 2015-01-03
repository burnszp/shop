/**
 *ProductController.java
 *Version1.0
 *2015-1-2
 *Copyright cnendata.com
 *
 */
package org.enilu.shop.web.controller.admin;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.enilu.core.util.Pager;
import org.enilu.core.web.AbstractController;
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
@WebServlet("/admin/product")
public class ProductController extends AbstractController {
	private ProductDao productDao = new ProductDao();

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
		} else if ("del".equals(method)) {
			this.save(req, resp);
		} else if ("upload".equals(method)) {
			this.upload(req, resp);
		} else if ("save".equals(method)) {

			this.save(req, resp);
		} else {
			Pager pager = new Pager(req);
			pager.setPageSize(10);
			pager = productDao.findPage(pager);
			req.setAttribute("pager", pager);
			req.getRequestDispatcher("/page/admin/product.jsp").forward(req,
					resp);
		}

	}

	/**
	 * 查看商品详情
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	public void view(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Long id = Long.valueOf(req.getParameter("id"));
		Product entity = productDao.findById(id);
		req.setAttribute("obj", entity);
		req.getRequestDispatcher("/page/admin/productForm.jsp").forward(req,
				resp);

	}

	/**
	 * 商品下架
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void del(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String idsStr = req.getParameter("ids");
		String[] ids = idsStr.split(",");
		Long[] ids2 = new Long[ids.length];
		for (int i = 0; i < ids2.length; i++) {
			ids2[i] = Long.valueOf(ids[i]);
		}
		productDao.delete(ids2);

		resp.sendRedirect("../admin/product");

	}

	/**
	 * 请求商品添加页面
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void add(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/page/admin/productForm.jsp").forward(req,
				resp);

	}

	/**
	 * 保存商品
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void save(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String idStr = req.getParameter("id");
		Product entity = null;
		if (idStr != null && !"".equals(idStr.trim())) {
			entity = productDao.findById(Long.valueOf(idStr));
		} else {
			entity = new Product();
		}
		entity.setDescript(req.getParameter("descript"));
		String img = req.getParameter("img");
		if (img == null || "".equals(img)) {
			// 如果没有图片说明是新增商品，生成随机图片路径。
			entity.setImg("test0" + (new Random().nextInt(3) + 1) + ".png");
		}
		// System.out.println(req.getParameter("pname"));
		entity.setPname(req.getParameter("pname"));
		entity.setPrice(BigDecimal.valueOf(Double.valueOf(req
				.getParameter("price"))));
		entity.setStock(Integer.valueOf(req.getParameter("stock")));
		System.out.println(req.getParameter("pstatus"));
		String pstatusStr = req.getParameter("pstatus");
		if ("on".equals(pstatusStr)) {
			entity.setPstatus(Product.STATUS_ON);
		} else {
			entity.setPstatus(Product.STATUS_OFF);
		}
		productDao.save(entity);
		resp.sendRedirect("../admin/product");
	}

	/**
	 * 产品上架
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void upload(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String idsStr = req.getParameter("ids");
		String[] ids = idsStr.split(",");
		Long[] ids2 = new Long[ids.length];
		for (int i = 0; i < ids2.length; i++) {
			ids2[i] = Long.valueOf(ids[i]);
		}
		productDao.upload(ids2);
		resp.sendRedirect("../admin/product");

	}

}
