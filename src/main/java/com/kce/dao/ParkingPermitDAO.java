package com.kce.dao;

import java.math.BigDecimal;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.kce.bean.ParkingPermit;
import com.kce.util.HibernateUtil;

public class ParkingPermitDAO {

	public ParkingPermit findById(String permitID) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(ParkingPermit.class, permitID);
		}
	}

	public boolean save(ParkingPermit permit) {
		Transaction tx = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			session.persist(permit);
			tx.commit();
			return true;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(ParkingPermit permit) {
		Transaction tx = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			session.merge(permit);
			tx.commit();
			return true;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			return false;
		}
	}

	public List<ParkingPermit> findByHolder(String holderID) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session
					.createQuery("FROM ParkingPermit p WHERE p.permitHolder.permitHolderID = :id", ParkingPermit.class)
					.setParameter("id", holderID).list();
		}
	}

	public BigDecimal calculateTotalFine(String holderID) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			BigDecimal total = session.createQuery(
					"SELECT SUM(p.outstandingFineAmount) FROM ParkingPermit p WHERE p.permitHolder.permitHolderID = :id",
					BigDecimal.class).setParameter("id", holderID).uniqueResult();

			return total == null ? BigDecimal.ZERO : total;
		}
	}
}