import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        //call scanner calss
        Scanner input = new Scanner(System.in);
        //get values
        System.out.print("Please enter a integer: ");
        int a = input.nextInt();

        System.out.print("Please enter a decimal: ");
        double b = input.nextDouble();

        // we can use temporary variable this stage
        double tempdouble = b;
        b = a;
        a = (int) tempdouble;

        System.out.println("This is decimal now: " + a);
        System.out.println("And this is integer: " + b);
    }
}