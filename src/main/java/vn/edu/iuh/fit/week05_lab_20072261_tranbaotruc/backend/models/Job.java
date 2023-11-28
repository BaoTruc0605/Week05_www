package vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id",nullable = false,columnDefinition = "bigint(20)")
    private long id;

    @ManyToOne
    @JoinColumn(name="company")
    private Company company;
    @Column(name = "job_desc",nullable = false,columnDefinition = "varchar(2000)")
    private String desc;
    @Column(name = "job_name",nullable = false,columnDefinition = "varchar(255)")
    private String name;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "job")
    @ToString.Exclude
    private List<JobSkill> jobSkills;

    public Job(Company company, String desc, String name, List<JobSkill> jobSkills) {
        this.company = company;
        this.desc = desc;
        this.name = name;
        this.jobSkills = jobSkills;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", company=" + company +
                ", desc='" + desc + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
