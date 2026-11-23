
public class InterviewExperience {

    private int experienceId;
    private int studentId;
    private int driveId;
    private String feedback;
    private String result;

    public InterviewExperience(int experienceId, int studentId,
                               int driveId, String feedback,
                               String result) {
        this.experienceId = experienceId;
        this.studentId = studentId;
        this.driveId = driveId;
        this.feedback = feedback;
        this.result = result;
    }

    public int getExperienceId() {
        return experienceId;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getDriveId() {
        return driveId;
    }

    public String getFeedback() {
        return feedback;
    }

    public String getResult() {
        return result;
    }

    public void displayExperience() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Feedback: " + feedback);
        System.out.println("Result: " + result);
    }
}

