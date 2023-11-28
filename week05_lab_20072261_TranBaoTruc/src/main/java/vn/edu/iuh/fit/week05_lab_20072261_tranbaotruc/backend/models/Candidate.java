package vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "candidate")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "can_id",nullable = false,columnDefinition = "bigint(20)")
    private long id;
    @Column(name = "dob", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dob;
    @OneToOne
    @JoinColumn(name = "address", referencedColumnName = "add_id", nullable = false)
    private Address address;
    @Column(nullable = false,columnDefinition = "varchar(15)")
    private String phone;
    @Column(nullable = false,columnDefinition = "varchar(255)")
    private String email;
    @Column(name = "full_name",nullable = false,columnDefinition = "varchar(255)")
    private String fullName;
    @OneToMany(mappedBy = "candidate")
    @ToString.Exclude
    private List<CandidateSkill> candidateSkills;
    @OneToMany(mappedBy = "candidate")
    private List<Experience> experiences;

    public Candidate(long id) {
        this.id = id;
    }

    public Candidate(LocalDate dob, Address address, String phone, String email, String fullName, List<CandidateSkill> candidateSkills) {
        this.dob = dob;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.fullName = fullName;
        this.candidateSkills = candidateSkills;
    }

    public Candidate(LocalDate dob, Address address, String phone, String email, String fullName) {
        this.dob = dob;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "dob=" + dob +
                ", address=" + address +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
