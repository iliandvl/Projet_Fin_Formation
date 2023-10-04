package be.bxlforma.projet_fin.controllers.models;

import be.bxlforma.projet_fin.dal.entities.MatchTournoiEntity;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import lombok.Builder;
import lombok.Setter;
import lombok.Getter;

@Builder
@Setter
@Getter
public class MatchTournoi {

    private Integer id;

    @NotBlank
    @Length(max = 100)
    private String name;

    public static MatchTournoi fromEntity(MatchTournoiEntity entity) {
        MatchTournoi.MatchTournoiBuilder builder = new MatchTournoi.MatchTournoiBuilder()
                .id(entity.getId())
                .name(entity.getName());

        return builder.build();
    }

    public MatchTournoiEntity toEntity() {
        MatchTournoiEntity entity = new MatchTournoiEntity();
        entity.setName(getName());
        return entity;
    }
}