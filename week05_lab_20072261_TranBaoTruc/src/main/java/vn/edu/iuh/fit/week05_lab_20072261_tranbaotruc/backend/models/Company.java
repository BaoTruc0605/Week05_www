package vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Setter @Getter  @AllArgsConstructor @ToString @NoArgsConstructor
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

    public Company(long id) {
        this.id = id;
    }
}