
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

            // Table 1: Recruitment Drive
            st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS recruitment_drive (" +
                "drive_id INT PRIMARY KEY AUTO_INCREMENT, " +
                "company_name VARCHAR(100), " +
                "job_role VARCHAR(100), " +
                "package_lpa DOUBLE, " +
                "drive_date VARCHAR(30))"
            );

            // Table 2: Interview Round
            st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS interview_round (" +
                "round_id INT PRIMARY KEY AUTO_INCREMENT, " +
                "drive_id INT, " +
                "round_name VARCHAR(100), " +
                "round_date VARCHAR(30))"
            );

            // Table 3: Interview Question
            st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS interview_question (" +
                "question_id INT PRIMARY KEY AUTO_INCREMENT, " +
                "round_id INT, " +
                "question_text VARCHAR(500))"
            );

            // Table 4: Interview Experience
            st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS interview_experience (" +
                "experience_id INT PRIMARY KEY AUTO_INCREMENT, " +
                "student_id INT, " +
                "drive_id INT, " +
                "feedback VARCHAR(500), " +
                "result VARCHAR(30))"
            );

            System.out.println("All Tables Created Successfully!");

            con.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}


