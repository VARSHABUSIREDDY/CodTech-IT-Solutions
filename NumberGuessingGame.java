
import  java.util.Scanner;
import  java.util.Random;
public class NumberGuessingGame {
    public static void main(String[] args)
    {
        Random random = new Random();
        int numberToBeGuessed = random.nextInt(100);
        int numberOfAttempts = 10;
        System.out.println("Welcome to number guessing Game!");
        System.out.println("A random number that to be guessed by you is generated i.e;between 1 and 100.");
        System.out.println("You have only " + numberOfAttempts + " attempts to guess the number!");
        Scanner sc = new Scanner(System.in);
        while (numberOfAttempts > 0) {
            System.out.println("Enter your guess :");
            int guess = sc.nextInt();
            if (guess == numberToBeGuessed) {
                System.out.println("heyy you won! you guessed it right!!");
                break;
            } else if (guess < numberToBeGuessed) {
                System.out.println("Too low! Try Again!!");
            } else {
                System.out.println("Too high! Try Again!!");
            }
            numberOfAttempts--;
            System.out.println(numberOfAttempts + " more attempts left");
        }
        if (numberOfAttempts == 0) {
            System.out.println("Oops! You ran out of Attempts.The number you should have guessed is " + numberToBeGuessed);
        }
    }
}