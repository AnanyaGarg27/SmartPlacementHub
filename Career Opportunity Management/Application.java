
public class Application {
    private int applicationId;
    private int studentId;
    private int jobId;
    private String applicationDate;
    private String status;

    public Application(int applicationId, int studentId,
            int jobId, String applicationDate) {
        this.applicationId = applicationId;
        this.studentId = studentId;
        this.jobId = jobId;
        this.applicationDate = applicationDate;
        this.status = "Pending";
    }

    public int getApplicationId() {
        return applicationId;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getJobId() {
        return jobId;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
