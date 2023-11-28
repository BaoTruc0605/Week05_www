package vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.models.Account;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.models.Company;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.repository.CompanyRepository;

import java.util.Optional;

@Service
public class CompanyServices {
    @Autowired
    private CompanyRepository companyRepository;



    public void addCompany(Company company){
        companyRepository.save(company);
    }
    public Optional<Company> findByAccount(Account account){
        return companyRepository.findCompaniesByAccount(account);
    }

    public Optional<Company> findById(Long id){
        return companyRepository.findById(id);
    }
}
