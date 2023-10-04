package be.bxlforma.projet_fin.services;

import be.bxlforma.projet_fin.dal.entities.GroupeEntity;

import java.util.Optional;
import java.util.Collection;

public interface GroupeService {
    Collection<GroupeEntity> findAll();
    Optional<GroupeEntity> findOneById(int id);

    void insert(GroupeEntity entity);
}