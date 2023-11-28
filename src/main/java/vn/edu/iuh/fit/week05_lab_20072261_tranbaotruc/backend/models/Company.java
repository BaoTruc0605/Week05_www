package vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Setter @Getter  @AllArgsConstructor  @NoArgsConstructor
@Entity
@Table(name="company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "com_id", columnDefinition = "bigint(20)")
    private long id;
    @OneToOne
    @JoinColumn(name = "address", referencedColumnName = "add_id", nullable = false)
    private Address address;
    @Column(nullable = false,columnDefinition = "varchar(2000)")
    private String about;
    @Column(name = "comp_name",nullable = false,columnDefinition = "varchar(255)")
    private String name;
    @Column(nullable = false,columnDefinition = "varchar(255)")
    private String email;
    @Column(nullable = false,columnDefinition = "varchar(255)")
    private String phone;
    @Column(name = "web_url",nullable = false,columnDefinition = "varchar(255)")
    private String webURL;
    @OneToMany(mappedBy = "company")
    @ToString.Exclude
    private List<Job> jobs;
    @OneToOne
    @JoinColumn(name = "acc_id", nullable = false)
    @NonNull
    private Account account;


    public Company(long id) {
        this.id = id;
    }

    public Company(Address address, String about, String name, String email, String phone, String webURL, List<Job> jobs, @NonNull Account account) {
        this.address = address;
        this.about = about;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.webURL = webURL;
        this.jobs = jobs;
        this.account = account;
    }
    public Company(Address address, String about, String name, String email, String phone, String webURL, @NonNull Account account) {
        this.address = address;
        this.about = about;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.webURL = webURL;

        this.account = account;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", about='" + about + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", webURL='" + webURL + '\'' +
                '}';
    }
}