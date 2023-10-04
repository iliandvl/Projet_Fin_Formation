package be.bxlforma.projet_fin.dal.repositories;

import be.bxlforma.projet_fin.dal.entities.HoraireEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoraireRepository extends JpaRepository<HoraireEntity, Integer> {
}