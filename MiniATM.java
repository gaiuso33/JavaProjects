import java.util.Scanner;

public class MiniATM {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double balance = 1000.00;  // Starting balance
        int choice;

        System.out.println("Welcome to Mini ATM");

        do {
            System.out.println("\n==== ATM Menu ====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.printf("Your current balance is: ₦%.2f%n", balance);
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ₦");
                    double deposit = input.nextDouble();
                    if (deposit <= 0) {
                        System.out.println("Invalid amount. Must be greater than 0.");
                    } else {
                        balance += deposit;
                        System.out.println("Deposit successful.");
                    }
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ₦");
                    double withdraw = input.nextDouble();
                    if (withdraw <= 0) {
                        System.out.println("Invalid amount. Must be greater than 0.");
                    } else if (withdraw > balance) {
                        System.out.println("Insufficient balance.");
                    } else {
                        balance -= withdraw;
                        System.out.println("Withdrawal successful.");
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using Mini ATM. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter 1–4.");
            }

        } while (choice != 4);

        input.close();
    }
}
