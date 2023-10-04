package be.bxlforma.projet_fin.controllers.models;

import be.bxlforma.projet_fin.dal.entities.HoraireEntity;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import lombok.Builder;
import lombok.Setter;
import lombok.Getter;

@Builder
@Setter
@Getter
public class Horaire {

    private Integer id;

    @NotBlank
    @Length(max = 100)
    private String name;

    public static Horaire fromEntity(HoraireEntity entity) {
        Horaire.HoraireBuilder builder = new Horaire.HoraireBuilder()
                .id(entity.getId())
                .name(entity.getName());

        return builder.build();
    }

    public HoraireEntity toEntity() {
        HoraireEntity entity = new HoraireEntity();
        entity.setName(getName());
        return entity;
    }
}