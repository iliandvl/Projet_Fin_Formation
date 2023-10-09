package be.bxlforma.projet_fin.services;

import be.bxlforma.projet_fin.dal.entities.HoraireEntity;
import be.bxlforma.projet_fin.dal.repositories.HoraireRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Collection;

@Service
public class HoraireServiceImpl implements HoraireService {
    private final HoraireRepository horaireRepository;


    public HoraireServiceImpl(HoraireRepository horaireRepository) {
        this.horaireRepository = horaireRepository;
    }

    public ArrayList<HoraireEntity> findAll() {
        return (ArrayList<HoraireEntity>) this.horaireRepository.findAll();
    }

    public Optional<HoraireEntity> findOneById(int id) {
        return this.horaireRepository.findById(id);
    }

    public void insert(HoraireEntity entity) {
        this.horaireRepository.save(entity);
    }
}