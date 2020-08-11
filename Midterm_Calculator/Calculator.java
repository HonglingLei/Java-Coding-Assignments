import java.util.Scanner;
import java.util.InputMismatchException;

public class Calculator {

//method 1: display the menu

    static void displayMenu(){
        System.out.print("Welcome to Hongling Lei's Handy Calculator\n\n");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Exit");
        System.out.print("\nWhat would you like to do? ");
    }

//method 2: ask the user for a choice

    /**
     * @param readInput
     * : Scanner passed from main method *
     * @param choiceInt
     * : assigns one int from user into the array element
     * A loop is used to continue asking for valid choice.
     * The getUserChoice method of scanner is used which throws
     * InputMistatchException if the value is not able to be extracted.
     * When the wrong value is entered, the input is still in input
     * buffer which is cleared by use of nextLine() & then the loop
     * starts over requesting user choice. The valid choice is
     * assigned to choiceInt and the new value is returned as the
     * return value from the method */

    static void getUserChoice(Scanner readInput, int[] choiceInt) {
        //validate input
        do { //loop until we have correct input
            try {
                //wait for user input
                choiceInt[0] = readInput.nextInt();
                if (choiceInt[0] >= 1 && choiceInt[0] <= 5) {
                    break;//got it, done
                } else {
                    System.out.println("You have not entered a number between 1 and 5. Try again.");
                    readInput.nextLine(); //discard rest of the input
                    continue;//continue looping as it is wrong number
                }
            } catch (final InputMismatchException e) {
                System.out.println("You have entered an invalid choice. Try again.");
                readInput.nextLine(); //discard non-int input
                //keep looping until you find the right one
                continue;
            }
        } while (true);

    }

//method 3: ask the user for two floats

    /**
     * @param readInput
     * : Scanner passed from main method
     * @param choiceInt
     * : assigns one int from user into the array element
     * @param twoFloats
     * : assigns two floats from user into the array elements
     * A loop is used to continue asking for valid values. The
     * getTwoFloats method of scanner is used which throws
     * InputMistatchException if the value is not able to be extracted.
     * When the wrong value is entered the input is still in input
     * buffer which is cleared by use of nextLine() and then the loop
     * starts over requesting two floats The valid floats are
     * assigned into 0th and 1st element of myFloats array. Since
     * array is passed as reference, the new value will be reflected
     * in calling method (main method in this case) */

    static void getTwoFloats(Scanner readInput, int[] choiceInt, float[] twoFloats){
        //print this welcome sentence based on user's choice
        //an empty line
        System.out.println(" ");
        if (choiceInt[0] == 1)
            System.out.print("Please enter two floats to add, separated by a space: ");
        else if (choiceInt[0] == 2)
            System.out.print("Please enter two floats to subtract, separated by a space: ");
        else if (choiceInt[0] == 3)
            System.out.print("Please enter two floats to multiply, separated by a space: ");
        else if (choiceInt[0] == 4)
            System.out.print("Please enter two floats to divide, separated by a space: ");

        //check validity of the two inputs
        do { //loop until we have correct input
            try {
                //wait for user input
                twoFloats[0] = readInput.nextFloat();
                twoFloats[1] = readInput.nextFloat();
                //wait for user input
                //if you are here, the floats were good, you are done, break out from loop
                //in "division" case, the second number cannot be 0
                if (choiceInt[0] == 4 && twoFloats[1] == 0)
                    System.out.print("You can't divide by zero. Please re-enter both floats: ");
                else break;
            } catch (final InputMismatchException e) {
                System.out.print("You have entered invalid floats. Please re-enter: ");
                //discard non-float input
                readInput.nextLine();
                //keep looping until you find the right one
                continue;
            }
        } while (true);
    }

//method 4: calculate and print the result

    /**
     * @param choiceInt
     * : assigns one int from user into the array element
     * @param twoFloats
     * : assigns two floats from user into the array elements
     * This method calculates the result of mathematical operations
     * and prints "adding", "subtracting", "multiplying", "dividing"
     * based on user's choice
     */
    static void calculateResult(int[] choiceInt, float[] twoFloats){
        if (choiceInt[0] == 1) {//add
            System.out.printf("Result of adding %5.2f by %5.2f is %5.2f.\n", twoFloats[0], twoFloats[1], twoFloats[0] + twoFloats[1]);
        } else if (choiceInt[0] == 2) {//subtract
            System.out.printf("Result of subtracting %5.2f by %5.2f is %5.2f.\n", twoFloats[0], twoFloats[1], twoFloats[0] - twoFloats[1]);
        } else if (choiceInt[0] == 3) {//multiply
            System.out.printf("Result of multiplying %5.2f by %5.2f is %5.2f.\n", twoFloats[0], twoFloats[1], twoFloats[0] * twoFloats[1]);
        } else if (choiceInt[0] == 4) {//divide
            System.out.printf("Result of dividing %5.2f by %5.2f is %5.2f.\n", twoFloats[0], twoFloats[1], twoFloats[0] / twoFloats[1]);
        }
    }

    //main method
    public static void main(String[] args) {
        //create the scanner, array, and int that will be used in the above static methods
        Scanner readInput = new Scanner(System.in);
        //array twoFloats can take two inputs
        float[] twoFloats = new float[2];
        //array choiceInt can only take one input
        int[] choiceInt = new int[1];
        //call methods
        do {//loop until the user chooses 5 to exit the program
            //display all choices
            displayMenu();
            //get and check user's choice of operation
            getUserChoice(readInput, choiceInt);
            if (choiceInt[0]!= 5) {
                //get and check two floats
                getTwoFloats(readInput, choiceInt, twoFloats);
                //calculate operating result and print it
                calculateResult(choiceInt, twoFloats);
                //an empty line
                System.out.println("");
                //continue if the user presses enter key
                System.out.println("Press enter key to continue...");
                readInput.nextLine();
                readInput.nextLine();
            } else //exit when the user chooses 5
                System.out.println("\nThank you for using Hongling Lei's handy calculator");
        } while (choiceInt[0] != 5);//when user's choice is 5, exit the program
    }
}