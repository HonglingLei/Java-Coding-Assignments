import java.util.Scanner;
import java.util.InputMismatchException;

public class Homework6 {

//6.1 static method getUserChoice
    static void getUserChoice(Scanner readInput) {
        int inputInt;
        System.out.println("Welcome to sorting program\n\n\t1. Title\n\t2. Rank\n\t3. Date\n\t4. Stars\n\t5. Likes\n\n ");
        do { // Loop until we have correct input
            System.out.print("Enter your choice between 1 and 5 only: ");
            try {
                inputInt = readInput.nextInt();
                // waits for user input
                if (inputInt >= 1 && inputInt <= 5) {
                    break;// Got it, done
                } else {
                    System.out.println("You have not entered a number between 1 and 5. Try again.");
                    readInput.nextLine(); // discard rest of the input
                    continue;// continue looping as it is wrong number
                }
            } catch (final InputMismatchException e) {
                System.out.println("You have entered an invalid choice. Try again.");
                readInput.nextLine(); // discard non-int input
                continue;
                // keep looping until you found right one
            }
        } while (true);
        System.out.println("\nYou entered valid choice " + inputInt);
        System.out.println("Thank you for giving your choice");
    }

//6.2 static method getTwoFloats
    static void getTwoFloats (Scanner readInput, float[] twoFloats) {
        System.out.println("\nWelcome to bonus get two floats program\n");
        do { // Loop until we have correct input
            System.out.print("Enter two floats separated by a space: ");
            try {
                twoFloats[0] = readInput.nextFloat();
                // waits for user input
                twoFloats[1] = readInput.nextFloat();
                // waits for user input
                // if you are here, the floats were good, you
                // are done, break out from loop
                break;
            } catch (final InputMismatchException e) {
                System.out.println("You have entered an invalid input. Try again.");
                readInput.nextLine();
                // discard non-float input
                continue;
                // keep looping until you found the right one
            }
        } while (true);
        System.out.println("\nYou entered two valid floats: " + twoFloats[0] + " and " + twoFloats[1] + " successfully!\n");
    }

//6.3 call the two methods in the main method
    public static void main(String[] args) {
        // create the scanner in the main method
        Scanner readInput = new Scanner(System.in);
        // create an array to contain the two floats
        float[] twoFloats = new float[2];
        // pass the scanner to getUserChoice
        getUserChoice(readInput);
        // pass the scanner and float array to getTwoFloats
        getTwoFloats(readInput, twoFloats);
    }
}
