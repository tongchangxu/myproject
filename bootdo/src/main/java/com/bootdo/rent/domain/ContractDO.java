package com.bootdo.rent.domain;
/**
 * 
 * @author lzh
 *
 */
public class ContractDO {
	//租赁合同序号
	private Long contractId;
	//租赁合同序号
	private String contractNumber;
	//经办人
	private String operator;
	//业务号
    private String number;
	//合同名称
    private String contractName;
	//关联公司
	private String company;
	//起始时间
	private String startTime;
	//到期日期
	private String stopTime;
	//租金
	private String rent;
	//缴费周期
	private String leadTime;
	//发票类型
    private String invoiceType;
	//年递增率
	private String growthRate;
	//递增周期 growth_time
	private String growthTime;
	//租金明细
	private String rentDetail;
	//年租金
	private String rentYear;
	//定金
	private String deposit;
	//合同状态
	private String contractStatus;
	//合同状态说明
	private String statusDescription;
	//创建日期
	private String createTime;
	
	public String getGrowthTime() {
		return growthTime;
	}
	public void setGrowthTime(String growthTime) {
		this.growthTime = growthTime;
	}
	public Long getContractId() {
		return contractId;
	}
	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}
	public String getContractNumber() {
		return contractNumber;
	}
	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getContractName() {
		return contractName;
	}
	public void setContractName(String contractName) {
		this.contractName = contractName;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getStopTime() {
		return stopTime;
	}
	public void setStopTime(String stopTime) {
		this.stopTime = stopTime;
	}
	public String getRent() {
		return rent;
	}
	public void setRent(String rent) {
		this.rent = rent;
	}
	public String getLeadTime() {
		return leadTime;
	}
	public void setLeadTime(String leadTime) {
		this.leadTime = leadTime;
	}
	public String getInvoiceType() {
		return invoiceType;
	}
	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}
	public String getGrowthRate() {
		return growthRate;
	}
	public void setGrowthRate(String growthRate) {
		this.growthRate = growthRate;
	}
	public String getRentDetail() {
		return rentDetail;
	}
	public void setRentDetail(String rentDetail) {
		this.rentDetail = rentDetail;
	}
	public String getRentYear() {
		return rentYear;
	}
	public void setRentYear(String rentYear) {
		this.rentYear = rentYear;
	}
	public String getDeposit() {
		return deposit;
	}
	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}
	public String getContractStatus() {
		return contractStatus;
	}
	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}
	public String getStatusDescription() {
		return statusDescription;
	}
	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "ContractDO [contractId=" + contractId + ", contractNumber=" + contractNumber + ", operator=" + operator
				+ ", number=" + number + ", contractName=" + contractName + ", company=" + company + ", startTime="
				+ startTime + ", stopTime=" + stopTime + ", rent=" + rent + ", leadTime=" + leadTime + ", invoiceType="
				+ invoiceType + ", growthRate=" + growthRate + ", rentDetail=" + rentDetail + ", rentYear=" + rentYear
				+ ", deposit=" + deposit + ", contractStatus=" + contractStatus + ", statusDescription="
				+ statusDescription + ", createTime=" + createTime + "]";
	}
}
