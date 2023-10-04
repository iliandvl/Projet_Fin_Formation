package be.bxlforma.projet_fin.controllers;

import be.bxlforma.projet_fin.services.TerrainService;
import be.bxlforma.projet_fin.dal.entities.TerrainEntity;
import be.bxlforma.projet_fin.controllers.models.Terrain;

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
@RequestMapping(path = {"/Terrains"})
public class TerrainController {
    private final TerrainService terrainService;

    public TerrainController(TerrainService terrainService) {
        this.terrainService = terrainService;
    }

    @GetMapping(path = {"", "/"})
    public ResponseEntity<List<Terrain>> getAllAction() {
        Collection<TerrainEntity> response = this.terrainService.findAll();

        List<Terrain> terrainList = response.stream()
                .map(Terrain::fromEntity)
                .toList();

        return ResponseEntity.ok(terrainList);
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Terrain> getOneAction(
            @PathVariable(name = "id") int id
    ) {
        TerrainEntity entity = this.terrainService.findOneById(id)
                .orElseThrow();

        return ResponseEntity.ok(Terrain.fromEntity(entity));
    }

    @PostMapping(path = {"", "/"})
    public ResponseEntity<Terrain> postTerrainAction(
            @Valid @RequestBody Terrain form
    ) {
        TerrainEntity entity = form.toEntity();

        this.terrainService.insert(entity);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Terrain.fromEntity(entity));
    }

}