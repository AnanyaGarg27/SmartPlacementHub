import java.util.ArrayList;

public class PreparationRecommendation {

    public ArrayList<String> generateRecommendations(
            AcademicRecord record,
            ArrayList<Skill> missingSkills,
            double readinessScore) {

        ArrayList<String> recommendations = new ArrayList<>();

        if (record.getCgpa() < 7.0) {
            recommendations.add("Improve your academic performance.");
        }

        if (record.getBacklogs() > 0) {
            recommendations.add("Clear your pending backlogs.");
        }

        for (Skill skill : missingSkills) {
            recommendations.add("Learn and practice " + skill.getSkillName());
        }

        if (readinessScore < 60) {
            recommendations.add("Practice aptitude and coding questions.");
            recommendations.add("Improve communication skills.");
        }

        recommendations.add("Prepare your resume.");
        recommendations.add("Practice mock interviews.");

        if (readinessScore >= 80) {
            recommendations.add("Start applying for placement opportunities.");
        }

        return recommendations;
    }
}
