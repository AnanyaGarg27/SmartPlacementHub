public class InterviewRound {

    private int roundId;
    private String companyName;
    private String roundName;

    public InterviewRound(int roundId, String companyName,
                          String roundName) {

        this.roundId = roundId;
        this.companyName = companyName;
        this.roundName = roundName;
    }

    public int getRoundId() {
        return roundId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getRoundName() {
        return roundName;
    }

    public void displayRound() {
        System.out.println("Round ID: " + roundId);
        System.out.println("Company: " + companyName);
        System.out.println("Round: " + roundName);
    }
}
