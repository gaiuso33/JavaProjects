import java.util.*;

public class MiniATM {
    static class Account {
        String name;
        String pin;
        double balance;

        Account(String name, String pin, double balance) {
            this.name = name;
            this.pin = pin;
            this.balance = balance;
        }
    }

    static Map<String, Account> accounts = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        preloadAccounts();

        System.out.println("🏧 Welcome to the Mini ATM System!");

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        if (!accounts.containsKey(username)) {
            System.out.println("❌ No such user found. Exiting.");
            return;
        }

        Account user = accounts.get(username);
        System.out.print("Enter PIN: ");
        String enteredPin = scanner.nextLine();

        if (!user.pin.equals(enteredPin)) {
            System.out.println("❌ Incorrect PIN. Access denied.");
            return;
        }

        System.out.println("✅ Login successful! Welcome, " + user.name + "!");
        boolean running = true;

        while (running) {
            System.out.println("\n📋 Choose an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> System.out.printf("💰 Current Balance: $%.2f\n", user.balance);
                case 2 -> {
                    double deposit = getPositiveAmount(scanner, "Enter amount to deposit: ");
                    user.balance += deposit;
                    System.out.println("✅ Deposit successful.");
                }
                case 3 -> {
                    double withdraw = getPositiveAmount(scanner, "Enter amount to withdraw: ");
                    if (withdraw > user.balance) {
                        System.out.println("❌ Insufficient funds.");
                    } else {
                        user.balance -= withdraw;
                        System.out.println("✅ Withdrawal successful.");
                    }
                }
                case 4 -> {
                    System.out.println("👋 Goodbye, " + user.name + "!");
                    running = false;
                }
                default -> System.out.println("❌ Invalid option. Try again.");
            }
        }

        scanner.close();
    }

    static double getPositiveAmount(Scanner scanner, String prompt) {
        double amount;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                amount = scanner.nextDouble();
                if (amount > 0) break;
                else System.out.println("❌ Amount must be positive.");
            } else {
                System.out.println("❌ Invalid input. Enter a valid number.");
                scanner.next(); // clear invalid input
            }
        }
        return amount;
    }

    static void preloadAccounts() {
        accounts.put("john", new Account("John Doe", "1234", 500.00));
        accounts.put("jane", new Account("Jane Smith", "5678", 800.00));
        accounts.put("admin", new Account("Administrator", "0000", 1000.00));
    }
}
