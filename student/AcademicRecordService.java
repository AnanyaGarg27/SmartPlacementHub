public class AcademicRecordService {

    private AcademicRecordDAO academicRecordDAO =
            new AcademicRecordDAO();

    public boolean addRecord(AcademicRecord record) {

        if (!validateRecord(record)) {
            return false;
        }

        if (academicRecordDAO.getAcademicRecord(
                record.getStudentId()) != null) {
            return false;
        }

        return academicRecordDAO.addAcademicRecord(record);
    }

    public AcademicRecord searchRecord(int studentId) {

        return academicRecordDAO.getAcademicRecord(studentId);
    }

    public boolean updateRecord(AcademicRecord record) {

        if (!validateRecord(record)) {
            return false;
        }

        return academicRecordDAO.updateAcademicRecord(record);
    }

    public boolean deleteRecord(int studentId) {

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
