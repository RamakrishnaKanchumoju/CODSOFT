import java.util.Scanner;

public class ATM {
    private String pin;
    private int balance;

    public ATM(String pin, int balance) {
        this.pin = pin;
        this.balance = balance;
    }

    public boolean checkPin(String pin) {
        return this.pin.equals(pin);
    }

    public void withdraw(int amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Transaction successful. Your new balance is: " + balance);
        } else {
            System.out.println("Insufficient funds. Your current balance is: " + balance);
        }
    }

    public void deposit(int amount) {
        balance += amount;
        System.out.println("Transaction successful. Your new balance is: " + balance);
    }

    public void checkBalance() {
        System.out.println("Your current balance is: " + balance);
    }

    public static void main(String[] args) {
        ATM atm = new ATM("1234", 1000);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter your PIN: ");
            String pin = scanner.nextLine();

            if (atm.checkPin(pin)) {
                while (true) {
                    atm.display_menu();
                    System.out.print("Enter your choice: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // consume newline not consumed by nextInt()

                    if (choice == 4) {
                        break;
                    }

                    switch (choice) {
                        case 1:
                            System.out.print("Enter the amount to withdraw: ");
                            atm.withdraw(scanner.nextInt());
                            break;
                        case 2:
                            System.out.print("Enter the amount to deposit: ");
                            atm.deposit(scanner.nextInt());
                            break;
                        case 3:
                            atm.checkBalance();
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                            break;
                    }
                }
            } else {
                System.out.println("Incorrect PIN. Please try again.");
            }
        }
    }

    public void display_menu() {
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }
}