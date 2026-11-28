import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static StudentService studentService = new StudentService();
    static CompanyDAO companyDAO = new CompanyDAO();
    static JobPostingDAO jobPostingDAO = new JobPostingDAO();
    static ApplicationService applicationService = new ApplicationService();

    static RecruitmentManager recruitmentManager = new RecruitmentManager();
    static InterviewManager interviewManager = new InterviewManager();

    static InterviewPerformanceAnalyzer performanceAnalyzer =
            new InterviewPerformanceAnalyzer();

    static RecruitmentPatternAnalyzer patternAnalyzer =
            new RecruitmentPatternAnalyzer();

    static PlacementReport placementReport = new PlacementReport();

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== SMART PLACEMENT HUB =====");

            System.out.println("1. Register Student");
            System.out.println("2. View Students");
            System.out.println("3. Add Company");
            System.out.println("4. View Companies");
            System.out.println("5. Add Job Posting");
            System.out.println("6. View Job Postings");
            System.out.println("7. Apply for Job");
            System.out.println("8. Update Application Status");
            System.out.println("9. View Applications");
            System.out.println("10. Add Recruitment Drive");
            System.out.println("11. View Recruitment Drives");
            System.out.println("12. Add Interview Round");
            System.out.println("13. Add Interview Experience");
            System.out.println("14. View Interview Rounds");
            System.out.println("15. View Interview Experiences");
            System.out.println("16. Analyze Interview Performance");
            System.out.println("17. Analyze Recruitment Patterns");
            System.out.println("18. Check Placement Eligibility");
            System.out.println("19. Generate Placement Report");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    registerStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    addCompany();
                    break;

                case 4:
                    companyDAO.displayCompanies();
                    break;

                case 5:
                    addJobPosting();
                    break;

                case 6:
                    jobPostingDAO.displayJobPostings();
                    break;

                case 7:
                    applyForJob();
                    break;

                case 8:
                    updateApplicationStatus();
                    break;

                case 9:
                    applicationService.displayApplications();
                    break;

                case 10:
                    addRecruitmentDrive();
                    break;

                case 11:
                    recruitmentManager.displayAllDrives();
                    break;

                case 12:
                    addInterviewRound();
                    break;

                case 13:
                    addInterviewExperience();
                    break;

                case 14:
                    interviewManager.displayAllRounds();
                    break;

                case 15:
                    interviewManager.displayAllExperiences();
                    break;

                case 16:
                    performanceAnalyzer.displayPerformance(
                        interviewManager.getAllExperiences());
                    break;

                case 17:
                    patternAnalyzer.displayRecruitmentPatterns(
                        recruitmentManager.getAllDrives());
                    break;

                case 18:
                    checkEligibilityAndPredict();
                    break;

                case 19:
                    placementReport.displayReport(
                        recruitmentManager.getAllDrives(),
                        interviewManager.getAllExperiences());
                    break;

                case 0:
                    System.out.println("Thank you for using Smart Placement Hub!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        sc.close();
    }

    // 1. Register Student
    static void registerStudent() {

        System.out.print("Enter Student ID: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();

        Student student = new Student(id, name, email, phone);

        StudentValidator validator = new StudentValidator();

        if (validator.validateStudent(student)) {
            studentService.registerStudent(student);
            System.out.println("Student registered successfully!");
        } else {
            System.out.println("Invalid student details!");
        }
    }

    // 2. View Students
    static void viewStudents() {

        ArrayList<Student> students =
                studentService.displayAllStudents();

        for (Student s : students) {
            System.out.println(s);
        }
    }

    // 3. Add Company
    static void addCompany() {

        System.out.print("Company ID: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("Company Name: ");
        String name = sc.nextLine();

        System.out.print("Location: ");
        String location = sc.nextLine();

        System.out.print("Industry: ");
        String industry = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        Company company =
                new Company(id, name, location, industry, email);

        companyDAO.addCompany(company);

        System.out.println("Company added successfully!");
    }

    // 4. Add Job Posting
    static void addJobPosting() {

        System.out.print("Job ID: ");
        int jobId = Integer.parseInt(sc.nextLine());

        System.out.print("Company ID: ");
        int companyId = Integer.parseInt(sc.nextLine());

        System.out.print("Job Role: ");
        String role = sc.nextLine();

        System.out.print("Salary: ");
        double salary = Double.parseDouble(sc.nextLine());

        System.out.print("Description: ");
        String description = sc.nextLine();

        System.out.print("Deadline: ");
        String deadline = sc.nextLine();

        JobPosting job = new JobPosting(
                jobId, companyId, role,
                salary, description, deadline);

        jobPostingDAO.addJobPosting(job);

        System.out.println("Job added successfully!");
    }

    // 5. Apply for Job
    static void applyForJob() {

        System.out.print("Application ID: ");
        int applicationId = Integer.parseInt(sc.nextLine());

        System.out.print("Student ID: ");
        int studentId = Integer.parseInt(sc.nextLine());

        System.out.print("Job ID: ");
        int jobId = Integer.parseInt(sc.nextLine());

        System.out.print("Application Date: ");
        String date = sc.nextLine();

        Application application =
                new Application(applicationId, studentId, jobId, date);

        applicationService.submitApplication(application);
    }

    // 6. Update Application Status
    static void updateApplicationStatus() {

        System.out.print("Application ID: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("New Status: ");
        String status = sc.nextLine();

        applicationService.updateApplicationStatus(id, status);
    }

    // 7. Add Recruitment Drive
    static void addRecruitmentDrive() {

        System.out.print("Drive ID: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("Company Name: ");
        String company = sc.nextLine();

        System.out.print("Job Role: ");
        String role = sc.nextLine();

        System.out.print("Drive Date: ");
        String date = sc.nextLine();

        RecruitmentDrive drive =
                new RecruitmentDrive(id, company, role, date);

        recruitmentManager.addRecruitmentDrive(drive);
    }

    // 8. Add Interview Round
    static void addInterviewRound() {

        System.out.print("Round ID: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("Company Name: ");
        String company = sc.nextLine();

        System.out.print("Round Name: ");
        String roundName = sc.nextLine();

        InterviewRound round =
                new InterviewRound(id, company, roundName);

        interviewManager.addInterviewRound(round);
    }

    // 9. Add Interview Experience
    static void addInterviewExperience() {

        System.out.print("Experience ID: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("Student ID: ");
        int studentId = Integer.parseInt(sc.nextLine());

        System.out.print("Drive ID: ");
        int driveId = Integer.parseInt(sc.nextLine());

        System.out.print("Feedback: ");
        String feedback = sc.nextLine();

        System.out.print("Result: ");
        String result = sc.nextLine();

        InterviewExperience experience =
                new InterviewExperience(
                    id, studentId, driveId, feedback, result);

        interviewManager.addInterviewExperience(experience);
    }

    // 10. Placement Eligibility and Prediction
    static void checkEligibilityAndPredict() {

        System.out.print("Enter CGPA: ");
        double cgpa = Double.parseDouble(sc.nextLine());

        System.out.print("Enter Branch: ");
        String branch = sc.nextLine();

        System.out.print("Enter Backlogs: ");
        int backlogs = Integer.parseInt(sc.nextLine());

        System.out.print("Minimum CGPA Required: ");
        double minimumCgpa = Double.parseDouble(sc.nextLine());

        System.out.print("Allowed Branches (comma separated): ");
        String[] branches = sc.nextLine().split(",");

        ArrayList<String> allowedBranches = new ArrayList<>();

        for (String b : branches) {
            allowedBranches.add(b.trim());
        }

        System.out.print("Maximum Backlogs Allowed: ");
        int maximumBacklogs = Integer.parseInt(sc.nextLine());

        EligibilityCriteria criteria =
                new EligibilityCriteria(
                    minimumCgpa, allowedBranches, maximumBacklogs);

        EligibilityChecker checker = new EligibilityChecker();

        boolean eligible = checker.checkEligibility(
                cgpa, branch, backlogs, criteria);

        System.out.println(
                "Eligibility: " + (eligible ? "Eligible" : "Not Eligible"));

        System.out.print("Enter Skill Match Percentage: ");
        double skillMatch = Double.parseDouble(sc.nextLine());

        PlacementPredictor predictor = new PlacementPredictor();

        double score =
                predictor.predictPlacement(eligible, skillMatch);

        System.out.println("Placement Prediction Score: " + score + "%");

        System.out.println(
                "Prediction Level: " + predictor.getPrediction(score));
    }
}