package vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.models;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.ids.CandidateSkillID;

@Setter
@Getter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Entity
@Table(name="candidate_skill")
@IdClass(CandidateSkillID.class)
public class CandidateSkill {
    @Id
    @ManyToOne
    @JoinColumn(name = "can_id")
    private Candidate candidate;
    @Id
    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;
    @Column(name = "skill_level",nullable = false,columnDefinition = "tinyint(4)")
    private int skillLevel;
    @Column(name = "more_infos",nullable = false,columnDefinition = "varchar(1000)")
    private String moreInfo;

    public CandidateSkill(Candidate candidate, Skill skill) {
        this.candidate = candidate;
        this.skill = skill;
    }

}
