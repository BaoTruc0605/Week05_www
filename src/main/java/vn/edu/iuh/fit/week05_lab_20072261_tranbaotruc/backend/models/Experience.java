package vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Entity
@Table(name = "experience")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exp_id", columnDefinition = "bigint(20)")
    private long id;
    @Column(name = "from_date", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fromDate;
    @Column(name = "to_date", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate toDate;

    @ManyToOne
    @JoinColumn(name = "can_id")
    private Candidate candidate;
    @Column(nullable = false,columnDefinition = "varchar(100)")
    private String role;
    @Column(name = "company",nullable = false,columnDefinition = "varchar(120)")
    private String companyName;
    @Column(name = "work_desc",nullable = false,columnDefinition = "varchar(400)")
    private String workDesc;

    public Experience(long id) {
        this.id = id;
    }

}
