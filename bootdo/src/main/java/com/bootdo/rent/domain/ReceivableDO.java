package com.bootdo.rent.domain;

/**
 * 
 * @author lzh
 *
 */
public class ReceivableDO {
	//应收记录表序号
	private Long receivableId;
	//租赁合同序号
	private Long contractId;
	//业务号
    private String number;
	//应收日期
    private String receivableDate;
	//应收金额
	private String receivableAmount;
	//缴费状态
	private String payStatus;
	//创建日期
	private String createTime;
	public Long getReceivableId() {
		return receivableId;
	}
	public void setReceivableId(Long receivableId) {
		this.receivableId = receivableId;
	}
	public Long getContractId() {
		return contractId;
	}
	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getReceivableDate() {
		return receivableDate;
	}
	public void setReceivableDate(String receivableDate) {
		this.receivableDate = receivableDate;
	}
	public String getReceivableAmount() {
		return receivableAmount;
	}
	public void setReceivableAmount(String receivableAmount) {
		this.receivableAmount = receivableAmount;
	}
	public String getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "ReceivableDO [receivableId=" + receivableId + ", contractId=" + contractId + ", number=" + number
				+ ", receivableDate=" + receivableDate + ", receivableAmount=" + receivableAmount + ", payStatus="
				+ payStatus + ", createTime=" + createTime + "]";
	}
	
}
