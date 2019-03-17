package com.it.dao;

import com.it.model.Client;
import com.it.model.DateTime;
import com.it.model.Time;

import java.util.List;

public interface TimeDAO extends GenericDAO<Time, Integer> {
    List<Client> findAll(Integer firstResult, Integer maxResult);
}
