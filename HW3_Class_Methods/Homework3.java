import java.util.Scanner;

public class Homework3<answer> {

//3.1
    public static void AgeClassifier() {
        float yourAge;
        Scanner readInput = new Scanner(System.in);
        System.out.printf("How old are you?: ");
        yourAge = readInput.nextFloat();
        if (yourAge < 13)
            System.out.printf("You are a kid.\n\n");
        else if (yourAge <= 19)
            System.out.printf("You are a teenager.\n\n");
        else
            System.out.printf("You are an adult.\n\n");
    }

//3.2
    public static void Calculator() {
        float firstN;
        float secondN;
        char operator;
        char answer;

        do {
            Scanner readInput = new Scanner(System.in);

            System.out.printf("Type a number, operator, number --" + "separated by a space: ");

            firstN = readInput.nextFloat();
            operator = readInput.next().charAt(0);
            secondN = readInput.nextFloat();

            if (operator == '+')
                System.out.printf("%f + %f = %f",
                        firstN, secondN, firstN + secondN);
            else if (operator == '-')
                System.out.printf("%f - %f = %f",
                        firstN, secondN, firstN - secondN);
            else if (operator == '*')
                System.out.printf("%f * %f = %f",
                        firstN, secondN, firstN * secondN);
            else if (operator == '/')
                System.out.printf("%f / %f = %f",
                        firstN, secondN, firstN / secondN);
            else if (operator == '%')
                System.out.printf("%f %% %f = %f",
                        firstN, secondN, firstN % secondN);
            else
                System.out.printf("Unknown operator");
            //为什么用前面四个operator时计算正常，而计算完后会报Unknown operator??为什么%就不会报？
            //因为之前写的时候全是if，没有用elseif；所以每个条件都会判断。第一个对了，第二个必然错。而%在最后的位置，所以它对了不会报错

            System.out.printf("\n\n");
            System.out.printf("Continue? Type \"y\" for yes/ \"n\" for no: ");
            readInput.nextLine();
            answer = readInput.next().charAt(0);
        } while (answer == 'y'); //之前do while报错的原因是，answer定义到了do的里面。实际上变量应该在外面定义
        System.out.printf("Thank you for using my Calculator program.\n\n");
    }

//3.3
    public static void Max() {
        int max, a, b, c;
        char answer;
        do {
            Scanner readInput = new Scanner(System.in);

            System.out.printf("Enter three integer numbers to find the max of them --" + "separated by a space: ");
            a = readInput.nextInt();
            b = readInput.nextInt();
            c = readInput.nextInt();

            //using if else
            if (a > b) {
                max = a;
            } else if (b > c) {
                max = b;
            } else {
                max = c;
            }
            //using ternary operator
            max = (((a > b) ? a : b) > c) ? ((a > b) ? a : b) : c;
            System.out.print("The Max is : " + max);
            System.out.printf("\n\n");

            System.out.printf("Continue? Type \"y\" for yes/ \"n\" for no: ");
            readInput.nextLine();
            answer = readInput.next().charAt(0);
        } while (answer == 'y');
        System.out.printf("Thank you for using my Max program.\n");
    }

    public static void main(String[] args) {
        AgeClassifier();
        Calculator();
        Max();
    }
}