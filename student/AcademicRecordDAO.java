import java.util.ArrayList;

public class AcademicRecordDAO {

    ArrayList<AcademicRecord> records = new ArrayList<>();


    public boolean addAcademicRecord(AcademicRecord record) {

        records.add(record);

        return true;
    }


    public AcademicRecord getAcademicRecord(int studentId) {

        for (AcademicRecord record : records) {

            if (record.getStudentId() == studentId) {
                return record;
            }
        }

        return null;
    }

    public boolean updateAcademicRecord(AcademicRecord record) {

        for (int i = 0; i < records.size(); i++) {

            if (records.get(i).getStudentId() == record.getStudentId()) {

                records.set(i, record);
                return true;
            }
        }

        return false;
    }

    public boolean deleteAcademicRecord(int studentId) {

        for (int i = 0; i < records.size(); i++) {

            if (records.get(i).getStudentId() == studentId) {

                records.remove(i);
                return true;
            }
        }

        return false;
    }
}
