package com.kce.bean;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "PARKING_PERMIT_TBL")
public class ParkingPermit {

	@Id
	@Column(name = "PERMIT_ID")
	private String permitID;

	@ManyToOne
	@JoinColumn(name = "PERMIT_HOLDER_ID", nullable = false)
	private PermitHolder permitHolder;

	@Column(name = "VEHICLE_REG_NO", nullable = false)
	private String vehicleRegNo;

	@Column(name = "VEHICLE_TYPE", nullable = false)
	private String vehicleType;

	@Column(name = "ZONE_CODE", nullable = false)
	private String zoneCode;

	@Column(name = "PERMIT_START_DATE", nullable = false)
	private Date permitStartDate;

	@Column(name = "PERMIT_END_DATE", nullable = false)
	private Date permitEndDate;

	@Column(name = "PERMIT_STATUS")
	private String permitStatus;

	@Column(name = "VIOLATION_COUNT")
	private int violationCount;

	@Column(name = "OUTSTANDING_FINE_AMOUNT")
	private BigDecimal outstandingFineAmount;

	// Getters and Setters

	public String getPermitID() {
		return permitID;
	}

	public void setPermitID(String permitID) {
		this.permitID = permitID;
	}

	public PermitHolder getPermitHolder() {
		return permitHolder;
	}

	public void setPermitHolder(PermitHolder permitHolder) {
		this.permitHolder = permitHolder;
	}

	public String getVehicleRegNo() {
		return vehicleRegNo;
	}

	public void setVehicleRegNo(String vehicleRegNo) {
		this.vehicleRegNo = vehicleRegNo;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getZoneCode() {
		return zoneCode;
	}

	public void setZoneCode(String zoneCode) {
		this.zoneCode = zoneCode;
	}

	public Date getPermitStartDate() {
		return permitStartDate;
	}

	public void setPermitStartDate(Date permitStartDate) {
		this.permitStartDate = permitStartDate;
	}

	public Date getPermitEndDate() {
		return permitEndDate;
	}

	public void setPermitEndDate(Date permitEndDate) {
		this.permitEndDate = permitEndDate;
	}

	public String getPermitStatus() {
		return permitStatus;
	}

	public void setPermitStatus(String permitStatus) {
		this.permitStatus = permitStatus;
	}

	public int getViolationCount() {
		return violationCount;
	}

	public void setViolationCount(int violationCount) {
		this.violationCount = violationCount;
	}

	public BigDecimal getOutstandingFineAmount() {
		return outstandingFineAmount;
	}

	public void setOutstandingFineAmount(BigDecimal outstandingFineAmount) {
		this.outstandingFineAmount = outstandingFineAmount;
	}
}