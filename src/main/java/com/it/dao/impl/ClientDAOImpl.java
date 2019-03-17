package com.it.dao.impl;

import com.it.dao.ClientDao;
import com.it.model.Client;
import com.it.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ClientDAOImpl extends GenericDAOImpl<Client, Integer> implements ClientDao {
    private static ClientDAOImpl instance;

    private ClientDAOImpl() {
        super(Client.class);
    }

    synchronized public static ClientDAOImpl getInstance() {
        if (instance == null) {
            instance = new ClientDAOImpl();
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
    /**
     * Find Client by Name And Code
     * NativeSQl implementation
     *
     * @param login - name
     * @param password - code
     * @return Client
     */
    @Override
    public Client findByLoginAndPassword(String login, String password) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT detail.* FROM Detail detail WHERE user.login=?1 AND user.password=?2";
            Query query = session.createNativeQuery(hql, Client.class);
            query.setParameter(1, login);
            query.setParameter(2, password);
            return (Client) query.getSingleResult();
        }
    }
}
