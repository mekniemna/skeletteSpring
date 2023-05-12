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
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idQuestion;
    private String libelleQ;
    @Enumerated(EnumType.STRING)
    private Complexite complexite;

    @Override
    public String toString() {
        return "Question{" +
                "idQuestion=" + idQuestion +
                ", libelleQ='" + libelleQ + '\'' +
                ", complexite=" + complexite +
                ", responses=" + responses +
                ", quiz=" + quiz +
                '}';
    }

    @OneToMany(cascade = CascadeType.ALL)
    Set<Response>responses;

    @ManyToOne
    Quiz quiz;


}
