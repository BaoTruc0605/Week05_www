package vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.ids;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.models.Job;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.models.Skill;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class JobSkillID implements Serializable {
    private Job job;
    private Skill skill;

}
