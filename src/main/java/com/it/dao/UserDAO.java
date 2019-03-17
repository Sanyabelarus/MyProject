package com.it.dao;

import com.it.model.User;

import java.time.LocalDate;
import java.util.List;

public interface UserDAO extends GenericDAO<User, Integer> {
    List<User> findAll(Integer firstResult, Integer maxResult);

}
