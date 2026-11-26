public class ReadinessScoreCalculator {

    public double calculateReadinessScore(
            AcademicRecord record,
            int matchedSkills,
            int totalRequiredSkills) {

        double academicScore = (record.getCgpa() / 10.0) * 40;

        double skillScore = 0;

        if (totalRequiredSkills > 0) {
            skillScore = ((double) matchedSkills /
                    totalRequiredSkills) * 60;
        }

        double penalty = record.getBacklogs() * 5;

        double totalScore = academicScore + skillScore - penalty;

        return Math.max(0, Math.min(100, totalScore));
    }

    public String getReadinessLevel(double score) {

        if (score >= 80) {
            return "Highly Ready";
        } else if (score >= 60) {
            return "Moderately Ready";
        } else if (score >= 40) {
            return "Needs Improvement";
        } else {
            return "Not Ready";
        }
    }
}