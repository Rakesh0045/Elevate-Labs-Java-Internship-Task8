import java.util.*;

class Question {
    String question;
    List<String> options;
    char correctOption;

    public Question(String question, List<String> options, char correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }

    public boolean isCorrect(char answer) {
        return Character.toUpperCase(answer) == Character.toUpperCase(correctOption);
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Question> questions = Arrays.asList(
            new Question("What is the capital of India?", Arrays.asList("A. Delhi", "B. Mumbai", "C. Kolkata", "D. Chennai"), 'A'),
            new Question("Which keyword is used to inherit a class in Java?", Arrays.asList("A. implements", "B. import", "C. extends", "D. inherits"), 'C'),
            new Question("Which collection stores unique elements?", Arrays.asList("A. List", "B. Map", "C. Set", "D. ArrayList"), 'C'),
            new Question("Which loop is guaranteed to run at least once?", Arrays.asList("A. for", "B. while", "C. do-while", "D. foreach"), 'C'),
            new Question("Which method is used to read input in Java?", Arrays.asList("A. print()", "B. input()", "C. get()", "D. nextLine()"), 'D')
        );

        int score = 0;

        System.out.println("📝 Welcome to the Java Quiz!\n");

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println((i + 1) + ". " + q.question);
            for (String option : q.options) {
                System.out.println(option);
            }
            System.out.print("Your answer (A/B/C/D): ");
            char userAns = sc.next().charAt(0);
            if (q.isCorrect(userAns)) {
                System.out.println("✅ Correct!\n");
                score++;
            } else {
                System.out.println("❌ Incorrect! Correct answer: " + q.correctOption + "\n");
            }
        }

        System.out.println("🎯 Quiz completed! Your score: " + score + "/" + questions.size());
        sc.close();
    }
}
