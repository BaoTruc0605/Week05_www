package vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.models.Account;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.models.JobSkill;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.repository.AccountRepository;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.repository.JobRepository;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.repository.JobSkillRepository;

@Service
public class JobSkillServices {
    @Autowired
    private JobSkillRepository jobSkillRepository;



    public void addAccount(JobSkill jobSkill){
        jobSkillRepository.save(jobSkill);
    }


}
