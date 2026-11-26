
import java.util.ArrayList;

public class SkillDAO {

    ArrayList<Skill> skills = new ArrayList<>();

    // Add Skill
    public boolean addSkill(Skill skill) {
        skills.add(skill);
        return true;
    }

    // Get Skill By ID
    public Skill getSkillById(int skillId) {
        for (Skill skill : skills) {
            if (skill.getSkillId() == skillId) {
                return skill;
            }
        }
        return null;
    }

    // Get All Skills
    public ArrayList<Skill> getAllSkills() {
        return skills;
    }

    // Update Skill
    public boolean updateSkill(Skill skill) {
        for (int i = 0; i < skills.size(); i++) {
            if (skills.get(i).getSkillId() == skill.getSkillId()) {
                skills.set(i, skill);
                return true;
            }
        }
        return false;
    }

    // Delete Skill
    public boolean deleteSkill(int skillId) {
        for (int i = 0; i < skills.size(); i++) {
            if (skills.get(i).getSkillId() == skillId) {
                skills.remove(i);
                return true;
            }
        }
        return false;
    }
}
