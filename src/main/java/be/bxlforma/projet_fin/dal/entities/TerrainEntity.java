package be.bxlforma.projet_fin.dal.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Terrain")	// Nom de l'entité Spring
@Table(name = "terrain")	// Nom de la table en DB
@Data
public class TerrainEntity {
	@Id		// Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY)	//Auto-Incrémentée
	private Integer numero;
}