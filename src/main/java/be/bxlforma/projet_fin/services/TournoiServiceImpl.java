package be.bxlforma.projet_fin.services;

import be.bxlforma.projet_fin.dal.entities.TournoiEntity;
import be.bxlforma.projet_fin.dal.repositories.TournoiRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Collection;

@Service
public class TournoiServiceImpl implements TournoiService {
    private final TournoiRepository tournoiRepository;


    public TournoiServiceImpl(TournoiRepository tournoiRepository) {
        this.tournoiRepository = tournoiRepository;
    }

    public Collection<TournoiEntity> findAll() {
        return this.tournoiRepository.findAll();
    }

    public Optional<TournoiEntity> findOneById(int id) {
        return this.tournoiRepository.findById(id);
    }

    public void insert(TournoiEntity entity) {
        this.tournoiRepository.save(entity);
    }
}