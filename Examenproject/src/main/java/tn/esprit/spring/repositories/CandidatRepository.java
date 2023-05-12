package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entities.Candidat;
import tn.esprit.spring.entities.Niveau;

import java.util.List;

public interface CandidatRepository extends JpaRepository<Candidat,Integer> {
    List<Candidat> findCandidatsByNiveauLike(Niveau niveau);
}
