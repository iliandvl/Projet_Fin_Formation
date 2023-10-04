package be.bxlforma.projet_fin.controllers;

import be.bxlforma.projet_fin.services.MatchTournoiService;
import be.bxlforma.projet_fin.dal.entities.MatchTournoiEntity;
import be.bxlforma.projet_fin.controllers.models.MatchTournoi;

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
@RequestMapping(path = {"/MatchTournois"})
public class MatchTournoiController {
    private final MatchTournoiService matchTournoiService;

    public MatchTournoiController(MatchTournoiService matchTournoiService) {
        this.matchTournoiService = matchTournoiService;
    }

    @GetMapping(path = {"", "/"})
    public ResponseEntity<List<MatchTournoi>> getAllAction() {
        Collection<MatchTournoiEntity> response = this.matchTournoiService.findAll();

        List<MatchTournoi> matchTournoiList = response.stream()
                .map(MatchTournoi::fromEntity)
                .toList();

        return ResponseEntity.ok(matchTournoiList);
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<MatchTournoi> getOneAction(
            @PathVariable(name = "id") int id
    ) {
        MatchTournoiEntity entity = this.matchTournoiService.findOneById(id)
                .orElseThrow();

        return ResponseEntity.ok(MatchTournoi.fromEntity(entity));
    }

    @PostMapping(path = {"", "/"})
    public ResponseEntity<MatchTournoi> postMatchTournoiAction(
            @Valid @RequestBody MatchTournoi form
    ) {
        MatchTournoiEntity entity = form.toEntity();

        this.matchTournoiService.insert(entity);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(MatchTournoi.fromEntity(entity));
    }

}