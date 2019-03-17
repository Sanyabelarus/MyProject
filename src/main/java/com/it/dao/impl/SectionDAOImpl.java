package com.it.dao.impl;

import com.it.dao.ClientDao;
import com.it.dao.SectionDao;
import com.it.model.Client;
import com.it.model.Section;
import com.it.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class SectionDAOImpl extends GenericDAOImpl<Section, Integer> implements SectionDao {
    private static SectionDAOImpl instance;

    private SectionDAOImpl() {
        super(Section.class);
    }

    synchronized public static SectionDAOImpl getInstance() {
        if (instance == null) {
            instance = new SectionDAOImpl();
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
            Query query = session.createNativeQuery(hql, Section.class);
            query.setFirstResult(firstResult);
            query.setMaxResults(maxResult);
            return query.list();
        }
    }

}
