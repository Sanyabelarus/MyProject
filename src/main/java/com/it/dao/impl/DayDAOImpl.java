package com.it.dao.impl;

import com.it.dao.DateTimeDAO;
import com.it.dao.DayDAO;
import com.it.model.Client;
import com.it.model.DateTime;
import com.it.model.Day;
import com.it.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class DayDAOImpl extends GenericDAOImpl<Day, Integer> implements DayDAO {
    private static DayDAOImpl instance;

    private DayDAOImpl() {
        super(Day.class);
    }

    synchronized public static DayDAOImpl getInstance() {
        if (instance == null) {
            instance = new DayDAOImpl();
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
