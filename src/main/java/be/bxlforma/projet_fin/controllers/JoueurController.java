package be.bxlforma.projet_fin.controllers;

import be.bxlforma.projet_fin.services.JoueurService;
import be.bxlforma.projet_fin.dal.entities.JoueurEntity;
import be.bxlforma.projet_fin.controllers.models.Joueur;

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
@RequestMapping(path = {"/Joueurs"})
public class JoueurController {
    private final JoueurService joueurService;

    public JoueurController(JoueurService joueurService) {
        this.joueurService = joueurService;
    }

    @GetMapping(path = {"", "/"})
    public ResponseEntity<List<Joueur>> getAllAction() {
        Collection<JoueurEntity> response = this.joueurService.findAll();

        List<Joueur> joueurList = response.stream()
                .map(Joueur::fromEntity)
                .toList();

        return ResponseEntity.ok(joueurList);
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Joueur> getOneAction(
            @PathVariable(name = "id") int id
    ) {
        JoueurEntity entity = this.joueurService.findOneById(id)
                .orElseThrow();

        return ResponseEntity.ok(Joueur.fromEntity(entity));
    }

    @PostMapping(path = {"", "/"})
    public ResponseEntity<Joueur> postJoueurAction(
            @Valid @RequestBody Joueur form
    ) {
        JoueurEntity entity = form.toEntity();

        this.joueurService.insert(entity);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Joueur.fromEntity(entity));
    }

}