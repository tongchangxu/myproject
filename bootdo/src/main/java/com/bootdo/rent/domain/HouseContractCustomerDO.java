package com.bootdo.rent.domain;

/**
 * 
 * @author lzh
 *
 */
public class HouseContractCustomerDO {
	private Long houseContractCustomerId;
	private Long houseId;
	private String contractNumber;
	private String number;
	private Long customerId;
	public Long getHouseContractCustomerId() {
		return houseContractCustomerId;
	}
	public void setHouseContractCustomerId(Long houseContractCustomerId) {
		this.houseContractCustomerId = houseContractCustomerId;
	}
	public Long getHouseId() {
		return houseId;
	}
	public void setHouseId(Long houseId) {
		this.houseId = houseId;
	}
	public String getContractNumber() {
		return contractNumber;
	}
	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	@Override
	public String toString() {
		return "HouseContractCustomerDO [houseContractCustomerId=" + houseContractCustomerId + ", houseId=" + houseId
				+ ", contractNumber=" + contractNumber + ", number=" + number + ", customerId=" + customerId + "]";
	}
	
	
}