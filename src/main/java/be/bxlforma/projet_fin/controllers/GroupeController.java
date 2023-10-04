package be.bxlforma.projet_fin.controllers;

import be.bxlforma.projet_fin.services.GroupeService;
import be.bxlforma.projet_fin.dal.entities.GroupeEntity;
import be.bxlforma.projet_fin.controllers.models.Groupe;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.annotation.Secured;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Collection;

@RestController
@RequestMapping(path = {"/Groupes"})
public class GroupeController {
    private final GroupeService groupeService;

    public GroupeController(GroupeService groupeService) {
        this.groupeService = groupeService;
    }

    @GetMapping(path = {"", "/"})
    public ResponseEntity<List<Groupe>> getAllAction() {
        Collection<GroupeEntity> response = this.groupeService.findAll();

        List<Groupe> groupeList = response.stream()
                .map(Groupe::fromEntity)
                .toList();

        return ResponseEntity.ok(groupeList);
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