package be.bxlforma.projet_fin.dal.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Entity(name = "MatchGroupe")	// Nom de l'entité Spring
@Table(name = "matchgroupe")	// Nom de la table en DB
@Data
public class MatchGroupeEntity {
	@Id
	private Integer id;
	@Nullable
	private Integer score;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "match_id")
	private MatchEntity match;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "groupe_id")
	private GroupeEntity groupe;
}