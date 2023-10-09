package be.bxlforma.projet_fin.services;

import be.bxlforma.projet_fin.dal.entities.GroupeEntity;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Collection;


public interface GroupeService {
    ArrayList<GroupeEntity> findAll();
    Optional<GroupeEntity> findOneById(int id);

    void insert(GroupeEntity entity);
}