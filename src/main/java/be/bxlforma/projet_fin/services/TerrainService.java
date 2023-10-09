package be.bxlforma.projet_fin.services;

import be.bxlforma.projet_fin.dal.entities.TerrainEntity;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Collection;

public interface TerrainService {
    ArrayList<TerrainEntity> findAll();
    Optional<TerrainEntity> findOneById(int id);

    void insert(TerrainEntity entity);
}