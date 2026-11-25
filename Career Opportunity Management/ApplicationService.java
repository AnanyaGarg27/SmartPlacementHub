
import java.util.ArrayList;

public class ApplicationService {

    private ArrayList<Application> applications;

    // Constructor
    public ApplicationService() {
        applications = new ArrayList<>();
    }

    // Submit a new application
    public void submitApplication(Application application) {

        applications.add(application);

        System.out.println("Application submitted successfully!");
    }

    // Update application status
    public void updateApplicationStatus(int applicationId,
            String newStatus) {

        for (Application app : applications) {

            if (app.getApplicationId() == applicationId) {

                app.setStatus(newStatus);

                System.out.println("Application status updated!");
                return;
            }
        }

        System.out.println("Application not found!");
    }

    // Display all applications
    public void displayApplications() {

        if (applications.isEmpty()) {
            System.out.println("No applications found.");
            return;
        }

        for (Application app : applications) {

            System.out.println("Application ID: "
                    + app.getApplicationId());

            System.out.println("Student ID: "
                    + app.getStudentId());

            System.out.println("Job ID: "
                    + app.getJobId());

            System.out.println("Application Date: "
                    + app.getApplicationDate());

            System.out.println("Status: "
                    + app.getStatus());

            System.out.println("-------------------------");
        }
    }
}
