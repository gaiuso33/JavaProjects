import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;

        System.out.println("📟 Welcome to the Improved Calculator!");

        while (keepRunning) {
            System.out.println("\nSelect an operation:");
            System.out.println("1. Add (+)");
            System.out.println("2. Subtract (-)");
            System.out.println("3. Multiply (*)");
            System.out.println("4. Divide (/)");
            System.out.println("5. Modulo (%)");
            System.out.println("6. Power (x^y)");
            System.out.println("7. Square Root (√)");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice;

            // Handle invalid input for menu choice
            if (!scanner.hasNextInt()) {
                System.out.println("❌ Invalid input. Please enter a number.");
                scanner.next(); // clear invalid input
                continue;
            }

            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> performOperation(scanner, "+");
                case 2 -> performOperation(scanner, "-");
                case 3 -> performOperation(scanner, "*");
                case 4 -> performOperation(scanner, "/");
                case 5 -> performOperation(scanner, "%");
                case 6 -> performOperation(scanner, "^");
                case 7 -> squareRoot(scanner);
                case 8 -> {
                    keepRunning = false;
                    System.out.println("👋 Exiting Calculator. Goodbye!");
                }
                default -> System.out.println("❌ Invalid choice. Try again.");
            }
        }

        scanner.close();
    }

    static void performOperation(Scanner scanner, String operator) {
        double num1 = getValidNumber(scanner, "Enter first number: ");
        double num2 = getValidNumber(scanner, "Enter second number: ");

        double result = 0;
        boolean valid = true;

        switch (operator) {
            case "+" -> result = num1 + num2;
            case "-" -> result = num1 - num2;
            case "*" -> result = num1 * num2;
            case "/" -> {
                if (num2 == 0) {
                    System.out.println("❌ Error: Division by zero is not allowed.");
                    valid = false;
                } else {
                    result = num1 / num2;
                }
            }
            case "%" -> result = num1 % num2;
            case "^" -> result = Math.pow(num1, num2);
        }

        if (valid) {
            System.out.printf("✅ Result: %.2f %s %.2f = %.2f\n", num1, operator, num2, result);
        }
    }

    static void squareRoot(Scanner scanner) {
        double num = getValidNumber(scanner, "Enter number to find square root: ");
        if (num < 0) {
            System.out.println("❌ Error: Cannot compute square root of a negative number.");
        } else {
            double result = Math.sqrt(num);
            System.out.printf("✅ Square root of %.2f = %.2f\n", num, result);
        }
    }

    static double getValidNumber(Scanner scanner, String prompt) {
        double number;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                number = scanner.nextDouble();
                break;
            } else {
                System.out.println("❌ Invalid number. Try again.");
                scanner.next(); // clear invalid input
            }
        }
        return number;
    }
}
