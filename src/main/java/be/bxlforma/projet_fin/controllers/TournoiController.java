package be.bxlforma.projet_fin.controllers;

import be.bxlforma.projet_fin.dal.entities.MatchTournoiEntity;
import be.bxlforma.projet_fin.services.MatchTournoiService;
import be.bxlforma.projet_fin.services.TournoiService;
import be.bxlforma.projet_fin.dal.entities.TournoiEntity;
import be.bxlforma.projet_fin.controllers.models.Tournoi;

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
@RequestMapping(path = {"/Tournois"})
public class TournoiController {
    private final TournoiService tournoiService;
    private final MatchTournoiService matchTournoiService;

    public TournoiController(TournoiService tournoiService, MatchTournoiService matchTournoiService) {
        this.tournoiService = tournoiService;
        this.matchTournoiService = matchTournoiService;
    }

    @GetMapping(path = {"", "/"})
    public ResponseEntity<List<Tournoi>> getAllAction() {
        Collection<TournoiEntity> response = this.tournoiService.findAll();

        List<Tournoi> tournoiList = response.stream()
                .map(Tournoi::fromEntity)
                .toList();

        return ResponseEntity.ok(tournoiList);
    }

    @GetMapping(path= {"/{id}/matchs"})
    public ResponseEntity<List<MatchTournoiEntity>> getMatchAction(
            @PathVariable("id") int id
    ) {

        return ResponseEntity.ok(this.matchTournoiService.findAllByTournoi(id));
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Tournoi> getOneAction(
            @PathVariable(name = "id") int id
    ) {
        TournoiEntity entity = this.tournoiService.findOneById(id)
                .orElseThrow();

        return ResponseEntity.ok(Tournoi.fromEntity(entity));
    }

    @PostMapping(path = {"", "/"})
    public ResponseEntity<Tournoi> postTournoiAction(
            @Valid @RequestBody Tournoi form
    ) {
        TournoiEntity entity = form.toEntity();

        this.tournoiService.insert(entity);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Tournoi.fromEntity(entity));
    }

}