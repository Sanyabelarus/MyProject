package com.it.dao;

import com.it.dao.GenericDAO;
import com.it.model.Client;
import com.it.model.Roles;

import java.util.List;

public interface RolesDao extends GenericDAO<Roles, Integer> {
    List<Client> findAll(Integer firstResult, Integer maxResult);
}
