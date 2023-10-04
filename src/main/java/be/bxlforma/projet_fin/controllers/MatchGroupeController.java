package be.bxlforma.projet_fin.controllers;

import be.bxlforma.projet_fin.services.MatchGroupeService;
import be.bxlforma.projet_fin.dal.entities.MatchGroupeEntity;
import be.bxlforma.projet_fin.controllers.models.MatchGroupe;

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
@RequestMapping(path = {"/MatchGroupes"})
public class MatchGroupeController {
    private final MatchGroupeService matchGroupeService;

    public MatchGroupeController(MatchGroupeService matchGroupeService) {
        this.matchGroupeService = matchGroupeService;
    }

    @GetMapping(path = {"", "/"})
    public ResponseEntity<List<MatchGroupe>> getAllAction() {
        Collection<MatchGroupeEntity> response = this.matchGroupeService.findAll();

        List<MatchGroupe> matchGroupeList = response.stream()
                .map(MatchGroupe::fromEntity)
                .toList();

        return ResponseEntity.ok(matchGroupeList);
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<MatchGroupe> getOneAction(
            @PathVariable(name = "id") int id
    ) {
        MatchGroupeEntity entity = this.matchGroupeService.findOneById(id)
                .orElseThrow();

        return ResponseEntity.ok(MatchGroupe.fromEntity(entity));
    }

    @PostMapping(path = {"", "/"})
    public ResponseEntity<MatchGroupe> postMatchGroupeAction(
            @Valid @RequestBody MatchGroupe form
    ) {
        MatchGroupeEntity entity = form.toEntity();

        this.matchGroupeService.insert(entity);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(MatchGroupe.fromEntity(entity));
    }

}