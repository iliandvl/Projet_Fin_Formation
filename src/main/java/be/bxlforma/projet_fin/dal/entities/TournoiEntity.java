package be.bxlforma.projet_fin.dal.entities;

import be.bxlforma.projet_fin.Accessibility;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

@Entity(name = "Tournoi")	// Nom de l'entité Spring
@Table(name = "tournoi")	// Nom de la table en DB
@Getter
@Setter
public class TournoiEntity {
	@Id		// Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY)	//Auto-Incrémentée
	private Integer id;
	private Accessibility accessibility;
	@Nullable
	private String password;
	@ManyToMany
	private List<GroupeEntity> groupes;
	@OneToMany(mappedBy = "tournoi",cascade = CascadeType.ALL)
	private Set<MatchTournoiEntity> matchTournois = new HashSet<>();
}