import java.util.ArrayList;

public class StudentDAO {

    private ArrayList<Student> students = new ArrayList<>();

    public boolean addStudent(Student student) {

        students.add(student);
        return true;
    }

    public Student getStudentById(int studentId) {

        for (Student student : students) {

            if (student.getStudentId() == studentId) {
                return student;
            }
        }

        return null;
    }

    public ArrayList<Student> getAllStudents() {

        return students;
    }

    public boolean updateStudent(Student student) {

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).getStudentId() == student.getStudentId()) {

                students.set(i, student);
                return true;
            }
        }

        return false;
    }

    public boolean deleteStudent(int studentId) {

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).getStudentId() == studentId) {

                students.remove(i);
                return true;
            }
        }

        return false;
    }
}
