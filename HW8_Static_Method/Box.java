import java.security.PrivilegedExceptionAction;
import java.util.Scanner;

public class Box {

    /**
     * @param hChar1
     * : horizontal character set by user
     * @param wd1
     * : box width set by user
     * This method draws a horizontal line
     * based on user's choice of horizontal character and box width
     */
    public static void drawHorizontalLine(char hChar1, int wd1) {
        for (int x = 1; x <= wd1; x++) { //loop until it reaches the box width
            System.out.print("" + hChar1);
        }
    }

    /**
     * @param vChar1
     * : vertical character set by user
     * @param ht1
     * : box height set by user
     * @param wd1
     * : box width set by user
     * This method draws a vertical line
     * based on user's choice of vertical character, box height and box width
     */
    public static void drawVerticalLine(char vChar1, int ht1, int wd1) {
        System.out.print("\n"); // start from another line
        for (int x = 1; x <= ht1 - 2; x++) { // loop until it reaches the box height-2
            System.out.print(vChar1); // the first vertical character on each line
            for (int y = 1; y <= wd1 - 2; y++) // loop until it reaches the box width-2
                System.out.print(" "); // empty space inside the box
            System.out.print(vChar1); // the second vertical character on each line
            System.out.print("\n"); // start from another line
        }
    }

    /**
     * @param readInput
     * : Scanner to take user input
     * @param hChar1
     * : horizontal character
     * @param vChar1
     * : vertical character
     * @param wd1
     * : box width
     * @param ht1
     * : box height
     * This method calls the drawHorizontalLine and the drawVerticalLine methods to draw the box
     * and asks if the user wants to continue
     * and loops until the user doesn't want to continue anymore
     */
    public static void drawBox(Scanner readInput, char hChar1, char vChar1, int wd1, int ht1){
        char answer = 'y';
        while (answer == 'y'){ // loop until the user doesn't want to continue anymore
            // take in user input of height, width, horizontal character, vertical character
            System.out.print("\nPlease enter height of the box: ");
            ht1 = readInput.nextInt();
            System.out.print("\nPlease enter width of the box: ");
            wd1 = readInput.nextInt();
            readInput.nextLine(); // clean the buffer
            System.out.print("\nPlease enter the horizontal characters to draw the box: ");
            hChar1 = readInput.nextLine().charAt(0);
            System.out.print("\nPlease enter the vertical characters to draw the box: ");
            vChar1 = readInput.nextLine().charAt(0);

            // start from another line
            System.out.println("");
            // draw the first horizontal line
            drawHorizontalLine(hChar1, wd1);
            // draw the middle parts
            drawVerticalLine(vChar1, ht1, wd1);
            // draw the second horizontal line (bottom line)
            drawHorizontalLine(hChar1, wd1);

            // ask user if s/he wants to continue
            System.out.print("\n\nContinue? Type \\'y' for yes: ");
            answer = readInput.nextLine().charAt(0);
        }
        System.out.println("\nThank you for using my draw box program."); // stop the program and thank the user
    }


    /**
     * @param args
     * main function
     */
    public static void main(String[] args){
        Scanner readInput = new Scanner(System.in);
        char hChar1 = '_';
        char vChar1 = '*';
        int ht1 = 10, wd1 = 20;
        drawBox(readInput, hChar1, vChar1, ht1, wd1);
    }
}
