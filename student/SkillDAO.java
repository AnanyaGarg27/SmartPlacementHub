
package student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SkillDAO {

    private final Connection connection;

    public SkillDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean addSkill(Skill skill)
            throws SQLException {

        String sql = "INSERT INTO skills "
                + "(skill_id, skill_name) VALUES (?, ?)";

        try (PreparedStatement ps =
                connection.prepareStatement(sql)) {

            ps.setInt(1, skill.getSkillId());
            ps.setString(2, skill.getSkillName());

            return ps.executeUpdate() > 0;
        }
    }

    public Skill getSkillById(int skillId)
            throws SQLException {

        String sql = "SELECT * FROM skills "
                + "WHERE skill_id = ?";

        try (PreparedStatement ps =
                connection.prepareStatement(sql)) {

            ps.setInt(1, skillId);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return new Skill(
                        rs.getInt("skill_id"),
                        rs.getString("skill_name")
                    );
                }
            }
        }

        return null;
    }

    public List<Skill> getAllSkills()
            throws SQLException {

        List<Skill> skills = new ArrayList<>();

        String sql = "SELECT * FROM skills";

        try (PreparedStatement ps =
                connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                skills.add(new Skill(
                    rs.getInt("skill_id"),
                    rs.getString("skill_name")
                ));
            }
        }

        return skills;
    }

    public boolean updateSkill(Skill skill)
            throws SQLException {

        String sql = "UPDATE skills SET skill_name = ? "
                + "WHERE skill_id = ?";

        try (PreparedStatement ps =
                connection.prepareStatement(sql)) {

            ps.setString(1, skill.getSkillName());
            ps.setInt(2, skill.getSkillId());

            return ps.executeUpdate() > 0;
        }
    }

    public boolean deleteSkill(int skillId)
            throws SQLException {

        String sql = "DELETE FROM skills "
                + "WHERE skill_id = ?";

        try (PreparedStatement ps =
                connection.prepareStatement(sql)) {

            ps.setInt(1, skillId);

            return ps.executeUpdate() > 0;
        }
    }
}

