import java.util.Random;// packages import
import java.util.Scanner;

public class NumberGuessingGame //class name
 {
    public static void main(String[] args)
     {
       Random random = new Random();
       Scanner scanner = new Scanner(System.in);
       int randomNumber = random.nextInt(100) + 1;
       int attempts = 0;
       int score = 0;

        while (true) //while loop
        {
            System.out.println("Guess any number between 1 and 100:");
            int userGuess = scanner.nextInt();
             attempts++;

            if (userGuess == randomNumber) //condition
            {
                System.out.println("Congratulations! You guessed the correct number.");
                score++;
                System.out.println("Your score is: " + score);
                System.out.println("Do you want to play again? (yes/no)");
                String response = scanner.next();// runtime input taken
                if (!response.equalsIgnoreCase("yes"))
                {
                    break;
                }
                randomNumber = random.nextInt(100) + 1;
            } 
            else if (userGuess < randomNumber) 
              {
                System.out.println("Your guess is too low. Try again.");
              }
              else
              {
                System.out.println("Your guess is too high. Try again.");
              }
        }
        scanner.close();
    }
}