package be.bxlforma.projet_fin.dal.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "Horaire")	// Nom de l'entité Spring
@Table(name = "horaire")	// Nom de la table en DB
@Getter
@Setter
public class HoraireEntity {
	@Id		// Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY)	//Auto-Incrémentée
	private Integer id;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
}