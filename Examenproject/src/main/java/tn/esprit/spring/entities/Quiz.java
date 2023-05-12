package tn.esprit.spring.entities;


import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Quiz {
    @Override
    public String toString() {
        return "Quiz{" +
                "idQuiz=" + idQuiz +
                ", titreQuiz='" + titreQuiz + '\'' +
                ", specialite='" + specialite + '\'' +
                ", dateQuiz=" + dateQuiz +
                ", questions=" + questions +
                ", candidates=" + candidates +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idQuiz;
    private String titreQuiz;
    private String specialite;
    private Date dateQuiz;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="quiz")
    Set<Question>questions;
    @ManyToMany(cascade = CascadeType.ALL)
    Set<Candidat>candidates;
}
