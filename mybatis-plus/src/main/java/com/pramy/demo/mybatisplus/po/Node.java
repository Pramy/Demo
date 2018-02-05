package com.pramy.demo.mybatisplus.po;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 节点表
 * </p>
 *
 * @author pramy
 * @since 2018-02-05
 */
public class Node extends Model<Node> implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.ID_WORKER)
	private Integer id;

	/**
	 * 
	 */
	private String name;

	/**
	 * 
	 */
	@TableField(value="parent_id")
	private Integer parentId;



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}
}
