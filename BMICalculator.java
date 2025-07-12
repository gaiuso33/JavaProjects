import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("BMI Calculator");

        System.out.print("Enter your weight in kilograms: ");
        double weight = input.nextDouble();

        System.out.print("Enter your height in meters: ");
        double height = input.nextDouble();

        if (weight <= 0 || height <= 0) {
            System.out.println("Invalid input. Weight and height must be positive numbers.");
        } else {
            double bmi = weight / (height * height);
            System.out.printf("Your BMI is: %.2f%n", bmi);

            // Classify based on WHO standard
            if (bmi < 18.5) {
                System.out.println("Category: lol, smallie");
            } else if (bmi < 24.9) {
                System.out.println("Category: chop up");
            } else if (bmi < 29.9) {
                System.out.println("Category: big chungus");
            } else {
                System.out.println("Category: fat as fuck");
            }
        }

        input.close();
    }
}
