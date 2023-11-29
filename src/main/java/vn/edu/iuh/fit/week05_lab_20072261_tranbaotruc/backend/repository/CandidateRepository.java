package vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.models.Account;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.models.Candidate;

import java.util.Optional;

public interface CandidateRepository extends JpaRepository<Candidate,Long> {
    Optional<Candidate> findCandidateByAccount(Account account);


}
