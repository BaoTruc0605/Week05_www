package vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.enums.SkillType;

import java.util.List;

@Setter @Getter
@Entity
@Table(name = "skill")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id",columnDefinition = "bigint(20)")
    private long id;
    @Column(name = "skill_type",nullable = false,columnDefinition = "tinyint(4)")
    private SkillType type;
    @Column(name = "skill_name",nullable = false,columnDefinition = "varchar(150)")
    private String skillName;
    @Column(name = "skill_desc",nullable = false,columnDefinition = "varchar(300)")
    private String skillDescription;
    @OneToMany(mappedBy = "skill")
    @ToString.Exclude
    private List<JobSkill> jobSkills;



    public Skill(SkillType type, String skillName, String skillDescription) {
        this.type = type;
        this.skillName = skillName;
        this.skillDescription = skillDescription;
    }

    public Skill() {

    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", type=" + type +
                ", skillName='" + skillName + '\'' +
                ", skillDescription='" + skillDescription + '\'' +
                '}';
    }
}
