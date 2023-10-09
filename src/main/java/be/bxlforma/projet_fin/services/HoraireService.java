package be.bxlforma.projet_fin.services;

import be.bxlforma.projet_fin.dal.entities.HoraireEntity;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Collection;

public interface HoraireService {
    ArrayList<HoraireEntity> findAll();
    Optional<HoraireEntity> findOneById(int id);

    void insert(HoraireEntity entity);
}