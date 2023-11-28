package vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc;

import com.neovisionaries.i18n.CountryCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.enums.AccountType;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.enums.SkillLevel;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.enums.SkillType;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.models.*;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.repository.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class Week05Lab20072261TranBaoTrucApplication {

    public static void main(String[] args) {
        SpringApplication.run(Week05Lab20072261TranBaoTrucApplication.class, args);
    }
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private JobSkillRepository jobSkillRepository;


    @Bean
    CommandLineRunner initData(){
        return args -> {
            Random rnd =new Random();

//
//            for (int i = 1; i < 1000; i++) {
//                Address add = new Address(CountryCode.VN, rnd.nextInt(70000, 80000) + "", rnd.nextInt(1, 1000) + "", "HCM", "Quang Trung");
//                addressRepository.save(add);
//
//                Account  acc = new Account("email_" + i + "@gmail.com", "abc123", AccountType.CANDIDATE);
//                accountRepository.save(acc);
//
//                Candidate can = new Candidate(
//                        LocalDate.of(1998, rnd.nextInt(1, 13), rnd.nextInt(1, 29)),
//                        add,
//                        rnd.nextLong(1111111111L, 9999999999L) + "",
//                        "email_" + i + "@gmail.com", "Name #" + i, null, acc);
//                candidateRepository.save(can);
//                Account  accCom = new Account("company_" + i + "@gmail.com", "com123", AccountType.COMPANY);
//                accountRepository.save(accCom);
//                Company com = new Company(add, "cong ty "+i , "company name: "+i,"company_" + i + "@gmail.com", rnd.nextLong(1111111111L, 9999999999L)+"","https://company"+i+".com", accCom);
//                companyRepository.save(com);
//
//            }
//            for (long i = 1; i < 5; i++) {
//                Skill skill = new Skill(SkillType.TECHNICAL_SKILL, "Computer Engineer name:" +i, "desc" + i);
//                Job job = new Job(companyRepository.findById(i).get() , "name " + i, "desc: " + i, null);
//                skillRepository.save(skill);
//                jobRepository.save(job);
//            };
//            for (long i = 5; i < 10; i++) {
//                Skill skill = new Skill(SkillType.SOFT_SKILL, "Software name:" +i, "desc" + i);
//                Job job = new Job(companyRepository.findById(i).get() , "name " + i, "desc: " + i, null);
//                skillRepository.save(skill);
//                jobRepository.save(job);
//            };
//            for (long i = 10; i < 25; i++) {
//                Skill skill = new Skill(SkillType.TECHNICAL_SKILL, "Content name:" +i, "desc" + i);
//                Job job = new Job(companyRepository.findById(i).get() , "name " + i, "desc: " + i, null);
//                skillRepository.save(skill);
//                jobRepository.save(job);
//            };
//            for (long i = 1; i < 5; i++) {
//                JobSkill jobSkill = new JobSkill(jobRepository.findById(i).get(),skillRepository.findById(i).get(), SkillLevel.BEGINER,"info "+i);
//                jobRepository.findById(i).get().setJobSkills(List.of(jobSkill));
//                skillRepository.findById(i).get().setJobSkills(List.of(jobSkill));
//                jobSkillRepository.save(jobSkill);
//            };






        };
    }

}
