package vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.models.Company;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.models.Job;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.models.JobSkill;

import java.util.List;

public interface JobRepository extends JpaRepository<Job,Long> {

    List<Job> findJobsByCompany(Company company);
    @Query("FROM Job j WHERE j.id IN (SELECT js.job.id FROM CandidateSkill cs JOIN cs.skill s JOIN s.jobSkills js where cs.candidate.id =:canId and js.skillLevel = cs.skillLevel)")
   List<Job> findJobsByCandidate(long canId);

}
