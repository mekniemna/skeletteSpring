package tn.esprit.spring.controllers;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Candidat;
import tn.esprit.spring.entities.Quiz;
import tn.esprit.spring.servicesInterfaces.IIterfaceService;

import java.time.LocalDate;

@RestController
@RequestMapping("/examenQuiz")
@AllArgsConstructor
public class ExamController {
    IIterfaceService service;

   @PostMapping("/addCandidat")
    public Candidat ajouterCAndidat(@RequestBody Candidat candidat) {
       return service.ajouterCandidat(candidat);
    }

@PostMapping("/addQuiz")
    public Quiz ajouterQUiz(@RequestBody Quiz quiz) {
       return service.ajouterQuiz(quiz);
    }

   @PostMapping("/affecterquizCandidat/{titreQuiz}/{idCandidat}")
    public Quiz affecterQuizCandidat(@PathVariable("titreQuiz") String titreQuiz,@PathVariable("idCandidat")Integer idCandidat) {
       return service.affecterQuizCandidat(titreQuiz, idCandidat);
    }


}
