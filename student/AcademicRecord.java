
public class AcademicRecord {

    private int studentId;
    private double cgpa;
    private String branch;
    private int semester;
    private int backlogs;

    public AcademicRecord(int studentId, double cgpa, String branch, int semester, int backlogs) {
        this.studentId = studentId;
        this.cgpa = cgpa;
        this.branch = branch;
        this.semester = semester;
        this.backlogs = backlogs;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getBacklogs() {
        return backlogs;
    }

    public void setBacklogs(int backlogs) {
        this.backlogs = backlogs;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentId
                + ", CGPA: " + cgpa
                + ", Branch: " + branch
                + ", Semester: " + semester
                + ", Backlogs: " + backlogs;
    }
}
