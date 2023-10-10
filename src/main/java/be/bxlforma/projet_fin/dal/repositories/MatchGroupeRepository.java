package be.bxlforma.projet_fin.dal.repositories;

import be.bxlforma.projet_fin.dal.entities.MatchGroupeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MatchGroupeRepository extends JpaRepository<MatchGroupeEntity, Integer> {
    @Query(value = "SELECT mg FROM MatchGroupe mg JOIN mg.groupe g WHERE g.id = :id")
    List<MatchGroupeEntity> findAllByGroup(@Param("id") int groupId);

    @Query(value = "SELECT mg FROM MatchGroupe mg JOIN mg.match m WHERE m.id = :id")
    List<MatchGroupeEntity> findAllByMatch(@Param("id") int matchId);
}