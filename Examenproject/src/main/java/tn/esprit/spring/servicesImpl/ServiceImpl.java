package tn.esprit.spring.servicesImpl;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Candidat;
import tn.esprit.spring.entities.Niveau;
import tn.esprit.spring.entities.Quiz;
import tn.esprit.spring.repositories.CandidatRepository;
import tn.esprit.spring.servicesInterfaces.IIterfaceService;
import tn.esprit.spring.repositories.QuestionRepository;
import tn.esprit.spring.repositories.QuizRepository;
import tn.esprit.spring.repositories.ResponseRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class ServiceImpl implements IIterfaceService {

    QuestionRepository questionRepository;
    QuizRepository quizRepository;
    ResponseRepository responseRepository;
    CandidatRepository candidatRepository;

    @Override
    public Candidat ajouterCandidat(Candidat candidat) {
        if(candidat!=null)
      return   candidatRepository.save(candidat);
        return null;
    }

    @Override
    public Quiz ajouterQuiz(Quiz quiz) {
        if(quiz!=null)
            return   quizRepository.save(quiz);
        return null;
    }

    @Override
    public Quiz affecterQuizCandidat(String titreQuiz, Integer idCandidat) {
        Candidat candidat=candidatRepository.findById(idCandidat).orElse(null);
        if(candidat.equals(null)){
            log.info("candidat reçu is null");
        }
        System.out.println("here");
        Quiz quiz= quizRepository.findQuizByTitreQuiz(titreQuiz).orElse(null);
        //System.out.println("herequiz"+quiz.toString());
     if(quiz!=null){
         quiz.getCandidates().add(candidat);
         candidat.setNbQuiz(candidat.getNbQuiz()+1);
         candidatRepository.save(candidat);
         return  quizRepository.save(quiz);
     }
     return null;

    }

    @Override
    public List<Candidat> recupererCandidat(String specialite, Niveau niveau) {
        List<Candidat>candidats= candidatRepository.findCandidatsByNiveauLike(niveau);
        List<Candidat>candidatList=new ArrayList<>();
        for (Candidat candidat: candidats
             ) {
       candidat.getQuizSet().stream().filter(x->x.getSpecialite().equals(specialite));

        }

        return null;
    }

/*
//@Scheduled(cron = "30 * * * * *")
 /* @Override
    public void recupereQuizplusDifficile() {
    List<Quiz> quizList = quizRepository.findAll();

    quizList.forEach(
            quiz -> {
                log.info("Lequiz le pluq difficile : " + quiz.getQuestions() +
                        " contient : " + quiz.getQuestions().size());
            }
    );
    }*/

}
