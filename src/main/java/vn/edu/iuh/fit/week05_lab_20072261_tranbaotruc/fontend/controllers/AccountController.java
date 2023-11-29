package vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.fontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.enums.AccountType;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.models.Account;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.models.Candidate;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.models.Company;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.repository.AccountRepository;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.services.AccountServices;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.services.CandidateServices;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.services.CompanyServices;

import java.util.Optional;

@Controller
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountServices accountServices;
    @Autowired
    private CandidateServices candidateServices;
    @Autowired
    private CompanyServices companyServices;

    @PostMapping("/login")
    public String login(Model model, @RequestParam("email") String email, @RequestParam("password") String passWord){
        Optional<Account> loginAccount = accountServices.login(email,passWord);
        if(loginAccount.isEmpty()){
            model.addAttribute("loginStatus", false);
        }
        else{
            Optional<Candidate> candidate = Optional.empty();
            Optional<Company> company = Optional.empty();
            if(loginAccount.isPresent() && (loginAccount.get().getAccountType() == AccountType.CANDIDATE)){
                candidate = candidateServices.findByAccount(loginAccount.get());

            } else if(loginAccount.isPresent() && (loginAccount.get().getAccountType() == AccountType.COMPANY)){
                company = companyServices.findByAccount(loginAccount.get());
            }
            model.addAttribute("companyLogin", company);
            model.addAttribute("candidateLogin", candidate);
            model.addAttribute("loginAccount", loginAccount);
            return "/home";
        }
        return "/index";
    }
    @GetMapping("/home")
    public String home(Model model){
        return "/home";
    }

}
