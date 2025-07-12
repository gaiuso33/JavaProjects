import java.util.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("🎮 Welcome to Guess the Number!");
        boolean keepPlaying = true;

        while (keepPlaying) {
            System.out.println("\nSelect Difficulty:");
            System.out.println("1. Easy (1–10)");
            System.out.println("2. Medium (1–50)");
            System.out.println("3. Hard (1–100)");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            int max;
            String level;

            switch (choice) {
                case 1 -> {
                    max = 10;
                    level = "Easy";
                }
                case 2 -> {
                    max = 50;
                    level = "Medium";
                }
                case 3 -> {
                    max = 100;
                    level = "Hard";
                }
                default -> {
                    System.out.println("❌ Invalid choice. Defaulting to Easy.");
                    max = 10;
                    level = "Easy";
                }
            }

            int secretNumber = rand.nextInt(max) + 1;
            int attempts = 0;
            boolean guessed = false;

            System.out.printf("\n🔢 I have picked a number between 1 and %d. Try to guess it!\n", max);
            scanner.nextLine(); // clear newline

            while (!guessed) {
                System.out.print("Your guess: ");
                if (!scanner.hasNextInt()) {
                    System.out.println("❌ Not a number. Try again.");
                    scanner.next(); // clear invalid
                    continue;
                }

                int guess = scanner.nextInt();
                attempts++;

                if (guess < secretNumber) {
                    System.out.println("📉 Too low!");
                } else if (guess > secretNumber) {
                    System.out.println("📈 Too high!");
                } else {
                    System.out.printf("🎉 Correct! You guessed it in %d attempts!\n", attempts);
                    guessed = true;
                }
            }

            // Save game record
            logGameResult(level, secretNumber, attempts);

            System.out.print("\nPlay again? (yes/no): ");
            scanner.nextLine(); // clear newline
            String response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("yes")) {
                keepPlaying = false;
                System.out.println("👋 Thanks for playing!");
            }
        }

        scanner.close();
    }

    static void logGameResult(String level, int secretNumber, int attempts) {
        String fileName = "game_history.txt";
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String entry = String.format("[%s] Level: %s | Number: %d | Attempts: %d\n",
                timestamp, level, secretNumber, attempts);

        try (FileWriter fw = new FileWriter(fileName, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(entry);
            System.out.println("📝 Game result logged.");
        } catch (IOException e) {
            System.out.println("❌ Could not log result: " + e.getMessage());
        }
    }
}
