import java.util.Scanner;

public class Temperature {

    /**
     * @param readInput
     * : Scanner that takes in user input
     * @param weeklyTemp
     * : array that contains 7 temperatures for the week
     * This method asks the user to enter 7 temperatures for the week
     */
    public static void getTemperatures(Scanner readInput, int[] weeklyTemp) {
        int i;
        System.out.print("Please enter 7 temperatures (integers) during this week, separated by space: ");
        for (i = 0; i < 7; i++) {
            weeklyTemp[i] = readInput.nextInt();
        }
    }

    /**
     * @param weeklyTemp
     * : array that contains 7 temperatures for the week
     * This method prints the 7 temperatures for the week
     */
    public static void printTemperatures(int[] weeklyTemp) {
        int i;
        System.out.println("\nTemperatures in this week are: ");
        for (i = 0; i < 7; i++) {
            System.out.printf("%d\n", weeklyTemp[i]);
        }
    }

    /**
     * @param weeklyTemp
     * : array that contains 7 temperatures for the week
     * @return
     * This method returns the maximum temperature of the week
     */
    public static int getMax(int[] weeklyTemp) {
        int i;
        int max = weeklyTemp[0];
        for (i = 0; i < 7; i++) {
            if (weeklyTemp[i] > max)
                max = weeklyTemp[i];
        }
        return max;
    }

    /**
     * @param weeklyTemp
     * : array that contains 7 temperatures for the week
     * @return
     * This method returns the minimum temperature of the week
     */
    public static int getMin(int[] weeklyTemp) {
        int i;
        int min = weeklyTemp[0];
        for (i = 0; i < 7; i++) {
            if (weeklyTemp[i] < min)
                min = weeklyTemp[i];
        }
        return min;
    }

    /**
     * @param weeklyTemp
     * : array that contains 7 temperatures for the week
     * @return
     * This method returns the average temperature of the week
     */
    public static float getAverage(int[] weeklyTemp) {
        int i;
        float total = 0, average;
        for (i = 0; i < 7; i++) {
            total += weeklyTemp[i];
        }
        average = total / weeklyTemp.length;
        return average;
    }

    /**
     * @param min
     * : minimum temperature calculated before
     * @param max
     * : maximum temperature calculated before
     * @param average
     * : average temperature calculated before
     * This method prints mimumum, maximum and average of this week's temperatures using above methods
     */
    public static void printStatistics(int min, int max, float average){
        // min, max, average are all passed from the main method
        System.out.printf("\nMin temperature in this week is: %d ", min);
        System.out.printf("\nMax temperature in this week is: %d", max);
        System.out.printf("\nAverage temperature in this week is: %5.2f", average);
    }

    /**
     * @param args
     * main method that calls the above static methods
     */
    public static void main(String[] args){
        Scanner readInput = new Scanner(System.in);
        int weeklyTemp[] = new int[7];
        int max;
        int min;
        float average;
        getTemperatures(readInput, weeklyTemp);
        printTemperatures(weeklyTemp);
        min = getMin(weeklyTemp);
        max = getMax(weeklyTemp);
        average = getAverage(weeklyTemp);
        printStatistics(min, max, average);
    }
}
