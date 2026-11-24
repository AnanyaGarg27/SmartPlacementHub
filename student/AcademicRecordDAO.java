
package student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AcademicRecordDAO {

    private final Connection connection;

    public AcademicRecordDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean addAcademicRecord(AcademicRecord record)
            throws SQLException {

        String sql = "INSERT INTO academic_records "
                + "(student_id, cgpa, branch, semester, backlogs) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps =
                connection.prepareStatement(sql)) {

            ps.setInt(1, record.getStudentId());
            ps.setDouble(2, record.getCgpa());
            ps.setString(3, record.getBranch());
            ps.setInt(4, record.getSemester());
            ps.setInt(5, record.getBacklogs());

            return ps.executeUpdate() > 0;
        }
    }

    public AcademicRecord getAcademicRecord(int studentId)
            throws SQLException {

        String sql = "SELECT * FROM academic_records "
                + "WHERE student_id = ?";

        try (PreparedStatement ps =
                connection.prepareStatement(sql)) {

            ps.setInt(1, studentId);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return new AcademicRecord(
                        rs.getInt("student_id"),
                        rs.getDouble("cgpa"),
                        rs.getString("branch"),
                        rs.getInt("semester"),
                        rs.getInt("backlogs")
                    );
                }
            }
        }

        return null;
    }

    public boolean updateAcademicRecord(AcademicRecord record)
            throws SQLException {

        String sql = "UPDATE academic_records "
                + "SET cgpa = ?, branch = ?, semester = ?, "
                + "backlogs = ? WHERE student_id = ?";

        try (PreparedStatement ps =
                connection.prepareStatement(sql)) {

            ps.setDouble(1, record.getCgpa());
            ps.setString(2, record.getBranch());
            ps.setInt(3, record.getSemester());
            ps.setInt(4, record.getBacklogs());
            ps.setInt(5, record.getStudentId());

            return ps.executeUpdate() > 0;
        }
    }

    public boolean deleteAcademicRecord(int studentId)
            throws SQLException {

        String sql = "DELETE FROM academic_records "
                + "WHERE student_id = ?";

        try (PreparedStatement ps =
                connection.prepareStatement(sql)) {

            ps.setInt(1, studentId);

            return ps.executeUpdate() > 0;
        }
    }
}

