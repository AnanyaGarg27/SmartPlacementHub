public class StudentValidator {

    public boolean validateStudent(Student student) {

        if (student == null) {
            return false;
        }

        if (student.getStudentId() <= 0) {
            return false;
        }

        if (student.getName() == null ||
                student.getName().trim().isEmpty()) {
            return false;
        }

        if (!validateEmail(student.getEmail())) {
            return false;
        }

        return validatePhone(student.getPhone());
    }

    public boolean validateEmail(String email) {

        return email != null &&
                email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }

    public boolean validatePhone(String phone) {

        return phone != null &&
                phone.matches("[0-9]{10}");
    }

    public boolean validateAcademicRecord(AcademicRecord record) {

        return record != null &&
                record.getStudentId() > 0 &&
                record.getCgpa() >= 0 &&
                record.getCgpa() <= 10 &&
                record.getSemester() > 0 &&
                record.getBacklogs() >= 0;
    }
}
