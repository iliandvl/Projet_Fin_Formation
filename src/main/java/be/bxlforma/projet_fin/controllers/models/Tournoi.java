package be.bxlforma.projet_fin.controllers.models;

import be.bxlforma.projet_fin.Accessibility;
import be.bxlforma.projet_fin.dal.entities.GroupeEntity;
import be.bxlforma.projet_fin.dal.entities.MatchTournoiEntity;
import be.bxlforma.projet_fin.dal.entities.TournoiEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import lombok.Builder;
import lombok.Setter;
import lombok.Getter;
import org.springframework.lang.Nullable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Builder
@Setter
@Getter
public class Tournoi {

    private Integer id;
    private Accessibility accessibility;
    @Nullable
    private String password;
    private List<Groupe> groupes;
    private Set<MatchTournoi> matchTournois;

    public static Tournoi fromEntity(TournoiEntity entity) {
        Tournoi.TournoiBuilder builder = new TournoiBuilder()
                .id(entity.getId())
                .accessibility(entity.getAccessibility())
                .password(entity.getPassword())
                .groupes(entity.getGroupes().stream().map(Groupe::fromEntity).toList());

        return builder.build();
    }

    public TournoiEntity toEntity() {
        TournoiEntity entity = new TournoiEntity();
        entity.setAccessibility(getAccessibility());
        entity.setPassword(getPassword());
        entity.setGroupes(getGroupes().stream().map(Groupe::toEntity).toList());
        return entity;
    }
}