package com.it.dao;

import com.it.model.Client;
import com.it.model.Section;

import java.util.List;

public interface SectionDao extends GenericDAO<Section, Integer> {
    List<Client> findAll(Integer firstResult, Integer maxResult);
}
