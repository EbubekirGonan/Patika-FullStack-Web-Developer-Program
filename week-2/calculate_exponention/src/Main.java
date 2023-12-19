import java.util.Scanner;
public class Main {

    //Description method
    static int expo(int b,int n) {
        if (n == 0) {
            return 1;
        }
        return b * expo(b, n - 1);
    }
    //main method
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        //demand for base and exponent
        System.out.print("Please enter base: ");
        int b = inp.nextInt();
        System.out.print("And exponent: ");
        int n = inp.nextInt();
        //print result
        System.out.print(b + " to the " + n + "(th): " + expo(b, n));
    }
}


