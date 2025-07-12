import java.io.*;
import java.util.*;

public class GradeEvaluator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> subjects = new LinkedHashMap<>();

        System.out.println("🎓 Welcome to the Grade Evaluator!");

        while (true) {
            System.out.print("\nEnter subject name (or type 'done' to finish): ");
            String subject = scanner.nextLine().trim();
            if (subject.equalsIgnoreCase("done")) break;

            int score = getValidScore(scanner, "Enter score for " + subject + ": ");
            subjects.put(subject, score);
        }

        if (subjects.isEmpty()) {
            System.out.println("⚠️ No subjects entered. Exiting.");
            return;
        }

        // Report building
        StringBuilder report = new StringBuilder();
        report.append("📋 Grade Report:\n");
        int total = 0;
        String topSubject = "", lowSubject = "";
        int topScore = Integer.MIN_VALUE, lowScore = Integer.MAX_VALUE;

        for (Map.Entry<String, Integer> entry : subjects.entrySet()) {
            String subj = entry.getKey();
            int score = entry.getValue();
            total += score;
            String grade = getLetterGrade(score);
            report.append(String.format("%-15s : %3d (%s)\n", subj, score, grade));

            if (score > topScore) {
                topScore = score;
                topSubject = subj;
            }
            if (score < lowScore) {
                lowScore = score;
                lowSubject = subj;
            }
        }

        double average = (double) total / subjects.size();
        report.append(String.format("\n📊 Average Score: %.2f (%s)\n", average, getLetterGrade((int) average)));
        report.append("🏅 Highest: " + topSubject + " (" + topScore + ")\n");
        report.append("📉 Lowest:  " + lowSubject + " (" + lowScore + ")\n");

        System.out.println("\n" + report);

        // Save to file
        try (PrintWriter writer = new PrintWriter(new FileWriter("grades.txt"))) {
            writer.print(report.toString());
            System.out.println("✅ Report saved to 'grades.txt'");
        } catch (IOException e) {
            System.out.println("❌ Error writing to file: " + e.getMessage());
        }

        scanner.close();
    }

    static int getValidScore(Scanner scanner, String prompt) {
        int score;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                score = scanner.nextInt();
                scanner.nextLine(); // clear newline
                if (score >= 0 && score <= 100) break;
                else System.out.println("❌ Score must be between 0 and 100.");
            } else {
                System.out.println("❌ Invalid input. Please enter a number.");
                scanner.next(); // clear invalid
            }
        }
        return score;
    }

    static String getLetterGrade(int score) {
        if (score >= 70) return "A";
        else if (score >= 60) return "B";
        else if (score >= 50) return "C";
        else if (score >= 45) return "D";
        else if (score >= 40) return "E";
        else return "F";
    }
}
