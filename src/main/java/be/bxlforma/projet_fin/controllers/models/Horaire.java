package be.bxlforma.projet_fin.controllers.models;

import be.bxlforma.projet_fin.dal.entities.HoraireEntity;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import lombok.Builder;
import lombok.Setter;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Setter
@Getter
public class Horaire {

    private Integer id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public static Horaire fromEntity(HoraireEntity entity) {
        Horaire.HoraireBuilder builder = new HoraireBuilder()
                .id(entity.getId())
                .startTime(entity.getStartTime())
                .endTime(entity.getEndTime());

        return builder.build();
    }

    public HoraireEntity toEntity() {
        HoraireEntity entity = new HoraireEntity();
        entity.setStartTime(getStartTime());
        entity.setEndTime(getEndTime());
        return entity;
    }
}