package be.bxlforma.projet_fin.services;

import be.bxlforma.projet_fin.dal.entities.GroupeEntity;
import be.bxlforma.projet_fin.dal.repositories.GroupeRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Collection;

@Service
public class GroupeServiceImpl implements GroupeService {
    private final GroupeRepository groupeRepository;


    public GroupeServiceImpl(GroupeRepository groupeRepository) {
        this.groupeRepository = groupeRepository;
    }

    public ArrayList<GroupeEntity> findAll() {
        return (ArrayList<GroupeEntity>) this.groupeRepository.findAll();
    }

    public Optional<GroupeEntity> findOneById(int id) {
        return this.groupeRepository.findById(id);
    }

    public void insert(GroupeEntity entity) {
        this.groupeRepository.save(entity);
    }
}