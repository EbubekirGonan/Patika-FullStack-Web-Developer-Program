import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        //declare values
        int n;
        int total =0;

        //call scanner class
        Scanner input = new Scanner(System.in);

        // do-while structure
        do {
            //demand for value
            System.out.print("Please enter a value: ");
            n =input.nextInt();
            if(n % 4 == 0) {
                total += n;
            }
        } while (n % 2 == 1);
        System.out.print("Total: " + total);

    }
}