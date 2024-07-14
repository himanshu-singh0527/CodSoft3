import java.util.Scanner;

// Class representing the user's bank account
class BankAccount {
    private double balance; // Account balance

    // Constructor to initialize the account with an initial balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to get the current balance
    public double getBalance() {
        return balance;
    }

    // Method to deposit an amount into the account
    public void deposit(double amount) {
        balance += amount;
    }

    // Method to withdraw an amount from the account
    public boolean withdraw(double amount) {
        // Check if there are sufficient funds for the withdrawal
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false; // Insufficient funds
        }
    }
}

// Class representing the ATM machine
class ATM {
    private BankAccount account; // User's bank account
    private Scanner scanner; // Scanner to read user input

    // Constructor to initialize the ATM with a bank account
    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    // Method to start the ATM interface
    public void start() {
        boolean exit = false;

        // Loop until the user chooses to exit
        while (!exit) {
            displayMenu(); // Display the menu options
            int choice = scanner.nextInt(); // Read the user's choice

            // Execute the appropriate method based on the user's choice
            switch (choice) {
                case 1:
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    exit = true; // Exit the loop
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Thank you for using the ATM. Goodbye!");
    }

    // Method to display the menu options
    private void displayMenu() {
        System.out.println("\nWelcome to the ATM");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Please choose an option: ");
    }

    // Method to handle withdrawals
    private void withdraw() {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble(); // Read the withdrawal amount

        // Check if the withdrawal is successful
        if (amount > 0 && account.withdraw(amount)) {
            System.out.println("Withdrawal successful. Please take your cash.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Method to handle deposits
    private void deposit() {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble(); // Read the deposit amount

        // Check if the deposit amount is valid
        if (amount > 0) {
            account.deposit(amount); // Deposit the amount into the account
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid amount.");
        }
    }

    // Method to check the account balance
    private void checkBalance() {
        System.out.println("Your current balance is: " + account.getBalance());
    }
}

// Main class to run the ATM simulation
public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(500.0); // Initialize the account with a starting balance of 500
        ATM atm = new ATM(account); // Create an ATM object with the bank account
        atm.start(); // Start the ATM interface
    }
}
