package vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.models.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate,Long> {


}
