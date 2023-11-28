package vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc;

import com.neovisionaries.i18n.CountryCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.models.Address;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.models.Candidate;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.repository.AddressRepository;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.repository.CandidateRepository;

import java.time.LocalDate;
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
    @Bean
    CommandLineRunner initData(){
        return args -> {
            Random rnd =new Random();

//
//            for (int i = 1; i < 1000; i++) {
//                Address add = new Address(CountryCode.VN, rnd.nextInt(70000, 80000) + "", rnd.nextInt(1, 1000) + "", "HCM", "Quang Trung");
//                addressRepository.save(add);

//                 public
//                Candidate(LocalDate dob, Address address, String phone, String email, String fullName, List < CandidateSkill > candidateSkills, List < Experience > experiences)
//                {
//                    this.dob = dob;
//                    this.address = address;
//                    this.phone = phone;
//                    this.email = email;
//                    this.fullName = fullName;
//                    this.candidateSkills = candidateSkills;
//                    this.experiences = experiences;
//                }

//                Candidate can = new Candidate(
//                        LocalDate.of(1998, rnd.nextInt(1, 13), rnd.nextInt(1, 29)),
//                        add,
//                        rnd.nextLong(1111111111L, 9999999999L) + "",
//                        "email_" + i + "@gmail.com", "Name #" + i, null);
//
//                candidateRepository.save(can);
//                System.out.println("Added: " + can);
//            }
        };
    }

}
