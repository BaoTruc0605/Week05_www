package vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.models.Candidate;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.repository.CandidateRepository;

import java.util.Collections;
import java.util.List;

@Service
public class CandidateServices {
    @Autowired
    private CandidateRepository candidateRepository;

    public void addCandidate(Candidate candidate) {
        candidateRepository.save(candidate);
    }

    //Lấy dữ liệu candidate không phân trang
    public List<Candidate> findAllNoPaing() {
        return candidateRepository.findAll();
    }

    public Page<Candidate> findAll(int pageNumber, int pageSize, String sortBy, String sortDirection) {

        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return candidateRepository.findAll(pageable);
    }

    public Page<Candidate> findPaginated(Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Candidate> list;
        List<Candidate> candidates = candidateRepository.findAll();
        if (candidates.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, candidates.size());
            list = candidates.subList(startItem, toIndex);
        }
        Page<Candidate> candidatePage
                = new PageImpl<>(list, PageRequest.of(currentPage, pageSize),
                candidates.size());
        return candidatePage;
    }
}
