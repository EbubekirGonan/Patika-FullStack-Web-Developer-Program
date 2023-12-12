import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        //declare variables
        double a, b, bmi;
        //bmi = body mass index

        //call scanner class
        Scanner input = new Scanner(System.in);

        //demand for values
        System.out.print("Please enter your height: ");
        a = input.nextDouble();

        System.out.print("Please enter your weight: ");
        b = input.nextDouble();

        //find bmi result
        bmi = b / (a * a);
        System.out.print("Your body mass index: " + bmi);

    }
}