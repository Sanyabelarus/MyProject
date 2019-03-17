package com.it.dao.impl;

import com.it.dao.DateTimeDAO;
import com.it.dao.TrainingTypesDAO;
import com.it.model.Client;
import com.it.model.DateTime;
import com.it.model.TrainingTypes;
import com.it.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class TrainingTypesDAOImpl extends GenericDAOImpl<TrainingTypes, Integer> implements TrainingTypesDAO {
    private static TrainingTypesDAOImpl instance;

    private TrainingTypesDAOImpl() {
        super(TrainingTypes.class);
    }

    synchronized public static TrainingTypesDAOImpl getInstance() {
        if (instance == null) {
            instance = new TrainingTypesDAOImpl();
        }
        return instance;
    }

}
