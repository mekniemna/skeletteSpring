package tn.esprit.spring.entities;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Candidat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCandidat;
    private String nom;
    private String prenom;
    private Integer nbQuiz;
    @Enumerated(EnumType.STRING)
    private Niveau niveau;

    @Override
    public String toString() {
        return "Candidat{" +
                "idCandidat=" + idCandidat +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", nbQuiz=" + nbQuiz +
                ", niveau=" + niveau +
                ", quizSet=" + quizSet +
                '}';
    }

    @ManyToMany(mappedBy="candidates", cascade = CascadeType.ALL)
    Set<Quiz> quizSet;
}
