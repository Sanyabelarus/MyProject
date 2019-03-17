package com.it.dao.impl;

import com.it.dao.ClientDao;
import com.it.dao.RolesDao;
import com.it.model.Client;
import com.it.model.Roles;
import com.it.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class RolesDAOImpl extends GenericDAOImpl<Roles, Integer> implements RolesDao {
    private static RolesDAOImpl instance;

    private RolesDAOImpl() {
        super(Roles.class);
    }

    synchronized public static RolesDAOImpl getInstance() {
        if (instance == null) {
            instance = new RolesDAOImpl();
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
