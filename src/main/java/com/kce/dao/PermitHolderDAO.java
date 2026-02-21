package com.kce.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.kce.bean.PermitHolder;
import com.kce.util.HibernateUtil;

public class PermitHolderDAO {

    public PermitHolder findById(String permitHolderID) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(PermitHolder.class, permitHolderID);
        }
    }

    public List<PermitHolder> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM PermitHolder", PermitHolder.class).list();
        }
    }

    public boolean save(PermitHolder holder) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(holder);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(PermitHolder holder) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.merge(holder);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(PermitHolder holder) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.remove(holder);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }
}