import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        int secretNumber = rand.nextInt(100) + 1;  // Random number between 1 and 100
        int guess;
        int attempts = 0;

        System.out.println("Guess the Number Game!");
        System.out.println("I'm thinking of a number between 1 and 100...");

        do {
            System.out.print("Enter your guess: ");
            guess = input.nextInt();
            attempts++;

            if (guess < secretNumber) {
                System.out.println("Too low! Try again.");
            } else if (guess > secretNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("🎉 Correct! You guessed it in " + attempts + " tries.");
            }
        } while (guess != secretNumber);

        input.close();
    }
}
