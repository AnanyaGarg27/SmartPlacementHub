
public class PlacementPredictor {

    public double predictPlacement(boolean eligible,
            double skillMatchPercentage) {

        if (eligible == false) {
            return 0;
        }

        if (skillMatchPercentage < 0) {
            return 0;
        }

        if (skillMatchPercentage > 100) {
            return 100;
        }

        return skillMatchPercentage;
    }

    public String getPrediction(double score) {

        if (score >= 80) {
            return "High";
        }
        else if (score >= 50) {
            return "Medium";
        }
        else {
            return "Low";
        }
    }
}
