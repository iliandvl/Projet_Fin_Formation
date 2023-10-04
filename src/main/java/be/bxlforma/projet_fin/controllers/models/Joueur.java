package be.bxlforma.projet_fin.controllers.models;

import be.bxlforma.projet_fin.dal.entities.JoueurEntity;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import lombok.Builder;
import lombok.Setter;
import lombok.Getter;

@Builder
@Setter
@Getter
public class Joueur {

    private Integer id;

    @NotBlank
    @Length(max = 100)
    private String name;

    public static Joueur fromEntity(JoueurEntity entity) {
        Joueur.JoueurBuilder builder = new Joueur.JoueurBuilder()
                .id(entity.getId())
                .name(entity.getName());

        return builder.build();
    }

    public JoueurEntity toEntity() {
        JoueurEntity entity = new JoueurEntity();
        entity.setName(getName());
        return entity;
    }
}