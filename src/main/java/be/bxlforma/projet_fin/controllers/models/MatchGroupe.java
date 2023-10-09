package be.bxlforma.projet_fin.controllers.models;

import be.bxlforma.projet_fin.dal.entities.GroupeEntity;
import be.bxlforma.projet_fin.dal.entities.MatchEntity;
import be.bxlforma.projet_fin.dal.entities.MatchGroupeEntity;

import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import lombok.Builder;
import lombok.Setter;
import lombok.Getter;
import org.springframework.lang.Nullable;

@Builder
@Setter
@Getter
public class MatchGroupe {

    private Integer id;
    @Nullable
    private Integer score;
    private Match match;
    private Groupe groupe;

    public static MatchGroupe fromEntity(MatchGroupeEntity entity) {
        MatchGroupe.MatchGroupeBuilder builder = new MatchGroupeBuilder()
                .id(entity.getId())
                .score(entity.getScore())
                .match(Match.fromEntity(entity.getMatch()))
                .groupe(Groupe.fromEntity(entity.getGroupe()));

        return builder.build();
    }

    public MatchGroupeEntity toEntity() {
        MatchGroupeEntity entity = new MatchGroupeEntity();
        entity.setScore(getScore());
        entity.setMatch(getMatch().toEntity());
        entity.setGroupe(getGroupe().toEntity());
        return entity;
    }
}