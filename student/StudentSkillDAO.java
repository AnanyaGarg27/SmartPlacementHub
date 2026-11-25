
package student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentSkillDAO {

    private final Connection connection;

    public StudentSkillDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean addStudentSkill(StudentSkill skill)
            throws SQLException {

        String sql = "INSERT INTO student_skills "
                + "(student_id, skill_id, proficiency_level) "
                + "VALUES (?, ?, ?)";

        try (PreparedStatement ps =
                connection.prepareStatement(sql)) {

            ps.setInt(1, skill.getStudentId());
            ps.setInt(2, skill.getSkillId());
            ps.setString(3, skill.getProficiencyLevel());

            return ps.executeUpdate() > 0;
        }
    }

    public List<StudentSkill> getStudentSkills(int studentId)
            throws SQLException {

        List<StudentSkill> skills = new ArrayList<>();

        String sql = "SELECT * FROM student_skills "
                + "WHERE student_id = ?";

        try (PreparedStatement ps =
                connection.prepareStatement(sql)) {

            ps.setInt(1, studentId);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    skills.add(new StudentSkill(
                        rs.getInt("student_id"),
                        rs.getInt("skill_id"),
                        rs.getString("proficiency_level")
                    ));
                }
            }
        }

        return skills;
    }

    public boolean updateStudentSkill(StudentSkill skill)
            throws SQLException {

        String sql = "UPDATE student_skills "
                + "SET proficiency_level = ? "
                + "WHERE student_id = ? AND skill_id = ?";

        try (PreparedStatement ps =
                connection.prepareStatement(sql)) {

            ps.setString(1, skill.getProficiencyLevel());
            ps.setInt(2, skill.getStudentId());
            ps.setInt(3, skill.getSkillId());

            return ps.executeUpdate() > 0;
        }
    }

    public boolean deleteStudentSkill(int studentId, int skillId)
            throws SQLException {

        String sql = "DELETE FROM student_skills "
                + "WHERE student_id = ? AND skill_id = ?";

        try (PreparedStatement ps =
                connection.prepareStatement(sql)) {

            ps.setInt(1, studentId);
            ps.setInt(2, skillId);

            return ps.executeUpdate() > 0;
        }
    }
}

