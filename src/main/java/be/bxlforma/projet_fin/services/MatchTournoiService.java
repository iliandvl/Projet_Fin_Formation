package be.bxlforma.projet_fin.services;

import be.bxlforma.projet_fin.controllers.models.MatchTournoi;
import be.bxlforma.projet_fin.dal.entities.MatchGroupeEntity;
import be.bxlforma.projet_fin.dal.entities.MatchTournoiEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Collection;

public interface MatchTournoiService {
    ArrayList<MatchTournoiEntity> findAll();
    Optional<MatchTournoiEntity> findOneById(int id);

    List<MatchTournoiEntity> findAllByMatch(int id);

    List<MatchTournoiEntity> findAllByTournoi(int id);

    void insert(MatchTournoiEntity entity);
}