package com.bootdo.rent.domain;

/**
 * 
 * @author lzh
 *
 */
public class HouseDO {
	//房屋序号
	private Long house_id;
	//地址
	private String address;
	//面积
	private String space;
	//房屋状态
	private String house_status;
	//归属区域
	private String area;
	//房间说明
	private String house_remark;
	
	public Long getHouse_id() {
		return house_id;
	}
	public void setHouse_id(Long house_id) {
		this.house_id = house_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSpace() {
		return space;
	}
	public void setSpace(String space) {
		this.space = space;
	}
	public String getHouse_status() {
		return house_status;
	}
	public void setHouse_status(String house_status) {
		this.house_status = house_status;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getHouse_remark() {
		return house_remark;
	}
	public void setHouse_remark(String house_remark) {
		this.house_remark = house_remark;
	}
	@Override
	public String toString() {
		return "HouseDO [ address=" + address + ", space=" + space + ", house_status="
				+ house_status + ", area=" + area + ", house_remark=" + house_remark + "]";
	}

	
}
