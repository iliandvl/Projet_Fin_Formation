package be.bxlforma.projet_fin.services;

import be.bxlforma.projet_fin.dal.entities.MatchGroupeEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Collection;

@Service
public interface MatchGroupeService {
    ArrayList<MatchGroupeEntity> findAll();
    Optional<MatchGroupeEntity> findOneById(int id);

    List<MatchGroupeEntity> findAllByGroup(int id);

    List<MatchGroupeEntity> findAllByMatch(int id);
    void insert(MatchGroupeEntity entity);
}