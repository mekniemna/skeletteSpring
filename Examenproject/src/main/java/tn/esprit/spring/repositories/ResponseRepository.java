package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.Response;

@Repository
public interface ResponseRepository extends JpaRepository<Response, Integer> {
}
