import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static double balance = 1000.00;
    static String loginArray[][] = {{"User1", "User2", "User3"},
            {"1234", "5678", "9999"}};
    static boolean accessGranted;

    public static void main(String[] args) {
        int option;
        accessGranted = login();

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

    static void withdraw() {
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

    static void deposit() {
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

    static boolean login() {
        String username;
        String password;

        boolean usercheck = true;
        boolean found = false;



        // === User authentication ===
        while (usercheck) {
            System.out.println("Welcome to the ATM!");
            System.out.print("Enter your login: ");
            username = scanner.next();
            System.out.print("Enter your password: ");
            password = scanner.next();


            for (int i = 0; i < loginArray[0].length; i++) {
                if (username.equals(loginArray[0][i])&& password.equals(loginArray[1][i])){
                    found = true;
                    usercheck = false;
                    System.out.printf("Olá %s\n", username);
                    break;
                }
            }
            if (!found) {
                System.out.println("***************************\nUser and/or password invalid");
            }
            }
            return true;}
        }