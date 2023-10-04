package be.bxlforma.projet_fin.dal.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "MatchTournoi")	// Nom de l'entité Spring
@Table(name = "matchtournoi")	// Nom de la table en DB
@Getter
@Setter
public class MatchTournoiEntity {
	@Id		// Primary Key
	private Integer matchId;
	@Id
	private Integer tournoiId;
	private Integer order;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "match_id")
	private MatchEntity match;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tournoi_id")
	private TournoiEntity tournoi;
}