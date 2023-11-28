package vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.fontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.models.Job;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.repository.JobRepository;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.services.JobServices;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class JobController {
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private JobServices jobServices;
    @GetMapping("/listJob")
    public String showJobList(Model model) {
        model.addAttribute("jobs", jobServices.findAllNoPaing());
        return "jobs/jobs";
    }
    @GetMapping("/jobs")
    public String showJobListPaging(Model model,
                                          @RequestParam("page") Optional<Integer> page,
                                          @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);
        Page<Job> jobPage= jobServices.findPaginated(
                PageRequest.of(currentPage - 1, pageSize)
        );
        model.addAttribute("jobPage", jobPage);
        int totalPages = jobPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "jobs/jobsPaging";

    }
}
