package com.bootdo.rent.domain;

/**
 * 
 * @author lzh
 *
 */
public class CustomerDO {
	//客户序号
	private Long customerId;
	//业务号
	private String number;
	//客户名称
	private String customerName;
	//客户状态
	private String customerStatus;
	//客户说明
	private String customerRemark;
	//操作时间
    private String handleTime;
    //操作
    private String handle;
    //操作序號
    private Long customerHandleId;
    
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
	public Long getCustomerHandleId() {
		return customerHandleId;
	}
	public void setCustomerHandleId(Long customerHandleId) {
		this.customerHandleId = customerHandleId;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerStatus() {
		return customerStatus;
	}
	public void setCustomerStatus(String customerStatus) {
		this.customerStatus = customerStatus;
	}
	public String getCustomerRemark() {
		return customerRemark;
	}
	public void setCustomerRemark(String customerRemark) {
		this.customerRemark = customerRemark;
	}
	
	
	
}