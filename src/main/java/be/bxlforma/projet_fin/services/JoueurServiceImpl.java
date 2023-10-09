package be.bxlforma.projet_fin.services;

import be.bxlforma.projet_fin.dal.entities.JoueurEntity;
import be.bxlforma.projet_fin.dal.repositories.JoueurRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Collection;

@Service
public class JoueurServiceImpl implements JoueurService {
    private final JoueurRepository joueurRepository;


    public JoueurServiceImpl(JoueurRepository joueurRepository) {
        this.joueurRepository = joueurRepository;
    }

    public ArrayList<JoueurEntity> findAll() {
        return (ArrayList<JoueurEntity>) this.joueurRepository.findAll();
    }

    public Optional<JoueurEntity> findOneById(int id) {
        return this.joueurRepository.findById(id);
    }

    public void insert(JoueurEntity entity) {
        this.joueurRepository.save(entity);
    }
}