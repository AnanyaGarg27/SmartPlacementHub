
import java.util.*;

public class PlacementReport {

    public void displayReport(ArrayList<RecruitmentDrive> drives,
                              ArrayList<InterviewExperience> experiences) {

        System.out.println("========== PLACEMENT REPORT ==========");

        System.out.println("\nRecruitment Drive Details:");

        for (RecruitmentDrive drive : drives) {
            drive.displayDrive();
            System.out.println();
        }

        int selected = 0;
        int rejected = 0;

        for (InterviewExperience experience : experiences) {

            if (experience.getResult().equalsIgnoreCase("Selected")) {
                selected++;
            }
            else if (experience.getResult().equalsIgnoreCase("Rejected")) {
                rejected++;
            }
        }

        System.out.println("Total Recruitment Drives: " + drives.size());
        System.out.println("Total Interview Records: " + experiences.size());
        System.out.println("Selected Students: " + selected);
        System.out.println("Rejected Students: " + rejected);

        System.out.println("======================================");
    }
}

