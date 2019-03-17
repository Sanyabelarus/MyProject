package com.it.dao;

import com.it.model.Client;
import com.it.model.DateTime;
import com.it.model.Day;

import java.util.List;

public interface DayDAO extends GenericDAO<Day, Integer> {
    List<Client> findAll(Integer firstResult, Integer maxResult);
}
