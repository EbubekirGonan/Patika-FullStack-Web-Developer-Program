import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //call scanner class
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a value: ");
        //declare values
        int n = input.nextInt();
        int width = (2 * n) - 1;

        //ascending to the longest line
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= (n - i); k++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        //in descending order
        for (int i = 1; i <= (n - 1); i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= (width - (2 * i)); k++) {
                System.out.print("*");
            }
            System.out.println();
        }


    }
}