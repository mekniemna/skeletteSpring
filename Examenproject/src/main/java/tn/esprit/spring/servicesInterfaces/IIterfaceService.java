package tn.esprit.spring.servicesInterfaces;

import tn.esprit.spring.entities.Candidat;
import tn.esprit.spring.entities.Niveau;
import tn.esprit.spring.entities.Quiz;

import java.time.LocalDate;
import java.util.List;

public interface IIterfaceService {

   Candidat ajouterCandidat(Candidat candidat);


     Quiz ajouterQuiz (Quiz quiz);
     Quiz affecterQuizCandidat(String titreQuiz, Integer idCandidat);

      List<Candidat> recupererCandidat(String specialite, Niveau niveau);

     /* public void recupereQuizplusDifficile();*/



}
