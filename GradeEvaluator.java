import java.util.Scanner;

public class GradeEvaluator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Grade Evaluator");
        System.out.print("Enter your score (0 - 100): ");
        int score = input.nextInt();

        if (score < 0 || score > 100) {
            System.out.println("Invalid score. Please enter a number between 0 and 100.");
        } else if (score >= 70) {
            System.out.println("Grade: A");
        } else if (score >= 60) {
            System.out.println("Grade: B");
        } else if (score >= 50) {
            System.out.println("Grade: C");
        } else if (score >= 45) {
            System.out.println("Grade: D");
        } else if (score >= 40) {
            System.out.println("Grade: E");
        } else {
            System.out.println("Grade: F");
        }

        input.close();
    }
}
