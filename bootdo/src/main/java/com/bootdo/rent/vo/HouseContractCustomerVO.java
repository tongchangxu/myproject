package com.bootdo.rent.vo;
/**
 * 
 * @author lzh
 *
 */
public class HouseContractCustomerVO {
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
		//序号
		private Long houseContractCustomerId;
		public Long getHouseId() {
			return houseId;
		}
		public void setHouseId(Long houseId) {
			this.houseId = houseId;
		}
		public String getHouseNumber() {
			return houseNumber;
		}
		public void setHouseNumber(String houseNumber) {
			this.houseNumber = houseNumber;
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
		public String getHouseType() {
			return houseType;
		}
		public void setHouseType(String houseType) {
			this.houseType = houseType;
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
		public Long getHouseContractCustomerId() {
			return houseContractCustomerId;
		}
		public void setHouseContractCustomerId(Long houseContractCustomerId) {
			this.houseContractCustomerId = houseContractCustomerId;
		}
		@Override
		public String toString() {
			return "HouseContractCustomerVO [houseId=" + houseId + ", houseNumber=" + houseNumber + ", address="
					+ address + ", space=" + space + ", houseType=" + houseType + ", houseStatus=" + houseStatus
					+ ", area=" + area + ", houseRemark=" + houseRemark + ", customerId=" + customerId + ", number="
					+ number + ", customerName=" + customerName + ", customerStatus=" + customerStatus
					+ ", customerRemark=" + customerRemark + ", houseContractCustomerId=" + houseContractCustomerId
					+ "]";
		}
		
}
