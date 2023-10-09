package be.bxlforma.projet_fin.services;

import be.bxlforma.projet_fin.dal.entities.TerrainEntity;
import be.bxlforma.projet_fin.dal.repositories.TerrainRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Collection;

@Service
public class TerrainServiceImpl implements TerrainService {
    private final TerrainRepository terrainRepository;


    public TerrainServiceImpl(TerrainRepository terrainRepository) {
        this.terrainRepository = terrainRepository;
    }

    public ArrayList<TerrainEntity> findAll() {
        return (ArrayList<TerrainEntity>) this.terrainRepository.findAll();
    }

    public Optional<TerrainEntity> findOneById(int id) {
        return this.terrainRepository.findById(id);
    }

    public void insert(TerrainEntity entity) {
        this.terrainRepository.save(entity);
    }
}