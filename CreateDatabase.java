
import java.sql.*;

public class CreateDatabase {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/";
        String username = "root";
        String password = "123456";

        try {
            // Connect to MySQL
            Connection con = DriverManager.getConnection(
                url, username, password
            );

            System.out.println("MySQL Connected Successfully!");

            Statement st = con.createStatement();

            // Create database
            st.executeUpdate(
                "CREATE DATABASE IF NOT EXISTS SmartPlacementHub"
            );

            System.out.println("Database Created Successfully!");

            // Select database
            st.executeUpdate("USE SmartPlacementHub");


            // =====================================
            // MEMBER 1 - STUDENT MANAGEMENT
            // =====================================

            // Table 1: Students
            st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS students (" +
                "student_id INT PRIMARY KEY, " +
                "name VARCHAR(100), " +
                "email VARCHAR(100), " +
                "phone VARCHAR(20))"
            );

            // Table 2: Academic Records
            st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS academic_records (" +
                "student_id INT PRIMARY KEY, " +
                "cgpa DOUBLE, " +
                "branch VARCHAR(100), " +
                "semester INT, " +
                "backlogs INT, " +
                "FOREIGN KEY (student_id) REFERENCES students(student_id))"
            );

            // Table 3: Skills
            st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS skills (" +
                "skill_id INT PRIMARY KEY, " +
                "skill_name VARCHAR(100))"
            );

            // Table 4: Student Skills
            st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS student_skills (" +
                "student_id INT, " +
                "skill_id INT, " +
                "proficiency_level VARCHAR(50), " +
                "PRIMARY KEY (student_id, skill_id), " +
                "FOREIGN KEY (student_id) REFERENCES students(student_id), " +
                "FOREIGN KEY (skill_id) REFERENCES skills(skill_id))"
            );


            // =====================================
            // MEMBER 2 - COMPANY AND PLACEMENT
            // =====================================

            // Table 5: Companies
            st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS companies (" +
                "company_id INT PRIMARY KEY, " +
                "company_name VARCHAR(100), " +
                "location VARCHAR(100), " +
                "industry VARCHAR(100), " +
                "email VARCHAR(100))"
            );

            // Table 6: Job Postings
            st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS job_postings (" +
                "job_id INT PRIMARY KEY, " +
                "company_id INT, " +
                "job_role VARCHAR(100), " +
                "salary DOUBLE, " +
                "job_description TEXT, " +
                "deadline VARCHAR(30), " +
                "FOREIGN KEY (company_id) REFERENCES companies(company_id))"
            );

            // Table 7: Eligibility Criteria
            st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS eligibility_criteria (" +
                "job_id INT PRIMARY KEY, " +
                "minimum_cgpa DOUBLE, " +
                "allowed_branches TEXT, " +
                "maximum_backlogs INT, " +
                "FOREIGN KEY (job_id) REFERENCES job_postings(job_id))"
            );

            // Table 8: Applications
            st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS applications (" +
                "application_id INT PRIMARY KEY, " +
                "student_id INT, " +
                "job_id INT, " +
                "application_date VARCHAR(30), " +
                "status VARCHAR(50), " +
                "FOREIGN KEY (student_id) REFERENCES students(student_id), " +
                "FOREIGN KEY (job_id) REFERENCES job_postings(job_id))"
            );


            // =====================================
            // MEMBER 3 - RECRUITMENT AND INTERVIEW
            // =====================================

            // Table 9: Recruitment Drive
            st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS recruitment_drive (" +
                "drive_id INT PRIMARY KEY AUTO_INCREMENT, " +
                "company_name VARCHAR(100), " +
                "job_role VARCHAR(100), " +
                "package_lpa DOUBLE, " +
                "drive_date VARCHAR(30))"
            );

            // Table 10: Interview Round
            st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS interview_round (" +
                "round_id INT PRIMARY KEY, " +
                "company_name VARCHAR(100), " +
                "round_name VARCHAR(100))"
            );

            // Table 11: Interview Question
            st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS interview_question (" +
                "question_id INT PRIMARY KEY AUTO_INCREMENT, " +
                "round_id INT, " +
                "question_text VARCHAR(500), " +
                "FOREIGN KEY (round_id) REFERENCES interview_round(round_id))"
            );

            // Table 12: Interview Experience
            st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS interview_experience (" +
                "experience_id INT PRIMARY KEY AUTO_INCREMENT, " +
                "student_id INT, " +
                "drive_id INT, " +
                "feedback VARCHAR(500), " +
                "result VARCHAR(30), " +
                "FOREIGN KEY (student_id) REFERENCES students(student_id), " +
                "FOREIGN KEY (drive_id) REFERENCES recruitment_drive(drive_id))"
            );


            System.out.println("\n==================================");
            System.out.println("ALL 12 TABLES CREATED SUCCESSFULLY!");
            System.out.println("==================================");

            st.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}
