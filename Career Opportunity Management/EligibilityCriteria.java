
import java.util.ArrayList;

public class EligibilityCriteria {
    private double minimumCGPA;
    private ArrayList<String> allowedBranches;
    private int maximumBacklogs;

    public EligibilityCriteria(double minimumCGPA,
            ArrayList<String> allowedBranches, int maximumBacklogs) {
        this.minimumCGPA = minimumCGPA;
        this.allowedBranches = allowedBranches;
        this.maximumBacklogs = maximumBacklogs;
    }

    public double getMinimumCGPA() {
        return minimumCGPA;
    }

    public ArrayList<String> getAllowedBranches() {
        return allowedBranches;
    }

    public int getMaximumBacklogs() {
        return maximumBacklogs;
    }
}
