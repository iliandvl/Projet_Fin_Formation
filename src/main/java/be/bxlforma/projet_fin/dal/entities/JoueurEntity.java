package be.bxlforma.projet_fin.dal.entities;

import be.bxlforma.projet_fin.Classement;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Entity(name = "Joueur")	// Nom de l'entité Spring
@Table(name = "joueur")	// Nom de la table en DB
@Data
public class JoueurEntity {
	@Id		// Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY)	//Auto-Incrémentée
	private Integer id;
	private String nom;
	@Nullable
	private String prenom;
	@Nullable
	private Integer age;
	@Nullable
	private Classement classement;
}