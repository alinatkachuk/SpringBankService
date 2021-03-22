package com.alinatkachuk.springtask.dao;

import com.alinatkachuk.springtask.entity.DebitCard;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class DebitCardDAOImpl implements DebitCardDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<DebitCard> allDebitCard() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from DebitCard").list();
    }

    @Override
    public void addDebitCard(DebitCard debitCard) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(debitCard);
    }

    @Override
    public void deleteDebitCard(DebitCard debitCard) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(debitCard);
    }

    @Override
    public void editDebitCard(DebitCard debitCard) {
        Session session = sessionFactory.getCurrentSession();
        session.update(debitCard);
    }

    @Override
    public DebitCard getDebitCardById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(DebitCard.class, id);
    }
}
