package be.bxlforma.projet_fin.dal.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity(name = "Horaire")	// Nom de l'entité Spring
@Table(name = "horaire")	// Nom de la table en DB
@Data
public class HoraireEntity {
	@Id		// Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY)	//Auto-Incrémentée
	private Integer id;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
}