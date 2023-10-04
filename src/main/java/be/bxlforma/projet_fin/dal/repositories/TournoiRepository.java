package be.bxlforma.projet_fin.dal.repositories;

import be.bxlforma.projet_fin.dal.entities.TournoiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TournoiRepository extends JpaRepository<TournoiEntity, Integer> {
}