package be.bxlforma.projet_fin.controllers.models;

import be.bxlforma.projet_fin.Accessibility;
import be.bxlforma.projet_fin.dal.entities.GroupeEntity;

import be.bxlforma.projet_fin.dal.entities.MatchGroupeEntity;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import lombok.Builder;
import lombok.Setter;
import lombok.Getter;
import org.springframework.lang.Nullable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Builder
@Setter
@Getter
public class Groupe {

    private Integer id;
    private Accessibility accessibility;
    @Nullable
    private String password;
    private List<Joueur> joueurs;
    private Set<MatchGroupe> matchGroupes;

    public static Groupe fromEntity(GroupeEntity entity) {
        Groupe.GroupeBuilder builder = new GroupeBuilder()
                .id(entity.getId())
                .accessibility(entity.getAccessibility())
                .password(entity.getPassword())
                .joueurs(entity.getJoueurs().stream().map(Joueur::fromEntity).toList());

        return builder.build();
    }

    public GroupeEntity toEntity() {
        GroupeEntity entity = new GroupeEntity();
        entity.setAccessibility(getAccessibility());
        entity.setPassword(getPassword());
        entity.setJoueurs(getJoueurs().stream().map(Joueur::toEntity).toList());
//        entity.setMatchGroupes(getMatchGroupes().stream().map(MatchGroupe::toEntity).collect(Collectors.toSet()));
        return entity;
    }
}