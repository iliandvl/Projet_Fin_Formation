package be.bxlforma.projet_fin.controllers.models;

import be.bxlforma.projet_fin.dal.entities.MatchTournoiEntity;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import lombok.Builder;
import lombok.Setter;
import lombok.Getter;
import org.springframework.lang.Nullable;

@Builder
@Setter
@Getter
public class MatchTournoi {

    private Integer id;
    private Integer order;
    private Match match;
    private Tournoi tournoi;

    public static MatchTournoi fromEntity(MatchTournoiEntity entity) {
        MatchTournoi.MatchTournoiBuilder builder = new MatchTournoiBuilder()
                .id(entity.getId())
                .order(entity.getOrder())
                .match(Match.fromEntity(entity.getMatch()))
                .tournoi(Tournoi.fromEntity(entity.getTournoi()));

        return builder.build();
    }

    public MatchTournoiEntity toEntity() {
        MatchTournoiEntity entity = new MatchTournoiEntity();
        entity.setOrder(getOrder());
        entity.setMatch(getMatch().toEntity());
        entity.setTournoi(getTournoi().toEntity());
        return entity;
    }
}