package com.kce.bean;

import javax.persistence.*;

@Entity
@Table(name = "PERMIT_HOLDER_TBL")
public class PermitHolder {

	@Id
	@Column(name = "PERMIT_HOLDER_ID")
	private String permitHolderID;

	@Column(name = "FULL_NAME", nullable = false)
	private String fullName;

	@Column(name = "HOLDER_TYPE", nullable = false)
	private String holderType;

	@Column(name = "ADDRESS_LINE1", nullable = false)
	private String addressLine1;

	@Column(name = "ADDRESS_LINE2")
	private String addressLine2;

	@Column(name = "WARD_CODE", nullable = false)
	private String wardCode;

	@Column(name = "MOBILE", nullable = false)
	private String mobile;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "STATUS")
	private String status;

	public String getPermitHolderID() {
		return permitHolderID;
	}

	public void setPermitHolderID(String permitHolderID) {
		this.permitHolderID = permitHolderID;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getHolderType() {
		return holderType;
	}

	public void setHolderType(String holderType) {
		this.holderType = holderType;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getWardCode() {
		return wardCode;
	}

	public void setWardCode(String wardCode) {
		this.wardCode = wardCode;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}