
public class JobPosting {
    private int jobId;
    private int companyId;
    private String jobRole;
    private double salary;
    private String jobDescription;
    private String deadline;

    public JobPosting(int jobId, int companyId, String jobRole,
            double salary, String jobDescription, String deadline) {
        this.jobId = jobId;
        this.companyId = companyId;
        this.jobRole = jobRole;
        this.salary = salary;
        this.jobDescription = jobDescription;
        this.deadline = deadline;
    }

    public int getJobId() {
        return jobId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public String getJobRole() {
        return jobRole;
    }

    public double getSalary() {
        return salary;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public String getDeadline() {
        return deadline;
    }
}
