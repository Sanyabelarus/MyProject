package com.it.dao.impl;

import com.it.dao.DateTimeDAO;
import com.it.dao.TimeDAO;
import com.it.model.Client;
import com.it.model.DateTime;
import com.it.model.Time;
import com.it.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class TimeDAOImpl extends GenericDAOImpl<Time, Integer> implements TimeDAO {
    private static TimeDAOImpl instance;

    private TimeDAOImpl() {
        super(Time.class);
    }

    synchronized public static TimeDAOImpl getInstance() {
        if (instance == null) {
            instance = new TimeDAOImpl();
        }
        return instance;
    }

    /**
     * Find page of All Details
     * NativeSQl implementation
     *
     * @param firstResult - firstResult
     * @param maxResult   - maxResult
     * @return List<Client>
     */
    @Override
    public List<Client> findAll(Integer firstResult, Integer maxResult) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT detail.* FROM Detail detail";
            Query query = session.createNativeQuery(hql, Client.class);
            query.setFirstResult(firstResult);
            query.setMaxResults(maxResult);
            return query.list();
        }
    }

}
