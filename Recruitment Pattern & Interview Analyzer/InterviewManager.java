
import java.sql.*;
import java.util.ArrayList;

public class InterviewManager {

    String url = "jdbc:mysql://localhost:3306/SmartPlacementHub";
    String username = "root";
    String password = "YOUR_PASSWORD";

    // Add Interview Round
    public void addInterviewRound(InterviewRound round) {

        String sql = "INSERT INTO interview_round "
                + "(round_id, company_name, round_name) VALUES (?, ?, ?)";

        try {
            Connection con = DriverManager.getConnection(url, username, password);

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, round.getRoundId());
            ps.setString(2, round.getCompanyName());
            ps.setString(3, round.getRoundName());

            ps.executeUpdate();

            System.out.println("Interview Round Added Successfully!");

            ps.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Add Interview Experience
    public void addInterviewExperience(InterviewExperience experience) {

        String sql = "INSERT INTO interview_experience "
                + "(experience_id, student_id, drive_id, feedback, result) "
                + "VALUES (?, ?, ?, ?, ?)";

        try {
            Connection con = DriverManager.getConnection(url, username, password);

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, experience.getExperienceId());
            ps.setInt(2, experience.getStudentId());
            ps.setInt(3, experience.getDriveId());
            ps.setString(4, experience.getFeedback());
            ps.setString(5, experience.getResult());

            ps.executeUpdate();

            System.out.println("Interview Experience Added Successfully!");

            ps.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Get All Interview Experiences
    public ArrayList<InterviewExperience> getAllExperiences() {

        ArrayList<InterviewExperience> list = new ArrayList<>();

        String sql = "SELECT * FROM interview_experience";

        try {
            Connection con = DriverManager.getConnection(url, username, password);

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                InterviewExperience experience = new InterviewExperience(
                        rs.getInt("experience_id"),
                        rs.getInt("student_id"),
                        rs.getInt("drive_id"),
                        rs.getString("feedback"),
                        rs.getString("result")
                );

                list.add(experience);
            }

            rs.close();
            st.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    // Display All Interview Experiences
    public void displayAllExperiences() {

        ArrayList<InterviewExperience> list = getAllExperiences();

        for (InterviewExperience experience : list) {

            experience.displayExperience();

            System.out.println("----------------------");
        }
    }
}
