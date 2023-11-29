package vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.models.Company;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.models.Job;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.models.JobSkill;

import java.util.List;

public interface JobRepository extends JpaRepository<Job,Long> {

    List<Job> findJobsByCompany(Company company);
    List<Job> findJobsByJobSkills(JobSkill jobSkill);
}
