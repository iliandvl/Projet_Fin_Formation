package be.bxlforma.projet_fin.controllers.models;

import be.bxlforma.projet_fin.Classement;
import be.bxlforma.projet_fin.dal.entities.JoueurEntity;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import lombok.Builder;
import lombok.Setter;
import lombok.Getter;
import org.springframework.lang.Nullable;

@Builder
@Setter
@Getter
public class Joueur {

    private Integer id;
    private String nom;
    @Nullable
    private String prenom;
    @Nullable
    private Integer age;
    @Nullable
    private Classement classement;

    public static Joueur fromEntity(JoueurEntity entity) {
        Joueur.JoueurBuilder builder = new Joueur.JoueurBuilder()
                .id(entity.getId())
                .nom(entity.getNom())
                .prenom(entity.getPrenom())
                .age(entity.getAge())
                .classement(entity.getClassement());

        return builder.build();
    }

    public JoueurEntity toEntity() {
        JoueurEntity entity = new JoueurEntity();
        entity.setNom(getNom());
        entity.setPrenom(getPrenom());
        entity.setAge(getAge());
        entity.setClassement(getClassement());
        return entity;
    }
}