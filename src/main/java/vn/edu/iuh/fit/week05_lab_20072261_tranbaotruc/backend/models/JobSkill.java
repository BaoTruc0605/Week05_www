package vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.ids.JobSkillID;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.enums.SkillLevel;

@Setter
@Getter
@Entity
@Table(name = "jobSkill")
@IdClass(JobSkillID.class)
public class JobSkill {
    @Id
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;
    @Id
    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;
    @Column(name = "skill_level",nullable = false,columnDefinition = "tinyint(4)")
    private SkillLevel skillLevel;
    @Column(name = "more_infos",nullable = false,columnDefinition = "varchar(1000)")
    private String moreInfo;

    public JobSkill(Job job) {
        this.job = job;
    }

    public JobSkill(Job job, Skill skill, SkillLevel skillLevel, String moreInfo) {
        this.job = job;
        this.skill = skill;
        this.skillLevel = skillLevel;
        this.moreInfo = moreInfo;
    }

    public JobSkill() {

    }

    @Override
    public String toString() {
        return "JobSkill{" +
                "job=" + job +
                ", skill=" + skill +
                ", skillLevel=" + skillLevel +
                ", moreInfo='" + moreInfo + '\'' +
                '}';
    }
}
