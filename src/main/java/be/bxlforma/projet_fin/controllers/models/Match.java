package be.bxlforma.projet_fin.controllers.models;

import be.bxlforma.projet_fin.Accessibility;
import be.bxlforma.projet_fin.dal.entities.*;

import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import lombok.Builder;
import lombok.Setter;
import lombok.Getter;
import org.springframework.lang.Nullable;

import java.util.Set;
import java.util.stream.Collectors;

@Builder
@Setter
@Getter
public class Match {

    private Integer id;
    private Accessibility accessibility;
    @Nullable
    private String password;
    @ManyToOne
    private Terrain terrain;
    @ManyToOne
    private Horaire horaire;
    private Set<MatchTournoi> matchTournois;
    private Set<MatchGroupe> matchGroupes;

    public static Match fromEntity(MatchEntity entity) {
        Match.MatchBuilder builder = new MatchBuilder()
                .id(entity.getId())
                .accessibility(entity.getAccessibility())
                .password(entity.getPassword())
                .terrain(Terrain.fromEntity(entity.getTerrain()))
                .horaire(Horaire.fromEntity(entity.getHoraire()))
                .matchTournois(entity.getMatchTournois().stream().map(MatchTournoi::fromEntity).collect(Collectors.toSet()))
                .matchGroupes(entity.getMatchGroupes().stream().map(MatchGroupe::fromEntity).collect(Collectors.toSet()));

        return builder.build();
    }

    public MatchEntity toEntity() {
        MatchEntity entity = new MatchEntity();
        entity.setAccessibility(getAccessibility());
        entity.setPassword(getPassword());
        entity.setTerrain(getTerrain().toEntity());
        entity.setHoraire(getHoraire().toEntity());
        entity.setMatchTournois(getMatchTournois().stream().map(MatchTournoi::toEntity).collect(Collectors.toSet()));
        entity.setMatchGroupes(getMatchGroupes().stream().map(MatchGroupe::toEntity).collect(Collectors.toSet()));

        return entity;
    }
}