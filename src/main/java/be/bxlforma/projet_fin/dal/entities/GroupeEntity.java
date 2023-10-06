package be.bxlforma.projet_fin.dal.entities;

import be.bxlforma.projet_fin.Accessibility;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "Groupe")	// Nom de l'entité Spring
@Table(name = "groupe")	// Nom de la table en DB
@Getter
@Setter
public class GroupeEntity {
	@Id		// Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY)	//Auto-Incrémentée
	private Integer id;
	private Accessibility accessibility;
	@Nullable
	private String password;
	@ManyToMany
	private List<JoueurEntity> joueurs;
	@OneToMany(mappedBy = "groupe",cascade = CascadeType.ALL)
	private Set<MatchGroupeEntity> matchGroupes = new HashSet<>();
}