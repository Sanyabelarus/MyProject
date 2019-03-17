package com.it.dao.impl;

import com.it.dao.DateTimeDAO;
import com.it.dao.GymDAO;
import com.it.model.Client;
import com.it.model.DateTime;
import com.it.model.Gym;
import com.it.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class GymDAOImpl extends GenericDAOImpl<Gym, Integer> implements GymDAO {
    private static GymDAOImpl instance;

    private GymDAOImpl() {
        super(Gym.class);
    }

    synchronized public static GymDAOImpl getInstance() {
        if (instance == null) {
            instance = new GymDAOImpl();
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
