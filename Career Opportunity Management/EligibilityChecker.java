
import java.util.ArrayList;

public class EligibilityChecker {

    public boolean checkEligibility(double cgpa, String branch,
            int backlogs, EligibilityCriteria criteria) {

        // Check minimum CGPA
        if (cgpa < criteria.getMinimumCGPA()) {
            return false;
        }

        // Check allowed branch
        ArrayList<String> allowedBranches =
                criteria.getAllowedBranches();

        boolean branchFound = false;

        for (int i = 0; i < allowedBranches.size(); i++) {

            if (allowedBranches.get(i).equalsIgnoreCase(branch)) {
                branchFound = true;
                break;
            }
        }

        // Check maximum backlogs
        if (backlogs > criteria.getMaximumBacklogs()) {
            return false;
        }

        return branchFound;
    }
}
