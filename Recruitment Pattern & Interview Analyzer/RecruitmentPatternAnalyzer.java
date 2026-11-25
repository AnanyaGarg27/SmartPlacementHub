

import java.util.*;

public class RecruitmentPatternAnalyzer {

    public void displayRecruitmentPatterns(ArrayList<RecruitmentDrive> list) {

        if (list.isEmpty()) {
            System.out.println("No recruitment data available.");
            return;
        }

        HashMap<String, Integer> companyCount = new HashMap<>();

        // Count recruitment drives of each company
        for (RecruitmentDrive drive : list) {

            String company = drive.getCompanyName();

            if (companyCount.containsKey(company)) {
                companyCount.put(company, companyCount.get(company) + 1);
            } else {
                companyCount.put(company, 1);
            }
        }

        System.out.println("Recruitment Drives By Company:");

        for (String company : companyCount.keySet()) {
            System.out.println(company + " : "
                    + companyCount.get(company) + " drives");
        }

        // Find most active company
        String topCompany = "";
        int maxDrives = 0;

        for (String company : companyCount.keySet()) {

            if (companyCount.get(company) > maxDrives) {
                maxDrives = companyCount.get(company);
                topCompany = company;
            }
        }

        System.out.println("\nMost Active Company: " + topCompany);
    }
}


