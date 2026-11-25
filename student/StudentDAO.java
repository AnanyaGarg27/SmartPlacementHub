
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private final Connection connection;

    public StudentDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean addStudent(Student student) throws SQLException {

        String sql = "INSERT INTO students (student_id, name, email, phone) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, student.getStudentId());
            ps.setString(2, student.getName());
            ps.setString(3, student.getEmail());
            ps.setString(4, student.getPhone());

            return ps.executeUpdate() > 0;
        }
    }

    public Student getStudentById(int studentId) throws SQLException {

        String sql = "SELECT * FROM students WHERE student_id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, studentId);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return new Student(
                        rs.getInt("student_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone")
                    );
                }
            }
        }

        return null;
    }

    public List<Student> getAllStudents() throws SQLException {

        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM students";

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                students.add(new Student(
                    rs.getInt("student_id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("phone")
                ));
            }
        }

        return students;
    }

    public boolean updateStudent(Student student) throws SQLException {

        String sql = "UPDATE students SET name = ?, email = ?, phone = ? WHERE student_id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getPhone());
            ps.setInt(4, student.getStudentId());

            return ps.executeUpdate() > 0;
        }
    }

    public boolean deleteStudent(int studentId) throws SQLException {

        String sql = "DELETE FROM students WHERE student_id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, studentId);

            return ps.executeUpdate() > 0;
        }
    }
}
