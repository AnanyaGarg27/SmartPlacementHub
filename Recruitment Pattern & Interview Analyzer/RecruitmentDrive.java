public class RecruitmentDrive {

    private int driveId;
    private String companyName;
    private String jobRole;
    private String driveDate;

    public RecruitmentDrive(int driveId, String companyName,
                            String jobRole, String driveDate) {

        this.driveId = driveId;
        this.companyName = companyName;
        this.jobRole = jobRole;
        this.driveDate = driveDate;
    }

    public int getDriveId() {
        return driveId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getJobRole() {
        return jobRole;
    }

    public String getDriveDate() {
        return driveDate;
    }

    public void displayDrive() {
        System.out.println("Drive ID: " + driveId);
        System.out.println("Company: " + companyName);
        System.out.println("Job Role: " + jobRole);
        System.out.println("Date: " + driveDate);
    }
}
