package com.guigu.domain.materials;

/**
 * 供应商信息表
 */
public class Provider {
	private String providerId;
	private String proName;
	private String functionary;
	private String bindAccount;
	private String phone;
	private String email;
	private String address;

	// 外加,合同编号
	private String contractNO;

	public Provider() {

	}

	public Provider(String providerId, String proName, String functionary, String bindAccount, String phone,
			String email, String address, String contractNO) {
		this.providerId = providerId;
		this.proName = proName;
		this.functionary = functionary;
		this.bindAccount = bindAccount;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.contractNO = contractNO;
	}

	public String getBindAccount() {
		return bindAccount;
	}

	public void setBindAccount(String bindAccount) {
		this.bindAccount = bindAccount;
	}

	public String getContractNO() {
		return contractNO;
	}

	public void setContractNO(String contractNO) {
		this.contractNO = contractNO;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getFunctionary() {
		return functionary;
	}

	public void setFunctionary(String functionary) {
		this.functionary = functionary;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBindaccount() {
		return bindAccount;
	}

	public void setBindaccount(String bindaccount) {
		this.bindAccount = bindaccount;
	}
}
