import java.beans.Customizer;
import java.util.Scanner;

public class Homework4 {
/*4.1 Use paper computer to count loop times
    a) 10 times
    b) 9 times
    c) 0 time
*/

//4.2 while-loop box
    public static void WhileLoopBox(){
        //define variables
        int a = 0;
        int b = 0;
        int d = 0;

        //print top horizontal line
        while (a++ < 20){
            System.out.print("-");
        }

        //start from a new line
        System.out.print("\n");
        //print middle part
        while (b++ < 8){
            int c = 0;
            System.out.print("|");
            while (c++ < 18){
                System.out.print(" ");
            }
            System.out.print("|");
            System.out.print("\n");
        }

        //print bottom horizontal line
        while (d++ < 20){
            System.out.print("-");
        }
        System.out.print("\n");
    }

//4.3 do-while-loop box
    public static void DoWhileLoopBox(){
        //define variables
        int a = 0;
        int b = 0;
        int d = 0;

        //print first horizontal line
        do {
            System.out.print("-");
            a++;
        } while (a < 20);

        //start from a new line
        System.out.print("\n");
        //print middle part
        do {
            int c = 0;
            System.out.print("|");
            do {
                System.out.print(" ");
                c++;
            } while (c < 18);
            System.out.print("|");
            System.out.print("\n");
            b++;
        } while (b < 8);

        //print bottom horizontal line
        do {
            System.out.print("-");
            d++;
        } while (d < 20);
        System.out.print("\n");
    }

//4.4 for-loop box
    public static void ForLoopBox(){
        //print first horizontal line
        for (int a = 0; a < 20; a++){
            System.out.print("-");
        }

        //start from a new line
        System.out.print("\n");
        //print middle part
        for (int b = 0; b < 8; b++){
            System.out.print("|");
            for (int c = 0; c < 18; c++){
                System.out.print(" ");
            }
            System.out.print("|");
            System.out.print("\n");
        }

        //print bottom horizontal line
        for (int d = 0; d < 20; d++){
            System.out.print("-");
        }
        System.out.print("\n");
    }

//4.5 Take input from users, based on 4.4 for-loop
    public static void CustomizedBox(){
        //define variables
        int height;
        int width;
        char horizontal;
        char vertical;

        //take input from the user
        Scanner readInput = new Scanner(System.in);
        System.out.print("Enter the height: ");
        height = readInput.nextInt();
        System.out.print("Enter the width: ");
        width = readInput.nextInt();
        System.out.print("Enter the horizontal character: ");
        horizontal = readInput.next().charAt(0);
        System.out.print("Enter the vertical character: ");
        vertical = readInput.next().charAt(0);

        //print first horizontal line
        for (int a = 0; a < width; a++){
            System.out.print(horizontal);
        }

        //start from a new line
        System.out.print("\n");
        //print middle part
        for (int b = 0; b < height-2; b++){
            System.out.print(vertical);
            for (int c = 0; c < width-2; c++){
                System.out.print(" ");
            }
            System.out.print(vertical);
            System.out.print("\n");
        }

        //print bottom horizontal line
        for (int d = 0; d < width; d++){
            System.out.print(horizontal);
        }
        System.out.print("\n");
    }

//4.6
    public static void RepeatBox(){
        char answer;
        do {
            //define variables
            int height;
            int width;
            char horizontal;
            char vertical;

            //take input from the user
            Scanner readInput = new Scanner(System.in);
            System.out.print("Enter the height: ");
            height = readInput.nextInt();
            System.out.print("Enter the width: ");
            width = readInput.nextInt();
            System.out.print("Enter the horizontal character: ");
            horizontal = readInput.next().charAt(0);
            System.out.print("Enter the vertical character: ");
            vertical = readInput.next().charAt(0);

            //print first horizontal line
            for (int a = 0; a < width; a++){
                System.out.print(horizontal);
            }

            //start from a new line
            System.out.print("\n");
            //print middle part
            for (int b = 0; b < height-2; b++){
                System.out.print(vertical);
                for (int c = 0; c < width-2; c++){
                    System.out.print(" ");
                }
                System.out.print(vertical);
                System.out.print("\n");
            }

            //print bottom horizontal line
            for (int d = 0; d < width; d++){
                System.out.print(horizontal);
            }
            System.out.print("\n");

            //ask the user if s/he wants to continue
            System.out.print("Continue? Type \"y\" for yes/ \"n\" for no: ");
            readInput.nextLine();
            answer = readInput.next().charAt(0);
        } while (answer == 'y');
        System.out.printf("Thank you for using my DrawBox program.\n");
    }

//call above operations
    public static void main(String[] args) {
        //4.1
        System.out.println("4.1:");
        System.out.println("a) 10 times");
        System.out.println("b) 9 times");
        System.out.println("c) 0 times\n");

        //4.2
        System.out.println("4.2:");
        WhileLoopBox();
        System.out.print("\n");

        //4.3
        System.out.println("4.3:");
        DoWhileLoopBox();
        System.out.print("\n");

        //4.4
        System.out.println("4.4:");
        ForLoopBox();
        System.out.print("\n");

        //4.5
        System.out.println("4.5:");
        CustomizedBox();
        System.out.print("\n");

        //4.6
        System.out.println("4.6:");
        RepeatBox();
    }
}
