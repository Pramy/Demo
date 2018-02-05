package com.pramy.demo.mybatisplus.po;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author pramy
 * @since 2018-02-04
 */
@TableName("db_test")
public class DbTest implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private Integer id;

	/**
	 * 
	 */
	@TableField(value="user_name")
	private String userName;

	/**
	 * 
	 */
	private String password;



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
