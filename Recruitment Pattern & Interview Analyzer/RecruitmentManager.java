
import java.util.ArrayList;

public class RecruitmentManager {

    // Store recruitment drives
    ArrayList<RecruitmentDrive> drives = new ArrayList<>();

    // Add Recruitment Drive
    public void addRecruitmentDrive(RecruitmentDrive drive) {

        drives.add(drive);

        System.out.println("Recruitment Drive Added Successfully!");
    }

    // Get All Recruitment Drives
    public ArrayList<RecruitmentDrive> getAllDrives() {

        return drives;
    }

    // Display All Recruitment Drives
    public void displayAllDrives() {

        for (RecruitmentDrive drive : drives) {

            drive.displayDrive();

            System.out.println("--------------------");
        }
    }
}
