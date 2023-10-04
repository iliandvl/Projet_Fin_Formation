package be.bxlforma.projet_fin.services;

import be.bxlforma.projet_fin.dal.entities.MatchGroupeEntity;

import java.util.Optional;
import java.util.Collection;

public interface MatchGroupeService {
    Collection<MatchGroupeEntity> findAll();
    Optional<MatchGroupeEntity> findOneById(int id);

    void insert(MatchGroupeEntity entity);
}