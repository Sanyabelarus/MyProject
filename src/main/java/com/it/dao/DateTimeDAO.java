package com.it.dao;

import com.it.dao.GenericDAO;
import com.it.model.Client;
import com.it.model.DateTime;

import java.util.List;

public interface DateTimeDAO extends GenericDAO<DateTime, Integer> {
    List<Client> findAll(Integer firstResult, Integer maxResult);
}
