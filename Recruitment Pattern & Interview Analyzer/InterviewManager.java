
import java.util.ArrayList;

public class InterviewManager {

    // Store interview rounds
    ArrayList<InterviewRound> rounds = new ArrayList<>();

    // Store interview experiences
    ArrayList<InterviewExperience> experiences = new ArrayList<>();

    // Add Interview Round
    public void addInterviewRound(InterviewRound round) {

        rounds.add(round);

        System.out.println("Interview Round Added Successfully!");
    }

    // Add Interview Experience
    public void addInterviewExperience(InterviewExperience experience) {

        experiences.add(experience);

        System.out.println("Interview Experience Added Successfully!");
    }

    // Get All Interview Experiences
    public ArrayList<InterviewExperience> getAllExperiences() {

        return experiences;
    }

    // Display All Interview Rounds
    public void displayAllRounds() {

        for (InterviewRound round : rounds) {

            System.out.println("Round ID: " + round.getRoundId());
            System.out.println("Company: " + round.getCompanyName());
            System.out.println("Round Name: " + round.getRoundName());

            System.out.println("----------------------");
        }
    }

    // Display All Interview Experiences
    public void displayAllExperiences() {

        for (InterviewExperience experience : experiences) {

            experience.displayExperience();

            System.out.println("----------------------");
        }
    }
}
