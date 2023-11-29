package vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.models.Company;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.models.Job;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.models.JobSkill;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.repository.JobRepository;

import java.util.Collections;
import java.util.List;

@Service
public class JobServices {
    @Autowired
    private JobRepository jobRepository;



    public void addJob(Job job){
        jobRepository.save(job);
    }

    public List<Job> findAllNoPaing() {
        return jobRepository.findAll();
    }
    public List<Job> findJobsByCompany(Company company) {
        return jobRepository.findJobsByCompany(company);
    }

    public  List<Job> findJobsByCandidate(long canId){
        return jobRepository.findJobsByCandidate(canId);
    }


    public Page<Job> findAll(int pageNumber, int pageSize, String sortBy, String sortDirection) {

        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return jobRepository.findAll(pageable);
    }

    public Page<Job> findPaginated(Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Job> list;
        List<Job> jobs = jobRepository.findAll();
        if (jobs.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, jobs.size());
            list = jobs.subList(startItem, toIndex);
        }
        Page<Job> jobPage
                = new PageImpl<>(list, PageRequest.of(currentPage, pageSize),
                jobs.size());
        return jobPage;
    }



}
