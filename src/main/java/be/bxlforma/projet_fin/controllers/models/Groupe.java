package be.bxlforma.projet_fin.controllers.models;

import be.bxlforma.projet_fin.dal.entities.GroupeEntity;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import lombok.Builder;
import lombok.Setter;
import lombok.Getter;

@Builder
@Setter
@Getter
public class Groupe {

    private Integer id;

    @NotBlank
    @Length(max = 100)
    private String name;

    public static Groupe fromEntity(GroupeEntity entity) {
        Groupe.GroupeBuilder builder = new Groupe.GroupeBuilder()
                .id(entity.getId())
                .name(entity.getName());

        return builder.build();
    }

    public GroupeEntity toEntity() {
        GroupeEntity entity = new GroupeEntity();
        entity.setName(getName());
        return entity;
    }
}