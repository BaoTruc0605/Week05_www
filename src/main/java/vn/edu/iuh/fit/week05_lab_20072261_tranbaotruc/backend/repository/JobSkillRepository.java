package vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.ids.JobSkillID;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.models.JobSkill;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.models.Skill;

import java.util.List;

public interface JobSkillRepository extends JpaRepository<JobSkill, JobSkillID> {

    List<JobSkill> findJobSkillBySkill(Skill skill);
}
