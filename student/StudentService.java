import java.util.ArrayList;

public class StudentService {

    private StudentDAO studentDAO = new StudentDAO();

    public boolean registerStudent(Student student) {

        if (student == null ||
                student.getStudentId() <= 0 ||
                student.getName() == null ||
                student.getName().trim().isEmpty()) {
            return false;
        }

        if (studentDAO.getStudentById(student.getStudentId()) != null) {
            return false;
        }

        return studentDAO.addStudent(student);
    }

    public Student searchStudent(int studentId) {

        return studentDAO.getStudentById(studentId);
    }

    public ArrayList<Student> displayAllStudents() {

        return studentDAO.getAllStudents();
    }

    public boolean updateStudentDetails(Student student) {

        if (student == null ||
                student.getStudentId() <= 0 ||
                student.getName() == null ||
                student.getName().trim().isEmpty()) {
            return false;
        }

        return studentDAO.updateStudent(student);
    }

    public boolean removeStudent(int studentId) {

        return studentDAO.deleteStudent(studentId);
    }
}
