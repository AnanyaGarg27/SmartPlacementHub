        
import java.sql.Connection;
import java.sql.SQLException;

public class AcademicRecordService {

    private final AcademicRecordDAO academicRecordDAO;

    public AcademicRecordService(Connection connection) {
        this.academicRecordDAO = new AcademicRecordDAO(connection);
    }

    public boolean addRecord(AcademicRecord record) throws SQLException {

        if (!validateRecord(record)) {
            return false;
        }

        if (academicRecordDAO.getAcademicRecord(record.getStudentId()) != null) {
            return false;
        }

        return academicRecordDAO.addAcademicRecord(record);
    }

    public AcademicRecord searchRecord(int studentId) throws SQLException {
        return academicRecordDAO.getAcademicRecord(studentId);
    }

    public boolean updateRecord(AcademicRecord record) throws SQLException {

        if (!validateRecord(record)) {
            return false;
        }

        return academicRecordDAO.updateAcademicRecord(record);
    }

    public boolean deleteRecord(int studentId) throws SQLException {
        return academicRecordDAO.deleteAcademicRecord(studentId);
    }

    private boolean validateRecord(AcademicRecord record) {

        return record != null
                && record.getStudentId() > 0
                && record.getCgpa() >= 0
                && record.getCgpa() <= 10
                && record.getSemester() >= 1
                && record.getSemester() <= 8
                && record.getBacklogs() >= 0
                && record.getBranch() != null
                && !record.getBranch().trim().isEmpty();
    }
}
