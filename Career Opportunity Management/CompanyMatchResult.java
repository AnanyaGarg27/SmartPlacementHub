
public class CompanyMatchResult {

    private int studentId;
    private int companyId;
    private int jobId;
    private double matchScore;
    private String matchStatus;

    // Constructor
    public CompanyMatchResult(int studentId, int companyId,
            int jobId, double matchScore, String matchStatus) {

        this.studentId = studentId;
        this.companyId = companyId;
        this.jobId = jobId;
        this.matchScore = matchScore;
        this.matchStatus = matchStatus;
    }

    // Getter methods
    public int getStudentId() {
        return studentId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public int getJobId() {
        return jobId;
    }

    public double getMatchScore() {
        return matchScore;
    }

    public String getMatchStatus() {
        return matchStatus;
    }

    // Display matching result
    public void displayResult() {

        System.out.println("Student ID: " + studentId);
        System.out.println("Company ID: " + companyId);
        System.out.println("Job ID: " + jobId);
        System.out.println("Match Score: " + matchScore + "%");
        System.out.println("Match Status: " + matchStatus);
    }
}
