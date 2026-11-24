
package student;

public class StudentSkill {

    private int studentId;
    private int skillId;
    private String proficiencyLevel;

    public StudentSkill(int studentId, int skillId,
                        String proficiencyLevel) {
        this.studentId = studentId;
        this.skillId = skillId;
        this.proficiencyLevel = proficiencyLevel;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public String getProficiencyLevel() {
        return proficiencyLevel;
    }

    public void setProficiencyLevel(String proficiencyLevel) {
        this.proficiencyLevel = proficiencyLevel;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentId
                + ", Skill ID: " + skillId
                + ", Proficiency Level: " + proficiencyLevel;
    }
}
