package vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.models.Account;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.models.Address;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.repository.AccountRepository;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.repository.AddressRepository;

@Service
public class AccountServices {
    @Autowired
    private AccountRepository accountRepository;



    public void addAccount(Account account){
        accountRepository.save(account);
    }

}
