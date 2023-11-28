package vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.models.Account;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.repository.AccountRepository;

import java.util.Optional;

@Service
public class AccountServices {
    @Autowired
    private AccountRepository accountRepository;


    public void addAccount(Account account) {
        accountRepository.save(account);
    }

    public Optional<Account> login(String email, String passWord) {
        return accountRepository.findByEmailAndPassWord(email,passWord);
    }

}
