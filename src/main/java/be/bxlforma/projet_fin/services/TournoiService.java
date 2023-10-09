package be.bxlforma.projet_fin.services;

import be.bxlforma.projet_fin.dal.entities.TournoiEntity;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Collection;

public interface TournoiService {
    ArrayList<TournoiEntity> findAll();
    Optional<TournoiEntity> findOneById(int id);

    void insert(TournoiEntity entity);
}