package com.it.dao;

import com.it.model.Client;
import com.it.model.DateTime;
import com.it.model.Trainer;

import java.util.List;

public interface TrainerDAO extends GenericDAO<Trainer, Integer> {
    List<Client> findAll(Integer firstResult, Integer maxResult);
}
