package be.bxlforma.projet_fin.dal.repositories;

import be.bxlforma.projet_fin.dal.entities.MatchGroupeEntity;
import be.bxlforma.projet_fin.dal.entities.MatchTournoiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchTournoiRepository extends JpaRepository<MatchTournoiEntity, Integer> {

    @Query(value = "SELECT mt FROM MatchTournoi mt JOIN mt.match m WHERE m.id = :id")
    List<MatchTournoiEntity> findAllByMatch(@Param("id") int matchId);

    @Query(value = "SELECT mt FROM MatchTournoi mt JOIN mt.tournoi t WHERE t.id = :id")
    List<MatchTournoiEntity> findAllByTournoi(@Param("id") int tournoiId);
}