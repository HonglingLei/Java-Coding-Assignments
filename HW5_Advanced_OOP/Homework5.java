import java.util.Scanner;

//two interfaces
interface Menu {
    void displayMenuStart();
    void checkMenuInput();
}

interface Float {
    void displayFloatStart();
    void checkFloatInput();
}

interface Temperatures {
    void printDaily();
    void minTemp();
    void maxTemp();
    void avgTemp();
}


//classes that implements these interfaces
class MenuSorting implements Menu {
    //display the beginning paragraph of the menu
    public void displayMenuStart() {
        System.out.println("Welcome to sorting program\n");
        System.out.println("\t 1. Title");
        System.out.println("\t 2. Rank");
        System.out.println("\t 3. Date");
        System.out.println("\t 4. Stars");
        System.out.println("\t 5. Likes\n\n");
    }
    //read input from user
    public void checkMenuInput(){
        String input;
        Scanner readInput = new Scanner(System.in);

        do {
            System.out.print("Enter your choice between 1 and 5 only: ");
            input = readInput.nextLine();
            //if input length is greater than 1, then it must be invalid
            if (input.length() > 1) {
                System.out.println("You have entered an invalid choice. Try again.");
            }
            //if input's ASCII code is < 48 or > 57 (0's ASCII is 48, 9's ASCII is 57), then this input's first char is not a number
            else if (input.charAt(0) < 48 || input.charAt(0) > 57) {
                System.out.println("You have not entered a number. Try again.");
            }
            //if this input is a number, but its ASCII code is < 49 (1's ASCII) or > 53 (5's ASCII), then this number is not among 1-5.
            else if (input.charAt(0) < 49 || input.charAt(0) > 53) {
                System.out.println("You have not entered a number between 1 and 5. Try again.");
            }
            //else the input must be among 1,2,3,4,5
            else {
                System.out.println("\nYou entered valid choice " + input);
                System.out.println("Thank you for giving your choice\n\n");
            }
        } while (input.charAt(0) < 49 || input.charAt(0) > 53);
    }
}


class TwoFloats implements Float{
    //display the beginning paragraph of the floats program
    public void displayFloatStart() {
        System.out.println("Welcome to get two floats program\n\n");
    }
    //read input from user
    public void checkFloatInput() {
        float input1;
        float input2;
        char checkResult;
        do {
            //scanner MUST be included in this do-while loop
            //如果不重置Scanner对象sc将会总在while死循环try catch,原因是Scanner对象发生异常后就不能再被使用,所以一直报异常,编程了死循环
            Scanner readInput = new Scanner(System.in);
            System.out.print("Enter two floats separated by a space: ");
            checkResult = 'r';
            //try and catch method to check if inputs are floats
            try {
                //if these two inputs are floats
                input1 = readInput.nextFloat();
                input2 = readInput.nextFloat();
                System.out.println("\nYou entered two valid floats: " + input1 + " and " + input2);
                System.out.println("Thank you for giving two floats\n\n");
            } catch (Exception e) {
                System.out.println("You have entered an invalid input. Try again.");
                //if there is any error, check result turns "wrong"
                checkResult = 'w';
            }
        } while (checkResult == 'w');
    }
}


class Temps implements Temperatures{
    int weeklyTemp[] = {69,70,71,68,66,71,70};
    //print the daily temperature
    public void printDaily() {
        //define variables
        for (int i = 0; i < 7; i++){
            System.out.println("The temperature on day " + (i+1) + " was " + weeklyTemp[i]);
        }
    }
    //min temperature of the week
    public void minTemp() {
        int min = weeklyTemp[0];
        for (int i = 0; i < 6; i++){
            if (weeklyTemp[i] < weeklyTemp[i+1])
                min = weeklyTemp[i];
        }
        System.out.println("\nThe minimum temperature is: " + min);
    }
    //max temperature of the week
    public void maxTemp() {
        int max = weeklyTemp[0];
        for (int i = 0; i < 6; i++){
            if (weeklyTemp[i+1] > weeklyTemp[i])
                max = weeklyTemp[i+1];
        }
        System.out.println("The maximum temperature is: " + max);
    }
    //average temperature of the week
    public void avgTemp(){
        float total = 0, average;
        for (int i = 0; i < 7; i++){
            total += weeklyTemp[i];
        }
        average = total / 7;
        System.out.println("The average temperature is: " + average);
    }
}

//main class that calls the above
public class Homework5{
    public static void main(String[] args){
        //5.1
        MenuSorting menu = new MenuSorting();
        System.out.println("5.1");
        menu.displayMenuStart();
        menu.checkMenuInput();

        //5.2
        TwoFloats floats = new TwoFloats();
        System.out.println("5.2");
        floats.displayFloatStart();
        floats.checkFloatInput();

        //5.3
        Temps temps = new Temps();
        System.out.println("5.3");
        temps.printDaily();
        temps.minTemp();
        temps.maxTemp();
        temps.avgTemp();
        System.out.println("\nThank you for using my homework #5 solution");
    }
}
