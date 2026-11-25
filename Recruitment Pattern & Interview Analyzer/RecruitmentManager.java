import java.sql.*;
import java.util.ArrayList;

public class RecruitmentManager {

    String url = "jdbc:mysql://localhost:3306/SmartPlacementHub";
    String username = "root";
    String password = "YOUR_PASSWORD";

    public void addRecruitmentDrive(RecruitmentDrive drive) {

        String sql = "INSERT INTO recruitment_drive "
                + "(company_name, job_role, drive_date) VALUES (?, ?, ?)";

        try {
            Connection con = DriverManager.getConnection(url, username, password);

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, drive.getCompanyName());
            ps.setString(2, drive.getJobRole());
            ps.setString(3, drive.getDriveDate());

            ps.executeUpdate();

            System.out.println("Recruitment Drive Added Successfully!");

            ps.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<RecruitmentDrive> getAllDrives() {

        ArrayList<RecruitmentDrive> list = new ArrayList<>();

        String sql = "SELECT * FROM recruitment_drive";

        try {
            Connection con = DriverManager.getConnection(url, username, password);

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                RecruitmentDrive drive = new RecruitmentDrive(
                        rs.getInt("drive_id"),
                        rs.getString("company_name"),
                        rs.getString("job_role"),
                        rs.getString("drive_date")
                );

                list.add(drive);
            }

            rs.close();
            st.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public void displayAllDrives() {

        ArrayList<RecruitmentDrive> list = getAllDrives();

        for (RecruitmentDrive drive : list) {
            drive.displayDrive();
            System.out.println("--------------------");
        }
    }
}