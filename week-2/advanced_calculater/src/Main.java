import java.util.Scanner;
public class Main {

    //Descript methods:
    static int sum(int a, int b){
       int result = a + b;
        System.out.println("Sum is: " + result);
        return result;
    }

    static int minus(int a, int b){
        int result = a - b;
        System.out.println("Minus is: " + result);
        return result;
    }

    static int multi(int a, int b){
        int result = a * b;
        System.out.println("Multiply is: " + result);
        return result;
    }

    static double div(int a, int b) {
        int result = a / b;
        System.out.println("Ratio is: " + result);
        return result;
    }

    static int expo(int a, int b) {
        int result=1;
        for (int i=1; i<=b; i++) {
            result *= a;
        }
        System.out.println("Power is: " + result);
        return result;
    }

    static int fact(int a){
        int result=1;
        for(int i=a; i>0; --i){
            result *= i;
        }
        System.out.println(result);
        return result;
    }

    static int mod(int a, int b) {
        int result;
        result = a%b;
        System.out.println(result);
        return result;
    }

    static void calc(int a, int b){
        int area = a * b;
        int perim = 2 * (a+b);
        System.out.println("Area is: " + area);
        System.out.println("Perimeter is: " + perim);


    }
        //main method
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String menu = "1- Addition operation\n"
                + "2- Subtraction\n"
                + "3- Multiplication\n"
                + "4- Division\n"
                + "5- Exponential number\n"
                + "6- Factorial\n"
                + "7- Modular arithmetic\n"
                + "8- Calculation area and perimeter\n"
                + "0- Quit";

        while (true) {
            System.out.print(menu);
            System.out.println();
            System.out.print("Please choose an operation: ");
            int select = input.nextInt();
            if (select == 0) {
                break;
            }

            System.out.print("Enter first number: ");
            int a= input.nextInt();
            System.out.print("Enter second one: ");
            int b = input.nextInt();

            //switch case structure for choice
            switch (select) {
                case 1:
                    sum(a, b);
                    break;
                case 2:
                    minus(a, b);
                    break;
                case 3:
                    multi(a, b);
                    break;
                case 4:
                    div(a, b);
                    break;
                case 5:
                    expo(a, b);
                    break;
                case 6:
                    fact(a);
                    break;
                case 7:
                    mod(a, b);
                    break;
                case 8:
                    calc(a, b);
                    break;

            }
            System.out.print("Press any key to continue...");
            input.next();
            System.out.println();

        }
        System.out.print("See you...");
    }

}