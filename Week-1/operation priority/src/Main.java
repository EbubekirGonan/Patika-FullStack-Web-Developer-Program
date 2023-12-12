import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int a, b, c;

        Scanner input = new Scanner(System.in);

        System.out.print("Please enter a value: ");
        a = input.nextInt();

        System.out.print("Please enter a value: ");
        b = input.nextInt();

        System.out.print("Please enter a value: ");
        c = input.nextInt();

        System.out.print(a + " + " + b + " * " + c + " - " + b + " = " + (a + b * c - b));


    }
}