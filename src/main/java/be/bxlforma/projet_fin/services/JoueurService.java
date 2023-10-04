package be.bxlforma.projet_fin.services;

import be.bxlforma.projet_fin.dal.entities.JoueurEntity;

import java.util.Optional;
import java.util.Collection;

public interface JoueurService {
    Collection<JoueurEntity> findAll();
    Optional<JoueurEntity> findOneById(int id);

    void insert(JoueurEntity entity);
}