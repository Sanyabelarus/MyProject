package com.it.dao;

import com.it.model.Client;

import java.util.List;

public interface ClientDao extends GenericDAO<Client, Integer> {
    List<Client> findAll(Integer firstResult, Integer maxResult);

    Client findByLoginAndPassword(String name, String code);
}
