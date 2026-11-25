
import java.util.*;

public class InterviewPerformanceAnalyzer {

    public void displayPerformance(ArrayList<InterviewExperience> list) {

        if (list.isEmpty()) {
            System.out.println("No interview records available.");
            return;
        }

        int selected = 0;
        int rejected = 0;

        for (InterviewExperience experience : list) {

            if (experience.getResult().equalsIgnoreCase("Selected")) {
                selected++;
            }
            else if (experience.getResult().equalsIgnoreCase("Rejected")) {
                rejected++;
            }
        }

        System.out.println("Interview Performance:");

        System.out.println("Total Interview Records: " + list.size());
        System.out.println("Selected Students: " + selected);
        System.out.println("Rejected Students: " + rejected);

        double percentage = (selected * 100.0) / list.size();

        System.out.println("Selection Percentage: " + percentage + "%");
    }
}

