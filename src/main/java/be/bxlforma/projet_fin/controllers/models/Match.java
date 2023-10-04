package be.bxlforma.projet_fin.controllers.models;

import be.bxlforma.projet_fin.dal.entities.MatchEntity;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import lombok.Builder;
import lombok.Setter;
import lombok.Getter;

@Builder
@Setter
@Getter
public class Match {

    private Integer id;

    @NotBlank
    @Length(max = 100)
    private String name;

    public static Match fromEntity(MatchEntity entity) {
        Match.MatchBuilder builder = new Match.MatchBuilder()
                .id(entity.getId())
                .name(entity.getName());

        return builder.build();
    }

    public MatchEntity toEntity() {
        MatchEntity entity = new MatchEntity();
        entity.setName(getName());
        return entity;
    }
}