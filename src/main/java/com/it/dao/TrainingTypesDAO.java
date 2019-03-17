package com.it.dao;

import com.it.model.Client;

import java.util.List;

public interface TrainingTypesDAO extends GenericDAO<com.it.model.TrainingTypes, Integer> {
    List<Client> findAll(Integer firstResult, Integer maxResult);
}
