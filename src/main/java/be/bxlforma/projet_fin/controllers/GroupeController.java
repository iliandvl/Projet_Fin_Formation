package be.bxlforma.projet_fin.controllers;

import be.bxlforma.projet_fin.dal.entities.MatchGroupeEntity;
import be.bxlforma.projet_fin.dal.repositories.MatchGroupeRepository;
import be.bxlforma.projet_fin.services.GroupeService;
import be.bxlforma.projet_fin.dal.entities.GroupeEntity;
import be.bxlforma.projet_fin.controllers.models.Groupe;

import be.bxlforma.projet_fin.services.MatchGroupeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.annotation.Secured;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Collection;

@RestController
@RequestMapping(path = {"/Groupes"})
public class GroupeController {
    private final GroupeService groupeService;
    private final MatchGroupeService matchGroupeService;

    public GroupeController(GroupeService groupeService, MatchGroupeService matchGroupeService) {
        this.groupeService = groupeService;
        this.matchGroupeService = matchGroupeService;
    }

    @GetMapping()
    public ResponseEntity<List<Groupe>> getAllAction() {
        Collection<GroupeEntity> response = this.groupeService.findAll();

//        List<Groupe> groupeList = response.stream()
//                .map(Groupe::fromEntity)
//                .toList();
//        response.forEach(it -> System.out.println(it.getMatchGroupes().size()));
        List<Groupe> groupeListEntity = response.stream().map(Groupe::fromEntity).toList();

        return ResponseEntity.ok(groupeListEntity);
    }

    @GetMapping(path= {"/{id}/matches"})
    public ResponseEntity<List<MatchGroupeEntity>> getMatchAction(
            @PathVariable("id") int id
    ) {

        return ResponseEntity.ok(this.matchGroupeService.findAllByGroup(id));
    }


    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Groupe> getOneAction(
            @PathVariable(name = "id") int id
    ) {
        GroupeEntity entity = this.groupeService.findOneById(id)
                .orElseThrow();

        return ResponseEntity.ok(Groupe.fromEntity(entity));
    }

    @PostMapping(path = {"", "/"})
    public ResponseEntity<Groupe> postGroupeAction(
            @Valid @RequestBody Groupe form
    ) {
        GroupeEntity entity = form.toEntity();

        this.groupeService.insert(entity);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Groupe.fromEntity(entity));
    }

}