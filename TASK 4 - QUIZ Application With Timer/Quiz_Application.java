import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
class Question {
    private String question;
    private String[] options;
    private int correctOptionIndex;

    public Question(String question, String[] options, int correctOptionIndex) {
        this.question = question;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }
    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }
}
public class Quiz_Application{
    Scanner scanner = new Scanner(System.in);
    private List<Question> questions;
    private int currentQuestionIndex;
    private int score;
    private Timer timer;
    private final int TIME_LIMIT_SECONDS = 30;

    public Quiz_Application(List<Question> questions) {
        this.questions = questions;
        this.currentQuestionIndex = 0;
        this.score = 0;
        this.timer = new Timer();
    }

    public void startQuiz_Application() {
        displayNextQuestion();
    }

    private void displayNextQuestion() {
        if (currentQuestionIndex < questions.size()) {
            Question currentQuestion = questions.get(currentQuestionIndex);
            System.out.println("Question: " + currentQuestion.getQuestion());
            String[] options = currentQuestion.getOptions();
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }
            startTimer();
            getUserAnswer();
        } else {
            endQuiz_Application();
        }
    }

    private void startTimer() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time's up!");
                displayNextQuestion();
            }
        }, TIME_LIMIT_SECONDS * 1000);
    }

    private void getUserAnswer() {
        int selectedOption = scanner.nextInt();
        checkAnswer(selectedOption - 1); 
    }

    private void checkAnswer(int selectedOptionIndex) {
        Question currentQuestion = questions.get(currentQuestionIndex);
        if (selectedOptionIndex == currentQuestion.getCorrectOptionIndex()) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect. The correct answer is: " + (currentQuestion.getCorrectOptionIndex() + 1));
        }
        currentQuestionIndex++;
        displayNextQuestion();
    }

    private void endQuiz_Application() {
        timer.cancel();
        System.out.println("Quiz_Application ended!");
        System.out.println("Your score: " + score + "/" + questions.size());
    }
}
class Main {
    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of France?", 
                        new String[]{"Paris", "London", "Berlin", "Rome"}, 0));
        questions.add(new Question("Which planet is known as the Red Planet?", 
                        new String[]{"Mars", "Venus", "Jupiter", "Saturn"}, 0));
        questions.add(new Question("What is the capital of India?", 
                        new String[]{"Maharashtra", "Uttar Pradesh", "New Delhi", "Punjab"}, 2));
        questions.add(new Question("What is the largest animal on Earth?", 
                        new String[]{"Whale", "Elephant", "Giraffe", "Blue whale"}, 3));
        questions.add(new Question("What is the smallest planet in our solar system", 
                        new String[]{"Mars", "Mercury", "Earth", "Venus"}, 1));
        // Add more questions as needed

        Quiz_Application Quiz_Application = new Quiz_Application(questions);
        Quiz_Application.startQuiz_Application();
    }
}