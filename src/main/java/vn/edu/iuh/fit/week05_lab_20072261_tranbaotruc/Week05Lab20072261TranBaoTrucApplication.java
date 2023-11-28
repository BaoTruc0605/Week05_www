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
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.ids.JobSkillID;
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
    CommandLineRunner initData() {
        return args -> {
            Random rnd = new Random();

//
//            for (int i = 1; i < 1000; i++) {
//                Address add = new Address(CountryCode.VN, rnd.nextInt(70000, 80000) + "", rnd.nextInt(1, 1000) + "", "HCM", "Quang Trung");
//                addressRepository.save(add);
//
//                Account acc = new Account("email_" + i + "@gmail.com", "abc123", AccountType.CANDIDATE);
//                accountRepository.save(acc);
//
//                Candidate can = new Candidate(
//                        LocalDate.of(1998, rnd.nextInt(1, 13), rnd.nextInt(1, 29)),
//                        add,
//                        rnd.nextLong(1111111111L, 9999999999L) + "",
//                        "email_" + i + "@gmail.com", "Name #" + i, null, acc);
//                candidateRepository.save(can);
//                Account accCom = new Account("company_" + i + "@gmail.com", "com123", AccountType.COMPANY);
//                accountRepository.save(accCom);
//                Company com = new Company(add, "cong ty " + i, "company name: " + i, "company_" + i + "@gmail.com", rnd.nextLong(1111111111L, 9999999999L) + "", "https://company" + i + ".com", accCom);
//                companyRepository.save(com);
//
//            }
//            Skill skill1 = new Skill(SkillType.TECHNICAL_SKILL, "Computer Engineer", "desc 1 computer");
//            Skill skill2 = new Skill(SkillType.SOFT_SKILL, "SoftWare Develop", "desc 2");
//            Skill skill3 = new Skill(SkillType.UNSPECIFIC, "Maketing", "desc 3");
//            Skill skill4 = new Skill(SkillType.SOFT_SKILL, "Tester", "desc 4");
//            Skill skill5 = new Skill(SkillType.TECHNICAL_SKILL, "Electronic Engineer", "desc 5");
//
//
//            Job job1 = new Job(companyRepository.findById(1l).get(), "name " + 1, "desc: " + 1, null);
//            JobSkill jobSkill1 = new JobSkill(job1, skill1, SkillLevel.BEGINER, "info " + 1);
//            job1.setJobSkills(List.of(jobSkill1));
//            jobRepository.save(job1);
//            skillRepository.save(skill1);
//
//            Job job2 = new Job(companyRepository.findById(2l).get(), "name " + 2, "desc: " + 2, null);
//            JobSkill jobSkill2 = new JobSkill(job2, skill2, SkillLevel.ADVANCED, "info " + 2);
//            job2.setJobSkills(List.of(jobSkill2));
//            jobRepository.save(job2);
//            skillRepository.save(skill2);
//
//            Job job3 = new Job(companyRepository.findById(3l).get(), "name " + 3, "desc: " + 3, null);
//            JobSkill jobSkill3 = new JobSkill(job3, skill3, SkillLevel.PROFESSIONAL, "info " + 3);
//            job3.setJobSkills(List.of(jobSkill3));
//            jobRepository.save(job3);
//            skillRepository.save(skill3);
//
//            Job job4 = new Job(companyRepository.findById(4l).get(), "name " + 4, "desc: " + 4, null);
//            JobSkill jobSkill4 = new JobSkill(job4, skill4, SkillLevel.IMTERMEDIATE, "info " + 4);
//            job4.setJobSkills(List.of(jobSkill4));
//            jobRepository.save(job4);
//            skillRepository.save(skill4);
//
//            Job job5 = new Job(companyRepository.findById(5l).get(), "name " + 5, "desc: " + 5, null);
//            JobSkill jobSkill5= new JobSkill(job5, skill5, SkillLevel.MASTER, "info " + 5);
//            job5.setJobSkills(List.of(jobSkill5));
//            jobRepository.save(job5);
//            skillRepository.save(skill5);

//            for (long i = 4; i < 7; i++) {
//                Job job = new Job(companyRepository.findById(i).get(), "name " + i, "desc: " + i, null);
//                JobSkill jobSkill = new JobSkill(job, skill1, SkillLevel.MASTER, "info " + i);
//                job.setJobSkills(List.of(jobSkill));
//                jobRepository.save(job);
////                skillRepository.save(skill2);
//            }
//            for (long i = 7; i < 9; i++) {
//                Job job = new Job(companyRepository.findById(i).get(), "name " + i, "desc: " + i, null);
//                JobSkill jobSkill = new JobSkill(job, skill1, SkillLevel.ADVANCED, "info " + i);
//                job.setJobSkills(List.of(jobSkill));
//                jobRepository.save(job);
////                skillRepository.save(skill3);
//
//            }
//            for (long i = 9; i < 12; i++) {
//                Job job = new Job(companyRepository.findById(i).get(), "name " + i, "desc: " + i, null);
//                JobSkill jobSkill = new JobSkill(job, skill1, SkillLevel.IMTERMEDIATE, "info " + i);
//                job.setJobSkills(List.of(jobSkill));
//                jobRepository.save(job);
////                skillRepository.save(skill4);
//            }
//            for (long i = 12; i < 15; i++) {
//                Job job = new Job(companyRepository.findById(i).get(), "name " + i, "desc: " + i, null);
//                JobSkill jobSkill = new JobSkill(job, skill1, SkillLevel.PROFESSIONAL, "info " + i);
//                job.setJobSkills(List.of(jobSkill));
//                jobRepository.save(job);
////                skillRepository.save(skill5);
//            }


            //            for (long i = 6; i < 9; i++) {
//                Skill skill = new Skill(SkillType.UNSPECIFIC, "Computer Engineer name:" + i, "desc" + i);
//                Job job = new Job(companyRepository.findById(i).get(), "name " + i, "desc: " + i, null);
//                JobSkill jobSkill = new JobSkill(job, skill, SkillLevel.MASTER, "info " + i);
//                job.setJobSkills(List.of(jobSkill));
//                jobRepository.save(job);
//                skillRepository.save(skill);
//            }
//            for (long i = 9; i < 12; i++) {
//                Skill skill = new Skill(SkillType.SOFT_SKILL, "Computer Engineer name:" + i, "desc" + i);
//                Job job = new Job(companyRepository.findById(i).get(), "name " + i, "desc: " + i, null);
//                JobSkill jobSkill = new JobSkill(job, skill, SkillLevel.PROFESSIONAL, "info " + i);
//                job.setJobSkills(List.of(jobSkill));
//                jobRepository.save(job);
//                skillRepository.save(skill);
//            }
            ;
//            for (long i = 1; i < 10; i++) {
//                Skill skill = new Skill(SkillType.TECHNICAL_SKILL, "Computer Engineer name:" +i, "desc" + i);
//                Job job = new Job(companyRepository.findById(i).get() , "name " + i, "desc: " + i, null);
//                JobSkill jobSkill = new JobSkill(job,skill, SkillLevel.MASTER,"info "+i);
//                job.setJobSkills(List.of(jobSkill));
//                jobRepository.save(job);
//                skillRepository.save(skill);
//
//            };
//            for (long i = 1; i < 10; i++) {
//                Skill skill = new Skill(SkillType.TECHNICAL_SKILL, "Computer Engineer name:" +i, "desc" + i);
//                Job job = new Job(companyRepository.findById(i).get() , "name " + i, "desc: " + i, null);
//                JobSkill jobSkill = new JobSkill(job,skill, SkillLevel.BEGINER,"info "+i);
//                job.setJobSkills(List.of(jobSkill));
//                jobRepository.save(job);
//                skillRepository.save(skill);
//
//            };
//            for (long i = 1; i < 10; i++) {
//                Skill skill = new Skill(SkillType.TECHNICAL_SKILL, "Computer Engineer name:" +i, "desc" + i);
//                Job job = new Job(companyRepository.findById(i).get() , "name " + i, "desc: " + i, null);
//                JobSkill jobSkill = new JobSkill(job,skill, SkillLevel.BEGINER,"info "+i);
//                job.setJobSkills(List.of(jobSkill));
//                jobRepository.save(job);
//                skillRepository.save(skill);
//
//            };
//            for (long i = 5; i < 10; i++) {
//                Skill skill = new Skill(SkillType.SOFT_SKILL, "Software name:" +i, "desc" + i);
//                Job job = new Job(companyRepository.findById(i).get() , "name " + i, "desc: " + i, null);
//                skillRepository.save(skill);
//                jobRepository.save(job);
//            };
//            for (long i = 10; i < 25; i++) {
//                Skill skill = new Skill(SkillType.TECHNICAL_SKILL, "Content name:" +i, "desc" + i);
//                Job job = new Job(companyRepository.findById(i).get() , "name " + i, "desc: " + i, null);1
//                skillRepository.save(skill);
//                jobRepository.save(job);
//            };
//            for (long i = 1; i < 5; i++) {
//                JobSkill jobSkill = new JobSkill(jobRepository.findById(i).get(),skillRepository.findById(i).get(), SkillLevel.BEGINER,"info "+i);
//                jobRepository.findById(i).get().setJobSkills(List.of(jobSkill));
//                skillRepository.findById(i).get().setJobSkills(List.of(jobSkill));
////                jobSkillRepository.save(jobSkill);
//                System.out.println(jobSkill);
//
//            };
//            for (long i = 1; i < 5; i++) {
//                Job job = jobRepository.findById(i).get();
//                Skill skill = skillRepository.findById(i).get();
//                JobSkill jobSkill = new JobSkill(job,skill, SkillLevel.BEGINER,"info "+i);
//                job.setJobSkills(List.of(jobSkill));
//
////                skillRepository.findById(i).get().setJobSkills(List.of(jobSkill));
//                jobSkillRepository.save(jobSkill);
//            };

//                System.out.println(jobRepository.findById(i).get());
//                System.out.println(jobSkillRepository.findById(new JobSkillID( jobRepository.findById(1l).get(), skillRepository.findById(13l).get())).get());
//            JobSkill jobSkill =  new JobSkill(jobRepository.findById(1999l).get(),skillRepository.findById(1999l).get(), SkillLevel.BEGINER,"info "+1);
//            jobSkillRepository.save();
//            Job job = new Job(companyRepository.findById(12l).get() , "name " + 1999, "desc: " + 1999, List.of(jobSkill));
//            Skill skill = new Skill(SkillType.TECHNICAL_SKILL, "Computer Engineer name:" +1999, "desc" + 1999);
//            skill.setJobSkills(List.of(jobSkill));
//            skillRepository.save(skill);
//            jobRepository.save(job);
//            jobSkillRepository.save(jobSkill);

//            };
//            System.out.println("!"+accountRepository.findByEmailAndPassWord("company_3@gmail.com", "com123").getEmail());


        };
    }

}
