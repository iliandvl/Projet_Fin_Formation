package be.bxlforma.projet_fin.services;

import be.bxlforma.projet_fin.dal.entities.MatchTournoiEntity;

import java.util.Optional;
import java.util.Collection;

public interface MatchTournoiService {
    Collection<MatchTournoiEntity> findAll();
    Optional<MatchTournoiEntity> findOneById(int id);

    void insert(MatchTournoiEntity entity);
}