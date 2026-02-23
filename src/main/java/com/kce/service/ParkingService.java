package com.kce.service;

import java.math.BigDecimal;
import java.util.List;

import com.kce.bean.PermitHolder;
import com.kce.bean.ParkingPermit;
import com.kce.dao.PermitHolderDAO;
import com.kce.dao.ParkingPermitDAO;
import com.kce.util.ValidationException;

public class ParkingService {

	private PermitHolderDAO holderDAO = new PermitHolderDAO();
	private ParkingPermitDAO permitDAO = new ParkingPermitDAO();

	public boolean registerNewPermitHolder(PermitHolder holder) throws ValidationException {

		if (holder == null || holder.getPermitHolderID() == null)
			throw new ValidationException();

		return holderDAO.save(holder);
	}

	public PermitHolder viewPermitHolderDetails(String holderID) {
		return holderDAO.findById(holderID);
	}

	public boolean applyForNewPermit(ParkingPermit permit) throws ValidationException {

		if (permit == null || permit.getPermitID() == null)
			throw new ValidationException();

		return permitDAO.save(permit);
	}

	public boolean renewPermit(String permitID) {

		ParkingPermit permit = permitDAO.findById(permitID);

		if (permit == null)
			return false;

		permit.setPermitStatus("ACTIVE");

		return permitDAO.update(permit);
	}

	public boolean recordViolation(String permitID, BigDecimal fine) {

		ParkingPermit permit = permitDAO.findById(permitID);

		if (permit == null)
			return false;

		permit.setViolationCount(permit.getViolationCount() + 1);
		permit.setOutstandingFineAmount(permit.getOutstandingFineAmount().add(fine));

		return permitDAO.update(permit);
	}

	public BigDecimal calculateTotalOutstandingFine(String holderID) {
		return permitDAO.calculateTotalFine(holderID);
	}

	public List<ParkingPermit> viewPermitsByHolder(String holderID) {
		return permitDAO.findByHolder(holderID);
	}
}