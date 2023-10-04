package be.bxlforma.projet_fin.dal.repositories;

import be.bxlforma.projet_fin.dal.entities.TerrainEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerrainRepository extends JpaRepository<TerrainEntity, Integer> {
}