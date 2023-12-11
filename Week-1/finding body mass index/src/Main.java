import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        double a, b, bmi;

        Scanner input = new Scanner(System.in);

        System.out.print("Please enter your height: ");
        a = input.nextDouble();

        System.out.print("Please enter your weight: ");
        b = input.nextDouble();

        bmi = b / (a * a);
        System.out.print("Your body mass index: " + bmi);

    }
}