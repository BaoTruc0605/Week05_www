package vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.models.Account;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.models.Candidate;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.models.Company;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.models.Skill;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.repository.AccountRepository;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.repository.SkillRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SkillServices {
    @Autowired
    private SkillRepository skillRepository;

    public void addAccount(Skill skill){
        skillRepository.save(skill);
    }

    public List<Skill> findAll() {
        return skillRepository.findAll();
    }
    public Optional<Skill> findById(Long id){
        return skillRepository.findById(id);
    }
}
