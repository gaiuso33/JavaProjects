import java.util.*;
import java.io.*;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;

        System.out.println("💪 Welcome to the BMI Calculator!");

        while (keepRunning) {
            System.out.println("\nChoose unit system:");
            System.out.println("1. Metric (kg, meters)");
            System.out.println("2. Imperial (lbs, inches)");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            double weight = 0, height = 0;

            if (choice == 1) {
                weight = getValidPositive(scanner, "Enter weight in kilograms: ");
                height = getValidPositive(scanner, "Enter height in meters: ");
            } else if (choice == 2) {
                weight = getValidPositive(scanner, "Enter weight in pounds: ");
                height = getValidPositive(scanner, "Enter height in inches: ");
                // Convert to metric
                weight = weight * 0.453592;   // lbs to kg
                height = height * 0.0254;     // inches to meters
            } else {
                System.out.println("❌ Invalid choice. Try again.");
                continue;
            }

            double bmi = weight / (height * height);
            String category = getBMICategory(bmi);

            System.out.printf("✅ Your BMI is: %.2f (%s)\n", bmi, category);

            // Log to file
            logBMIResult(bmi, category);

            System.out.print("\nWould you like to calculate again? (yes/no): ");
            scanner.nextLine(); // clear buffer
            String again = scanner.nextLine().trim().toLowerCase();
            if (!again.equals("yes")) {
                keepRunning = false;
                System.out.println("👋 Goodbye!");
            }
        }

        scanner.close();
    }

    static double getValidPositive(Scanner scanner, String prompt) {
        double value;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                if (value > 0) break;
                else System.out.println("❌ Value must be positive.");
            } else {
                System.out.println("❌ Invalid input. Try again.");
                scanner.next(); // clear invalid input
            }
        }
        return value;
    }

    static String getBMICategory(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 24.9) return "Normal weight";
        else if (bmi < 29.9) return "Overweight";
        else return "Obese";
    }

    static void logBMIResult(double bmi, String category) {
        String fileName = "bmi_records.txt";
        String logEntry = String.format("BMI: %.2f | Category: %s\n", bmi, category);

        try (FileWriter fw = new FileWriter(fileName, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(logEntry);
            System.out.println("📝 BMI result logged to 'bmi_records.txt'");
        } catch (IOException e) {
            System.out.println("❌ Error writing to file: " + e.getMessage());
        }
    }
}
