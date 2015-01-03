/**
 *Product.java
 *Version1.0
 *2015-1-1
 *Copyright cnendata.com
 *
 */
package org.enilu.shop.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品实体<br>
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
public class Product {
	/**
	 * 商品上架标识
	 */
	public static final Short STATUS_ON = 1;
	/**
	 * 商品下架标识
	 */
	public static final Short STATUS_OFF = 2;
	/**
	 * 商品id，主键
	 */
	private Long id;
	/**
	 * 商品名称
	 */
	private String pname;
	/**
	 * 详细描述
	 */
	private String descript;
	/**
	 * 库存数量
	 */
	private Integer stock;
	/**
	 * 商品图片路径
	 */
	private String img;
	/**
	 * 上架日期
	 */
	private Date update;
	/**
	 * 商品单价
	 */
	private BigDecimal price;
	/**
	 * 上架状态：1，上架，2下架
	 */
	private Short pstatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Date getUpdate() {
		return update;
	}

	public void setUpdate(Date update) {
		this.update = update;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Short getPstatus() {
		return pstatus;
	}

	public void setPstatus(Short pstatus) {
		this.pstatus = pstatus;
	}

}
