package com.bootdo.test.domain;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @author lzh
 *
 */
public class FruitDO {
	//编号
	private Long id;
	//水果名称
	private String name;
	//重量
	private String weight;
	//颜色
	private String color;
	//创建时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String createDate;
	//更新时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String updateDate;
	//备注信息
	private String remarks;
	//删除标记
	private String delFlag;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	@Override
	public String toString() {
		return "FruitDO [id=" + id + ", name=" + name + ", weight=" + weight + ", color=" + color
				+ ", createDate=" + createDate + ", updateDate=" + updateDate + ", remarks=" + remarks + ", delFlag="
				+ delFlag + "]";
	}
	
}
