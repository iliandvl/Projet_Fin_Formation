package be.bxlforma.projet_fin.controllers.models;

import be.bxlforma.projet_fin.dal.entities.MatchGroupeEntity;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import lombok.Builder;
import lombok.Setter;
import lombok.Getter;

@Builder
@Setter
@Getter
public class MatchGroupe {

    private Integer id;

    @NotBlank
    @Length(max = 100)
    private String name;

    public static MatchGroupe fromEntity(MatchGroupeEntity entity) {
        MatchGroupe.MatchGroupeBuilder builder = new MatchGroupe.MatchGroupeBuilder()
                .id(entity.getId())
                .name(entity.getName());

        return builder.build();
    }

    public MatchGroupeEntity toEntity() {
        MatchGroupeEntity entity = new MatchGroupeEntity();
        entity.setName(getName());
        return entity;
    }
}