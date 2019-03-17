package com.it.dao;

import com.it.model.Client;
import com.it.model.DateTime;
import com.it.model.Gym;

import java.util.List;

public interface GymDAO extends GenericDAO<Gym, Integer> {
    List<Client> findAll(Integer firstResult, Integer maxResult);
}
