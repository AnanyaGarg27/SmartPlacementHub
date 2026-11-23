
public class InterviewQuestion {

    private int questionId;
    private int roundId;
    private String questionText;

    public InterviewQuestion(int questionId, int roundId,
                             String questionText) {
        this.questionId = questionId;
        this.roundId = roundId;
        this.questionText = questionText;
    }

    public int getQuestionId() {
        return questionId;
    }

    public int getRoundId() {
        return roundId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void displayQuestion() {
        System.out.println("Question ID: " + questionId);
        System.out.println("Question: " + questionText);
    }
}

