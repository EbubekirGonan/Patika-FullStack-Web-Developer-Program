import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        //declare variables
        int a, b, c;

        //call scanner class
        Scanner input = new Scanner(System.in);

        //demand for values
        System.out.print("Please enter first value: ");
        a = input.nextInt();

        System.out.print("Please enter second value: ");
        b = input.nextInt();

        System.out.print("Please enter third value: ");
        c = input.nextInt();

        // if else structure for sorting
        if ((a > b) && (a > c)) {
            if (b > c) {
                System.out.print("a > b > c");
            } else {
                System.out.print("a > c > b");
            }
        } else if ((b > a) && (b > c)) {
            if (a > c) {
                System.out.print("b > a > c");
            } else {
                System.out.print("b > c > a");
            }
        } else {
            if (b > a) {
                System.out.print("c > b > a");
            } else {
                System.out.print("c > a > b");
            }
        }

    }
}