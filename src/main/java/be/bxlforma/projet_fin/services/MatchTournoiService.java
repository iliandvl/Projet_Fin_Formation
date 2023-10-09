package be.bxlforma.projet_fin.services;

import be.bxlforma.projet_fin.dal.entities.MatchTournoiEntity;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Collection;

public interface MatchTournoiService {
    ArrayList<MatchTournoiEntity> findAll();
    Optional<MatchTournoiEntity> findOneById(int id);

    void insert(MatchTournoiEntity entity);
}