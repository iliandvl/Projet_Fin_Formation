package be.bxlforma.projet_fin.controllers;

import be.bxlforma.projet_fin.services.HoraireService;
import be.bxlforma.projet_fin.dal.entities.HoraireEntity;
import be.bxlforma.projet_fin.controllers.models.Horaire;

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
@RequestMapping(path = {"/Horaires"})
public class HoraireController {
    private final HoraireService horaireService;

    public HoraireController(HoraireService horaireService) {
        this.horaireService = horaireService;
    }

    @GetMapping(path = {"", "/"})
    public ResponseEntity<List<Horaire>> getAllAction() {
        Collection<HoraireEntity> response = this.horaireService.findAll();

        List<Horaire> horaireList = response.stream()
                .map(Horaire::fromEntity)
                .toList();

        return ResponseEntity.ok(horaireList);
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Horaire> getOneAction(
            @PathVariable(name = "id") int id
    ) {
        HoraireEntity entity = this.horaireService.findOneById(id)
                .orElseThrow();

        return ResponseEntity.ok(Horaire.fromEntity(entity));
    }

    @PostMapping(path = {"", "/"})
    public ResponseEntity<Horaire> postHoraireAction(
            @Valid @RequestBody Horaire form
    ) {
        HoraireEntity entity = form.toEntity();

        this.horaireService.insert(entity);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Horaire.fromEntity(entity));
    }

}