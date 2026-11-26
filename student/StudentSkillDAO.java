
import java.util.ArrayList;

public class StudentSkillDAO {

    ArrayList<StudentSkill> skills = new ArrayList<>();

    // Add Student Skill
    public boolean addStudentSkill(StudentSkill skill) {

        skills.add(skill);

        return true;
    }

    // Get Student Skills
    public ArrayList<StudentSkill> getStudentSkills(int studentId) {

        ArrayList<StudentSkill> result = new ArrayList<>();

        for (StudentSkill skill : skills) {

            if (skill.getStudentId() == studentId) {
                result.add(skill);
            }
        }

        return result;
    }

    // Update Student Skill
    public boolean updateStudentSkill(StudentSkill skill) {

        for (int i = 0; i < skills.size(); i++) {

            if (skills.get(i).getStudentId() == skill.getStudentId()
                    && skills.get(i).getSkillId() == skill.getSkillId()) {

                skills.set(i, skill);
                return true;
            }
        }

        return false;
    }

    // Delete Student Skill
    public boolean deleteStudentSkill(int studentId, int skillId) {

        for (int i = 0; i < skills.size(); i++) {

            if (skills.get(i).getStudentId() == studentId
                    && skills.get(i).getSkillId() == skillId) {

                skills.remove(i);
                return true;
            }
        }

        return false;
    }
}
```
