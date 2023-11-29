package vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.fontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.enums.AccountType;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.enums.SkillLevel;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.enums.SkillType;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.models.*;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.repository.JobRepository;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.services.CompanyServices;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.services.JobServices;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.services.SkillServices;

import java.util.ArrayList;
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
    @Autowired
    private CompanyServices companyServices;
    @Autowired
    private SkillServices skillServices;

    @GetMapping("/listJob")
    public String showJobList(Model model) {
        model.addAttribute("jobs", jobServices.findAllNoPaing());
        return "jobs/jobs";
    }

    @GetMapping("/listJobByCompany")
    public String showJobListByCompany(Model model, @RequestParam("id") Long id) {
        model.addAttribute("jobs", jobServices.findJobsByCompany(companyServices.findById(id).get()));
        return "jobs/jobByCompany";
    }

    @GetMapping("/jobs")
    public String showJobListPaging(Model model,
                                    @RequestParam("page") Optional<Integer> page,
                                    @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);
        Page<Job> jobPage = jobServices.findPaginated(
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

    @GetMapping("/insertJob")
    public String insertJob(Model model, @RequestParam("id") Long id) {

        Optional<Company> company = companyServices.findById(id);
        model.addAttribute("company", company.get());
        List<Skill> skills = skillServices.findAll();
        model.addAttribute("skills", skills);
        return "jobs/addJob";
    }

    @PostMapping("/postJob")
    public String login(Model model, RedirectAttributes redirectAttributes, @RequestParam("companyId") long companyId, @RequestParam("name") String name,
                        @RequestParam("desc") String desc, @RequestParam(name = "selectedSkills", required = false) List<String> selectedSkills,
                        @RequestParam(name = "levelSelected", required = false) List<String> levelSelected,
                        @RequestParam(name = "info", required = false) List<String> info) {

        Optional<Company> company = companyServices.findById(companyId);
        List<Skill> skills = new ArrayList<>();
        List<JobSkill> jobSkills = new ArrayList<>();
        Job job = new Job(company.get(), desc, name, null);
        for (int i = 0; i < selectedSkills.size(); i++) {
            String skillId = selectedSkills.get(i);
            String skillLevel = levelSelected.get(Integer.parseInt(skillId)-1);
            String skillInfo = info.get(Integer.parseInt(skillId)-1);
            Skill skill = skillServices.findById(Long.parseLong(skillId)).get();
            JobSkill jobSkill = new JobSkill(job, skillServices.findById(Long.parseLong(skillId)).get(), SkillLevel.valueOf(skillLevel), skillInfo);
            jobSkills.add(jobSkill);
        };
            job.setJobSkills(jobSkills);
            jobServices.addJob(job);


        redirectAttributes.addAttribute("id", companyId);

        return "redirect:/listJobByCompany";
    }
//        return"/home";
}

