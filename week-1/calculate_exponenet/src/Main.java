import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        //declare variables
        int b,n;
        int total = 1;

        //call scanner class
        Scanner input = new Scanner(System.in);

        //demand for values
        System.out.print("Please enter base: ");
        b = input.nextInt();

        System.out.print("Please enter exponent: ");
        n = input.nextInt();

        // i is a counter. We make the i rotate n times.
        // And each time we multiply the variable total, by base b.
        // Since this operation occurs n times,
        // we get the multiplication of base b, n times.
        for (int i= 1; i <= n; i++) {
            total *= b;
        }
        System.out.print(total);

        /*
        int i = 1;
        while(i <= n) {
            total *= b;
            i++;
        }
        System.out.print(total);
           */

    }
}