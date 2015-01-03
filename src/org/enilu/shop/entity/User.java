/**
 *User.java
 *Version1.0
 *2015-1-1
 *Copyright cnendata.com
 *
 */
package org.enilu.shop.entity;

/**
 * 管理员<br>
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
public class User {

	public static final int USERTYPE_ADMIN = 1;
	public static final int USERTYPE_CASHIER = 2;
	private Long id;
	private String username;
	private String password;
	/**
	 * 用户类型：1：管理员，2：收款员
	 */
	private Short usertype;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Short getUsertype() {
		return usertype;
	}

	public void setUsertype(Short usertype) {
		this.usertype = usertype;
	}

}
