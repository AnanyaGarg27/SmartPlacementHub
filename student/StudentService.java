
package student;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class StudentService {

    private final StudentDAO studentDAO;

    public StudentService(Connection connection) {
        this.studentDAO = new StudentDAO(connection);
    }

    public boolean registerStudent(Student student)
            throws SQLException {

        if (student == null ||
                student.getStudentId() <= 0 ||
                student.getName() == null ||
                student.getName().trim().isEmpty()) {
            return false;
        }

        if (studentDAO.getStudentById(
                student.getStudentId()) != null) {
            return false;
        }

        return studentDAO.addStudent(student);
    }

    public Student searchStudent(int studentId)
            throws SQLException {

        return studentDAO.getStudentById(studentId);
    }

    public List<Student> displayAllStudents()
            throws SQLException {

        return studentDAO.getAllStudents();
    }

    public boolean updateStudentDetails(Student student)
            throws SQLException {

        if (student == null ||
                student.getStudentId() <= 0 ||
                student.getName() == null ||
                student.getName().trim().isEmpty()) {
            return false;
        }

        return studentDAO.updateStudent(student);
    }

    public boolean removeStudent(int studentId)
            throws SQLException {

        return studentDAO.deleteStudent(studentId);
    }
}


