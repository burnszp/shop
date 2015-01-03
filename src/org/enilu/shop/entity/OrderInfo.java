/**
 *OrderInfo.java
 *Version1.0
 *2015-1-3
 *Copyright cnendata.com
 *
 */
package org.enilu.shop.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.enilu.shop.dao.CustomerDao;
import org.enilu.shop.dao.UserDao;

/**
 * 订单实体<br>
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
public class OrderInfo {
	private CustomerDao customerDao = new CustomerDao();
	private UserDao adminDao = new UserDao();
	private Long id;
	/**
	 * 订单号
	 */
	private String orderId;
	/**
	 * 创建日期
	 */
	private Date createDate;
	/**
	 * 顾客id
	 */
	private Long customerId;
	/**
	 * 顾客对象
	 */
	private Customer customer;
	/**
	 * 订单状态：1：已下单，未处理，2，已处理
	 */
	private Short ostatus;
	/**
	 * 收款员id
	 */
	private Long adminId;
	/**
	 * 收款员对象
	 */
	private User admin;
	/**
	 * 本次订单积分
	 */
	private BigDecimal score;
	/**
	 * 本次订单总金额
	 */
	private BigDecimal totalPrice;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
		this.customer = customerDao.findById(customerId);
	}

	public Short getOstatus() {
		return ostatus;
	}

	public void setOstatus(Short ostatus) {
		this.ostatus = ostatus;
	}

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
		this.admin = adminDao.findById(adminId);
	}

	public BigDecimal getScore() {
		return score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public User getAdmin() {
		return admin;
	}

	public void setAdmin(User admin) {
		this.admin = admin;
	}

}
