package be.bxlforma.projet_fin.dal.entities;

import be.bxlforma.projet_fin.Accessibility;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity(name = "Match")	// Nom de l'entité Spring
@Table(name = "match")	// Nom de la table en DB
@Data
public class MatchEntity {
	@Id		// Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY)	//Auto-Incrémentée
	private Integer id;
	private Accessibility accessibility;
	@Nullable
	private String password;
	@ManyToOne
	private  TerrainEntity terrain;
	@ManyToOne
	private HoraireEntity horaire;
	@OneToMany(mappedBy = "match",cascade = CascadeType.ALL)
	private Set<MatchTournoiEntity> matchTournois = new HashSet<>();
	@OneToMany(mappedBy = "match",cascade = CascadeType.ALL)
	private Set<MatchGroupeEntity> matchGroupes = new HashSet<>();
}