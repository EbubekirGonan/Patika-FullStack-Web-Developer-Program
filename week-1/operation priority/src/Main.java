import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        //declare variables
        int a, b, c, result;

        //call scanner class
        Scanner input = new Scanner(System.in);

        //demand for first value
        System.out.print("Please enter first value: ");
        a = input.nextInt();

        //demand for second value
        System.out.print("Please enter second value: ");
        b = input.nextInt();

        //demand for third value
        System.out.print("Please enter third value: ");
        c = input.nextInt();

        //find result with operation priority
        result = a + b * c - b;
        System.out.print(a + " + " + b + " * " + c + " - " + b + " = " + result);


    }
}