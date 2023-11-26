import java.util.Scanner;

class Account {
    private String accountNumber;
    private String pin;
    private double balance;

    public Account(String accountNumber, String pin, double balance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public boolean validatePin(String enteredPin) {
        return pin.equals(enteredPin);
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: $" + balance);
        } else {
            System.out.println("Invalid amount or insufficient funds.");
        }
    }
}

class ATM {
    private Account account;

    public ATM(Account account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Exit");
    }

    public void processOption(int option) {
        switch (option) {
            case 1:
                System.out.println("Current Balance: $" + account.getBalance());
                break;
            case 2:
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter withdrawal amount: $");
                double amount = scanner.nextDouble();
                account.withdraw(amount);
                break;
            case 3:
                System.out.println("Exiting. Thank you!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Account userAccount = new Account("123456789", "1234", 1000.0);
        ATM atm = new ATM(userAccount);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter your account number: ");
            String enteredAccountNumber = scanner.next();
            System.out.println("Enter your PIN: ");
            String enteredPin = scanner.next();

            if (enteredAccountNumber.equals(userAccount.getAccountNumber()) &&
                    userAccount.validatePin(enteredPin)) {
                while (true) {
                    atm.displayMenu();
                    System.out.print("Choose an option: ");
                    int option = scanner.nextInt();
                    atm.processOption(option);
                }
            } else {
                System.out.println("Invalid account number or PIN. Please try again.");
            }
        }
    }
}