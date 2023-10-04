package be.bxlforma.projet_fin.services;

import be.bxlforma.projet_fin.dal.entities.MatchGroupeEntity;
import be.bxlforma.projet_fin.dal.repositories.MatchGroupeRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Collection;

@Service
public class MatchGroupeServiceImpl implements MatchGroupeService {
    private final MatchGroupeRepository matchGroupeRepository;


    public MatchGroupeServiceImpl(MatchGroupeRepository matchGroupeRepository) {
        this.matchGroupeRepository = matchGroupeRepository;
    }

    public Collection<MatchGroupeEntity> findAll() {
        return this.matchGroupeRepository.findAll();
    }

    public Optional<MatchGroupeEntity> findOneById(int id) {
        return this.matchGroupeRepository.findById(id);
    }

    public void insert(MatchGroupeEntity entity) {
        this.matchGroupeRepository.save(entity);
    }
}