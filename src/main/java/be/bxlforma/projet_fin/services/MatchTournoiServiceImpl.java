package be.bxlforma.projet_fin.services;

import be.bxlforma.projet_fin.dal.entities.MatchTournoiEntity;
import be.bxlforma.projet_fin.dal.repositories.MatchTournoiRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Collection;

@Service
public class MatchTournoiServiceImpl implements MatchTournoiService {
    private final MatchTournoiRepository matchTournoiRepository;


    public MatchTournoiServiceImpl(MatchTournoiRepository matchTournoiRepository) {
        this.matchTournoiRepository = matchTournoiRepository;
    }

    public Collection<MatchTournoiEntity> findAll() {
        return this.matchTournoiRepository.findAll();
    }

    public Optional<MatchTournoiEntity> findOneById(int id) {
        return this.matchTournoiRepository.findById(id);
    }

    public void insert(MatchTournoiEntity entity) {
        this.matchTournoiRepository.save(entity);
    }
}