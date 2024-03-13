import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        double a, b, c, s, area;

        Scanner input = new Scanner(System.in);

        System.out.print("Please enter value of first edge: ");
        a = input.nextDouble();

        System.out.print("Please enter value of second edge: ");
        b = input.nextDouble();

        System.out.print("Please enter value of third edge: ");
        c = input.nextDouble();

        s = (a + b + c) / 2;
        area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        System.out.print(area);

    }
}