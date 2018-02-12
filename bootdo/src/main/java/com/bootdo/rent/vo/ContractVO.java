package com.bootdo.rent.vo;
/**
 * 
 * @author lzh
 *
 */
public class ContractVO {
	//租赁合同序号
	private Long contractId;
	//租赁合同序号
	private String contractNumber;
	//归属区域
	private String area;
	//经办人
	private String operator;
	//业务号
    private String number;
	//客户名称
	private String customerName;
	//合同名称
    private String contractName;
	//关联公司
	private String company;
	//地址
	private String address;
	//起始时间
	private String startTime;
	//到期日期
	private String stopTime;
	//合同期限
	private String contractPeriod;
	//面积
	private String space;
	//租金
	private String rent;
	//缴费周期
	private String leadTime;
	//发票类型
    private String invoiceType;
	//年递增率
	private String growthRate;
	//租金明细
	private String rentDetail;
	//年租金
	private String rentYear;
	//定金
	private String deposit;
	//房屋序号
	private String houseId;
	//合同状态
	private String contractStatus;
	//创建日期
	private String createTime;
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
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
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
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getContractPeriod() {
		return contractPeriod;
	}
	public void setContractPeriod(String contractPeriod) {
		this.contractPeriod = contractPeriod;
	}
	public String getSpace() {
		return space;
	}
	public void setSpace(String space) {
		this.space = space;
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
	public String getHouseId() {
		return houseId;
	}
	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}
	public String getContractStatus() {
		return contractStatus;
	}
	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "contractDO [contractId=" + contractId + ", contractNumber=" + contractNumber + ", area=" + area
				+ ", operator=" + operator + ", number=" + number + ", customerName=" + customerName + ", contractName="
				+ contractName + ", company=" + company + ", address=" + address + ", startTime=" + startTime
				+ ", stopTime=" + stopTime + ", contractPeriod=" + contractPeriod + ", space=" + space + ", rent="
				+ rent + ", leadTime=" + leadTime + ", invoiceType=" + invoiceType + ", growthRate=" + growthRate
				+ ", rentDetail=" + rentDetail + ", rentYear=" + rentYear + ", deposit=" + deposit + ", houseId="
				+ houseId + ", contractStatus=" + contractStatus + ", createTime=" + createTime + "]";
	}
	
}
