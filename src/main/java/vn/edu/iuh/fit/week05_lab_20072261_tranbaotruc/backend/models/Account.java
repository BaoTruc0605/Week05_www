package vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.models;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.enums.AccountType;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column( nullable = false)
    private String email;
    @Column(name = "password",nullable = false)
    @NonNull
    private String passWord;
    @Column(name = "type")
    @NonNull
    private AccountType accountType;

    public Account(String email, @NonNull String passWord, @NonNull AccountType accountType) {
        this.email = email;
        this.passWord = passWord;
        this.accountType = accountType;
    }
}
