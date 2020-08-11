import java.io.PrintStream;
import java.util.Scanner;

public class Homework2 {

    //2.1
    public static void exercise_2_1() {
        int radius = 2;
        double area;
        final double pi = 3.142;

        area = pi * radius * radius;
        System.out.printf("The area is: %5.2f", area);
    }

    //2.2
    public static void exercise_2_2() {
        //extra line feed
        System.out.println("\n");

        float radius;
        double area;
        final double PI;

        Scanner readInput = new Scanner(System.in);
        System.out.print("Enter the radius: ");
        radius = readInput.nextFloat();
        System.out.print("Enter PI: ");
        PI = readInput.nextDouble();

        area = PI * radius * radius;

        System.out.print("The area is: ");
        System.out.println(area);
    }

    //2.3
    public static void exercise_2_3() {
        //extra line feed
        System.out.println();

        Scanner readInput = new Scanner(System.in);

        char your_initial;

        System.out.print("What is your first name?: ");
        your_initial = readInput.next().charAt(0);
        System.out.println("Hello Mr. " + your_initial + ".");
        readInput.nextLine(); //EXTREMELY IMPORTANT!!!!!

        System.out.println();
        System.out.printf("5185 is fun course.\n\n");
        System.out.printf("First Name\tLast Name\tCity\n");
        System.out.printf("----------\t---------\t---\n");
        System.out.printf("Bill      \tClinton  \tHarlem\n");

        System.out.println();
        System.out.print("How do you print double quotes?\n");
        System.out.print("Who said\"Test Scores Can Be Used ....\"\n\n");

        String first_name;
        String last_name;
        String city;
        int zip_code;

        System.out.print("Please enter your first name: ");
        first_name = readInput.nextLine();
        System.out.print("Please enter your last name: ");
        last_name = readInput.nextLine();
        System.out.print("Please enter your city: ");
        city = readInput.nextLine();
        System.out.print("Please enter your zip code: ");
        zip_code = readInput.nextInt();

        System.out.println();
        System.out.printf("First Name\tLast Name \tCity      \tZip Code \n");
        System.out.printf("----------\t----------\t----------\t----------\n");
        System.out.printf("%-12s%-12s%-12s%d", first_name, last_name, city, zip_code); //-12表示预留12个空位，向右补空格
    }


    public static void main(String[] args) {
        exercise_2_1();
        exercise_2_2();
        exercise_2_3();
    }
}