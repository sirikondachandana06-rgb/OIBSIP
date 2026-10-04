import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        int round = 1;
        char playAgain;

        do {

            int secretNumber = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\n====================================");
            System.out.println("       NUMBER GUESSING GAME");
            System.out.println("====================================");
            System.out.println("Round: " + round);
            System.out.println("I selected a number between 1 and 100.");
            System.out.println("MAXIMUM ATTEMPTS: 7");
            System.out.println("You have only 7 chances to guess!");
            System.out.println("====================================");

            while (attempts < 7) {

                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();

                attempts++;

                if (guess == secretNumber) {

                    System.out.println("\nCorrect! Congratulations!");
                    System.out.println("You guessed the number in "
                            + attempts + " attempts.");

                    score += 10;
                    guessedCorrectly = true;
                    break;

                } else if (guess > secretNumber) {

                    System.out.println("Too High!");
                    System.out.println("Attempts used: "
                            + attempts + "/7");

                } else {

                    System.out.println("Too Low!");
                    System.out.println("Attempts used: "
                            + attempts + "/7");
                }

                if (attempts < 7) {
                    System.out.println("Remaining attempts: "
                            + (7 - attempts));
                }
            }

            if (!guessedCorrectly) {

                System.out.println("\n====================================");
                System.out.println("GAME OVER FOR THIS ROUND!");
                System.out.println("You used all 7 attempts.");
                System.out.println("The correct number was: "
                        + secretNumber);
                System.out.println("====================================");

            }

            System.out.println("\nCurrent Score: " + score);

            System.out.print("\nDo you want to play again? (Y/N): ");
            playAgain = scanner.next().charAt(0);

            round++;

        } while (playAgain == 'Y' || playAgain == 'y');

        System.out.println("\n====================================");
        System.out.println("           FINAL RESULT");
        System.out.println("====================================");
        System.out.println("Final Score: " + score);
        System.out.println("Thank you for playing!");

        scanner.close();
    }
}