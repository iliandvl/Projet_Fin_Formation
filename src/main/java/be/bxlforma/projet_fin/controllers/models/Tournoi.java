package be.bxlforma.projet_fin.controllers.models;

import be.bxlforma.projet_fin.dal.entities.TournoiEntity;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import lombok.Builder;
import lombok.Setter;
import lombok.Getter;

@Builder
@Setter
@Getter
public class Tournoi {

    private Integer id;

    @NotBlank
    @Length(max = 100)
    private String name;

    public static Tournoi fromEntity(TournoiEntity entity) {
        Tournoi.TournoiBuilder builder = new Tournoi.TournoiBuilder()
                .id(entity.getId())
                .accessibility(entity.getAccessibility());

        return builder.build();
    }

    public TournoiEntity toEntity() {
        TournoiEntity entity = new TournoiEntity();
        entity.setName(getName());
        return entity;
    }
}