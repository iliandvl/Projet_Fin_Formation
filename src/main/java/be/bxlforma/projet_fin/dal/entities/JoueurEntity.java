package be.bxlforma.projet_fin.dal.entities;

import be.bxlforma.projet_fin.Classement;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Joueur")	// Nom de l'entité Spring
@Table(name = "joueur")	// Nom de la table en DB
@Getter
@Setter
public class JoueurEntity {
	@Id		// Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY)	//Auto-Incrémentée
	private Integer id;
	private String nom;
	private String prenom;
	private Integer age;
	private Classement classement;
}