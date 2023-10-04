package be.bxlforma.projet_fin.services;

import be.bxlforma.projet_fin.dal.entities.MatchEntity;
import be.bxlforma.projet_fin.dal.repositories.MatchRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Collection;

@Service
public class MatchServiceImpl implements MatchService {
    private final MatchRepository matchRepository;


    public MatchServiceImpl(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public Collection<MatchEntity> findAll() {
        return this.matchRepository.findAll();
    }

    public Optional<MatchEntity> findOneById(int id) {
        return this.matchRepository.findById(id);
    }

    public void insert(MatchEntity entity) {
        this.matchRepository.save(entity);
    }
}