import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initial account setup
        double balance = 1000.00;
        int option = -1;
        double withdraw = 0.00;
        double deposit = 0.00;
        int password = 1234;
        int userInput = 0;
        boolean accessGranted = false;

        // === User authentication ===
        System.out.println("Welcome to the ATM!");
        System.out.print("Enter your 4-digit password: ");
        userInput = scanner.nextInt();
        if(userInput==password){
            accessGranted=true;
        }
        else{
            for (int attempt = 2; attempt > 0; attempt--) {
                System.out.printf("Enter your 4-digit password (%d attempt(s) left): ", attempt);
                userInput = scanner.nextInt();

                if (userInput == password) {
                    accessGranted = true;
                    break;
                } else {
                    System.out.println("Incorrect password.\n");
                }
            }
        }
        if (accessGranted) {
            // === Main operation loop ===
            do {
                // Display menu options
                System.out.println("\n==============================");
                System.out.println("What would you like to do?");
                System.out.println("1. Check Balance");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                option = scanner.nextInt();

                // Handle user selection
                switch (option) {
                    case 1:
                        // Show current balance
                        System.out.printf("Your current balance is: $%.2f\n", balance);
                        break;

                    case 2:
                        // Handle withdrawal
                        System.out.print("Enter the amount you wish to withdraw: $");
                        withdraw = scanner.nextDouble();

                        // Reject negative or zero withdrawals
                        if (withdraw <= 0) {
                            System.out.println("Invalid amount. Withdrawal must be greater than zero.\n");
                            break;
                        }

                        // Check if there are enough funds
                        if (withdraw > balance) {
                            System.out.println("Insufficient funds. Returning to main menu.\n");
                            break;
                        }

                        // Perform withdrawal
                        balance -= withdraw;
                        System.out.printf("Withdrawal of $%.2f successful.\nCurrent balance: $%.2f\n", withdraw, balance);
                        break;

                    case 3:
                        // Handle deposit
                        System.out.print("Enter the amount you wish to deposit: $");
                        deposit = scanner.nextDouble();

                        // Reject negative or zero deposits
                        if (deposit <= 0) {
                            System.out.println("Invalid amount. Deposit must be greater than zero.\n");
                            break;
                        }

                        // Perform deposit
                        balance += deposit;
                        System.out.printf("Deposit of $%.2f successful.\nCurrent balance: $%.2f\n", deposit, balance);
                        break;

                    case 4:
                        // Exit the application
                        System.out.println("Thank you! See you next time.");
                        break;

                    default:
                        // Handle invalid menu option
                        System.out.println("Invalid option. Please try again.\n");
                }

            } while (option != 4); // Loop until the user chooses to exit
        } else {
            System.out.println("Account blocked due to too many failed login attempts.");
        }

        scanner.close();
    }
}
