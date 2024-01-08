import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        //call scanner class
        Scanner input = new Scanner(System.in);

        //demand for values
        System.out.print("Please enter number of elements of the set: ");
        int n = input.nextInt();

        System.out.print("Please enter the number of elements you want to combine: ");
        int r = input.nextInt();

        // debug
        if (r < 0 || r > n) {
            System.out.print("Error");
        } else {
            //nFac = n!, etc.
            int nFac = 1; int rFac = 1; int tFac = 1;
            for (int i = 1; i <= n; i++) {
                nFac *= i;
            }
            for (int i = 1; i <= r; i++) {
                rFac *= i;
            }
            int t = n - r;
            // tFac = t! = (n -r)!
            for (int i = 1; i <= t; i++) {
                tFac *= i;
            }
            int comb = nFac / (rFac * tFac);
            System.out.print("Combination: " + comb);

        }
    }
}