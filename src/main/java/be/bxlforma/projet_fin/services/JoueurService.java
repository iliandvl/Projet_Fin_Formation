package be.bxlforma.projet_fin.services;

import be.bxlforma.projet_fin.dal.entities.JoueurEntity;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Collection;

public interface JoueurService {
    ArrayList<JoueurEntity> findAll();
    Optional<JoueurEntity> findOneById(int id);

    void insert(JoueurEntity entity);
}