import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Please enter a value:");

        double a;
        a = input.nextDouble();


        if (a < 1000) {
            double vat = 0.18;
            System.out.println("Without tax: " + a);
            System.out.println("Price with vat is: " + (a + (a * vat)));
            System.out.println("Tax value is: " + (a * vat));
        } else if (a >= 1000) {
            double vat = 0.08;
            System.out.println("Without tax: " + a);
            System.out.println("Price with vat is: " + (a + (a * vat)));
            System.out.println("Tax value is: " + (a * vat));

        }


    }
}

