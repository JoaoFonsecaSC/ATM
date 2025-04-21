import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static double balance = 1000.00;


    public static void main(String[] args)
    {
        // Initial account setup
        int option;
        int password = 1234;
        int userInput;
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
                        withdraw();
                        break;

                    case 3:
                        // Handle deposit
                       deposit();
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
    static void withdraw(){
        double withdraw;
        System.out.print("Enter the amount you wish to withdraw: $");
        withdraw = scanner.nextDouble();

        // Reject negative or zero withdrawals
        if (withdraw <= 0) {
            System.out.println("Invalid amount. Withdrawal must be greater than zero.\n");
        }

        // Check if there are enough funds
        if (withdraw > balance) {
            System.out.println("Insufficient funds. Returning to main menu.\n");
        }

        // Perform withdrawal
        balance -= withdraw;
        System.out.printf("Withdrawal of $%.2f successful.\nCurrent balance: $%.2f\n", withdraw, balance);
    }
    static void deposit(){
        double deposit;

        System.out.print("Enter the amount you wish to deposit: $");
        deposit = scanner.nextDouble();

        // Reject negative or zero deposits
        if (deposit <= 0) {
            System.out.println("Invalid amount. Deposit must be greater than zero.\n");
            return;
        }

        // Perform deposit
        balance += deposit;
        System.out.printf("Deposit of $%.2f successful.\nCurrent balance: $%.2f\n", deposit, balance);

    }
}
