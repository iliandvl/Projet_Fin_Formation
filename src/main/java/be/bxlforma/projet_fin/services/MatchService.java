package be.bxlforma.projet_fin.services;

import be.bxlforma.projet_fin.dal.entities.MatchEntity;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Collection;

public interface MatchService {
    ArrayList<MatchEntity> findAll();
    Optional<MatchEntity> findOneById(int id);

    void insert(MatchEntity entity);
}