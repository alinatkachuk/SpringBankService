package com.alinatkachuk.springtask.dao;

import com.alinatkachuk.springtask.entity.Loan;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class LoanDAOImpl implements LoanDAO{

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Loan> allLoans() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Loan").list();
    }

    @Override
    public void addLoan(Loan loan) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(loan);
    }

    @Override
    public void deleteLoan(Loan loan) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(loan);
    }

    @Override
    public void editLoan(Loan loan) {
        Session session = sessionFactory.getCurrentSession();
        session.update(loan);
    }

    @Override
    public Loan getLoanById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Loan.class, id);
    }
}
