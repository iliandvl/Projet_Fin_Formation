package be.bxlforma.projet_fin.controllers.models;

import be.bxlforma.projet_fin.dal.entities.TerrainEntity;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import lombok.Builder;
import lombok.Setter;
import lombok.Getter;

@Builder
@Setter
@Getter
public class Terrain {

    private Integer id;

    @NotBlank
    @Length(max = 100)
    private String name;

    public static Terrain fromEntity(TerrainEntity entity) {
        Terrain.TerrainBuilder builder = new Terrain.TerrainBuilder()
                .id(entity.getId())
                .name(entity.getName());

        return builder.build();
    }

    public TerrainEntity toEntity() {
        TerrainEntity entity = new TerrainEntity();
        entity.setName(getName());
        return entity;
    }
}