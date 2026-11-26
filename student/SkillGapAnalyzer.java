import java.util.ArrayList;

public class SkillGapAnalyzer {

    public ArrayList<Skill> findMissingSkills(
            ArrayList<Skill> requiredSkills,
            ArrayList<StudentSkill> studentSkills,
            int studentId) {

        ArrayList<Skill> missingSkills = new ArrayList<>();

        for (Skill required : requiredSkills) {

            boolean found = false;

            for (StudentSkill skill : studentSkills) {

                if (skill.getStudentId() == studentId &&
                    skill.getSkillId() == required.getSkillId()) {

                    found = true;
                    break;
                }
            }

            if (!found) {
                missingSkills.add(required);
            }
        }

        return missingSkills;
    }
}