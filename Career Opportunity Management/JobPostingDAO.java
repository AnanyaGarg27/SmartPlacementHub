
import java.util.ArrayList;

public class JobPostingDAO {

    private ArrayList<JobPosting> jobPostings;

    
    public JobPostingDAO() {
        jobPostings = new ArrayList<>();
    }

    // Add a job posting
    public void addJobPosting(JobPosting job) {
        jobPostings.add(job);
        System.out.println("Job posting added successfully!");
    }

    
    public void displayJobPostings() {

        if (jobPostings.isEmpty()) {
            System.out.println("No job postings found.");
            return;
        }

        for (JobPosting job : jobPostings) {

            System.out.println("Job ID: " + job.getJobId());
            System.out.println("Company ID: " + job.getCompanyId());
            System.out.println("Job Role: " + job.getJobRole());
            System.out.println("Salary: " + job.getSalary());
            System.out.println("Job Description: " + job.getJobDescription());
            System.out.println("Deadline: " + job.getDeadline());

            System.out.println("-------------------------");
        }
    }

   
    public JobPosting getJobById(int jobId) {

        for (JobPosting job : jobPostings) {

            if (job.getJobId() == jobId) {
                return job;
            }
        }

        return null;
    }
}
