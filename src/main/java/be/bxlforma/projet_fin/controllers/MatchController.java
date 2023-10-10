package be.bxlforma.projet_fin.controllers;

import be.bxlforma.projet_fin.controllers.models.MatchTournoi;
import be.bxlforma.projet_fin.dal.entities.MatchGroupeEntity;
import be.bxlforma.projet_fin.dal.entities.MatchTournoiEntity;
import be.bxlforma.projet_fin.services.MatchGroupeService;
import be.bxlforma.projet_fin.services.MatchService;
import be.bxlforma.projet_fin.dal.entities.MatchEntity;
import be.bxlforma.projet_fin.controllers.models.Match;

import be.bxlforma.projet_fin.services.MatchTournoiService;
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
@RequestMapping(path = {"/Matchs"})
public class MatchController {
    private final MatchService matchService;

    private final MatchGroupeService matchGroupeService;

    private final MatchTournoiService matchTournoiService;

    public MatchController(MatchService matchService, MatchGroupeService matchGroupeService, MatchTournoiService matchTournoiService) {

        this.matchService = matchService;
        this.matchGroupeService = matchGroupeService;
        this.matchTournoiService = matchTournoiService;
    }

    @GetMapping(path = {"", "/"})
    public ResponseEntity<List<Match>> getAllAction() {
        Collection<MatchEntity> response = this.matchService.findAll();

        List<Match> matchList = response.stream()
                .map(Match::fromEntity)
                .toList();

        return ResponseEntity.ok(matchList);
    }

    @GetMapping(path= {"/{id}/groupes"})
    public List<MatchGroupeEntity> getGroupAction(
            @PathVariable("id") int id
    ) {

        return this.matchGroupeService.findAllByMatch(id);
    }

    @GetMapping(path= {"/{id}/tournois"})
    public ResponseEntity<List<MatchTournoiEntity>> getTournoiAction(
            @PathVariable("id") int id
    ) {

        return ResponseEntity.ok(this.matchTournoiService.findAllByMatch(id));
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Match> getOneAction(
            @PathVariable(name = "id") int id
    ) {
        MatchEntity entity = this.matchService.findOneById(id)
                .orElseThrow();

        return ResponseEntity.ok(Match.fromEntity(entity));
    }

    @PostMapping(path = {"", "/"})
    public ResponseEntity<Match> postMatchAction(
            @Valid @RequestBody Match form
    ) {
        MatchEntity entity = form.toEntity();

        this.matchService.insert(entity);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Match.fromEntity(entity));
    }

}