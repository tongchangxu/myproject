package com.bootdo.rent.domain;

/**
 * 
 * @author lzh
 *
 */
public class HouseDO {
	//房屋序号
	private Long houseId;
	//房屋序号
    private String houseNumber;
	//地址
	private String address;
	//面积
	private String space;
	//房屋类型
	private String houseType;
	//房屋状态
	private String houseStatus;
	//归属区域
	private String area;
	//房间说明
	private String houseRemark;
	//操作时间
    private String handleTime;
    //操作
    private String handle;
    //操作序號
    private Long houseHandleId;
    
	public String getHandleTime() {
		return handleTime;
	}
	public void setHandleTime(String handleTime) {
		this.handleTime = handleTime;
	}
	public String getHandle() {
		return handle;
	}
	public void setHandle(String handle) {
		this.handle = handle;
	}
	public Long getHouseHandleId() {
		return houseHandleId;
	}
	public void setHouseHandleId(Long houseHandleId) {
		this.houseHandleId = houseHandleId;
	}
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getHouseType() {
		return houseType;
	}
	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}
	public Long getHouseId() {
		return houseId;
	}
	public void setHouseId(Long houseId) {
		this.houseId = houseId;
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
	public String getHouseStatus() {
		return houseStatus;
	}
	public void setHouseStatus(String houseStatus) {
		this.houseStatus = houseStatus;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getHouseRemark() {
		return houseRemark;
	}
	public void setHouseRemark(String houseRemark) {
		this.houseRemark = houseRemark;
	}
	
	
	
}