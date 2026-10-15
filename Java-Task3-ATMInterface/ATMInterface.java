

import java.util.Scanner;

public class ATMInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double balance = 1000.00;
        int choice;

        System.out.println("===== WELCOME TO ATM =====");

        do {
            System.out.println("\n1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                sc.next();
                System.out.print("Enter your choice: ");
            }

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.printf("Your balance is: Rs. %.2f%n", balance);
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");

                    if (sc.hasNextDouble()) {
                        double deposit = sc.nextDouble();

                        if (Double.isFinite(deposit) && deposit > 0) {
                            balance += deposit;
                            System.out.println("Deposit successful!");
                            System.out.printf(
                                "Updated balance: Rs. %.2f%n", balance);
                        } else {
                            System.out.println(
                                "Please enter a positive amount.");
                        }
                    } else {
                        System.out.println("Invalid amount.");
                        sc.next();
                    }
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ");

                    if (sc.hasNextDouble()) {
                        double withdraw = sc.nextDouble();

                        if (!Double.isFinite(withdraw) || withdraw <= 0) {
                            System.out.println(
                                "Please enter a positive amount.");
                        } else if (withdraw > balance) {
                            System.out.println("Insufficient balance!");
                        } else {
                            balance -= withdraw;
                            System.out.println("Please collect your money.");
                            System.out.printf(
                                "Remaining balance: Rs. %.2f%n", balance);
                        }
                    } else {
                        System.out.println("Invalid amount.");
                        sc.next();
                    }
                    break;

                case 4:
                    System.out.println(
                        "Thank you for using our ATM!");
                    break;

                default:
                    System.out.println(
                        "Invalid choice. Please select 1 to 4.");
            }

        } while (choice != 4);

        sc.close();
    }
}
