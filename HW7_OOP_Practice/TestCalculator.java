import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 OOP class that contains several methods:
 1. operation methods: add, subtract, multiply, divide
 2. printMenu
 3. askCalcChoice
 4. askTwoValues
 5. displayResults
 6.displayBye
*/

class OOPCalculator {
    //define variables
    int calcOption = 0;
    char optionChar;
    float[] twoFloats = new float[2];
    String calcOperation;
    Scanner readInput = new Scanner(System.in);

    //mathematical operation methods
    public void add(float[] numbers) {
        System.out.printf("Result of adding %.2f and %.2f is %.2f\n", numbers[0], numbers[1], numbers[0] + numbers[1]);
    }

    public void subtract(float[] numbers) {
        System.out.printf("Result of subtracting %.2f and %.2f is %.2f\n", numbers[0], numbers[1], numbers[0] - numbers[1]);
    }

    public void multiply(float[] numbers) {
        System.out.printf("Result of multiplying %.2f and %.2f is %.2f\n", numbers[0], numbers[1], numbers[0] * numbers[1]);
    }

    public void divide(float[] numbers) {
        System.out.printf("Result of dividing %.2f and %.2f is %.2f\n", numbers[0], numbers[1], numbers[0] / numbers[1]);
    }

    //printMenu
    public void printMenu() {
        System.out.print("\n");
        System.out.print("Welcome to Hongling Lei's Handy Calculator\n\n");
        System.out.print("\t1. Addition\n");
        System.out.print("\t2. Subtraction\n");
        System.out.print("\t3. Multiplication\n");
        System.out.print("\t4. Division\n");
        System.out.print("\t5. Exit\n");
    }

    //ask for user input
    //check input's validity (1-5, or A,a,S,s,M,m,D,d,X,x)
    public int askCalcChoice() {
        boolean tryAgain = false;
        do {//loop until we have correct input
            printMenu();
            System.out.print("\nWhat would you like to do? ");
            try {
                optionChar = readInput.next().charAt(0);//take in the first character of input
                switch (optionChar) {
                    //if input is 1 or A or a, then it should be considered as "add"
                    case '1':
                    case 'A':
                    case 'a':
                        //change operation to "add"
                        calcOperation = "add";
                        calcOption = 1;
                        tryAgain = false;
                        break;
                    //if input is 2 or S or s, then it should be considered as "subtract"
                    case '2':
                    case 'S':
                    case 's':
                        calcOperation = "subtract";
                        calcOption = 2;
                        tryAgain = false;
                        break;
                    //if input is 3 or M or m, then it should be considered as "multiply"
                    case '3':
                    case 'M':
                    case 'm':
                        calcOperation = "multiply";
                        calcOption = 3;
                        tryAgain = false;
                        break;
                    //if input is 4 or D or d, then it should be considered as "divide"
                    case '4':
                    case 'D':
                    case 'd':
                        calcOperation = "divide";
                        calcOption = 4;
                        tryAgain = false;
                        break;
                    //if input is 5 or X or x, then it should be considered as "exit"
                    case '5':
                    case 'X':
                    case 'x':
                        calcOperation = "exit";
                        calcOption = 5;
                        tryAgain = false;
                        break;
                    //if the input is invalid, ask the user to try again
                    default:
                        tryAgain = true;
                        System.out.println("You have not entered a valid choice. Please try again.");
                        break;
                }
            } catch (final InputMismatchException e) {//if the input is invalid, ask the user to try again
                System.out.println("You have entered an invalid input. Please try again.");
                readInput.next();
                continue;
            }
        } while (tryAgain == true);
        return calcOption; //return calcOption as an integer, to be used later
    }

    //ask for floats
    public float[] askTwoValues(){
        int count;
        do { //loop until we have correct input
            count = 0;
            System.out.printf("\nPlease enter two numbers to %s separated by a space: ", calcOperation);
            try {
                //read input numbers
                twoFloats[0] = readInput.nextFloat();
                count += 1;
                twoFloats[1] = readInput.nextFloat();
                if (twoFloats[1] != 0){
                    break; //break out of loop when we get two valid inputs
                } else if (calcOption == 4){ //address divide by zero issue
                    System.out.println("You can't divide by zero. Try again.");
                    continue;
                }
            } catch (final InputMismatchException e) {
                System.out.println("You have entered an invalid input. Try again.");
                readInput.next(); // discard non-float input
                if (count == 0){
                    //if the first input is invalid
                    //discard the second input
                    readInput.next();
                }
                continue;
            }
        } while (true);
        return twoFloats;
    }

    //calculate and display results
    public void displayResults() {
        do {
            //if calcOption is 1 (1 or A or a), then call add function to operate the two floats
            //same goes for subtract, multiply, divide and exit
            if (calcOption == 1)
                add(twoFloats);
            else if (calcOption == 2)
                subtract(twoFloats);
            else if (calcOption == 3)
                multiply(twoFloats);
            else if (calcOption == 4)
                divide(twoFloats);
            else
                System.out.printf("\nThank you for using Hongling Lei's Handy Calculator");
            System.out.println("\nPress ENTER key to continue...");
            readInput.nextLine();
        } while (!readInput.nextLine().equals(""));
    }

    //thanks the user for using and waits for ENTER key to end the program
    public void displayBye() {
        do {
            readInput.nextLine();
            System.out.println("Thanks for using Hongling Lei's Handy Calculator. Press ENTER key to end.");
        } while (!readInput.nextLine().equals(""));
    }
}

//driver program that calls the above OOP class
public class TestCalculator {
    public static void main(String[] args) {
        OOPCalculator calc = new OOPCalculator();
        while (calc.askCalcChoice() != 5){ //it will set choice
            calc.askTwoValues(); //it will set two values
            calc.displayResults(); //do calc, display result and wait on press enter key
        }
        calc.displayBye(); //thanks the user for using and waits for press enter key
    } //end main
} //end class