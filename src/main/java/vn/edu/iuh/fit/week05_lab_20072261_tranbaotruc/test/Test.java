package vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.services.AddressServices;

@SpringBootApplication
public class Test implements CommandLineRunner {
    @Autowired
    private  AddressServices addressServices ;
    public static void main(String[] args) {
        SpringApplication.run(Test.class,args);
    }
    @Override
    public void run(String... args) throws Exception {

//        Address address = new Address(1,Coun,"1812","155/8", "Ho Chi Minh", "Nguyen Thai Son, Go Vap", null,null);
//        addressServices.addAddress(address);

        //        candidateRepository.save()
//        for(int i=0; i<10; i++){
//            Candidate candidate = new Candidate(i+1, LocalDate.of(2002,05,06),address,"033803054"+i,"user"+i+"@gmail.com", "User "+i,);
//        }
    }
}
