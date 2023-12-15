import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        //declare values
        int k, sum = 0;
        int t = 0;

        //call scanner class
        Scanner input = new Scanner(System.in);

        //demand for value
        System.out.print("Please enter a value: ");
        k = input.nextInt();

        //for loop and if structure
        for (int i = 1; i <= k; i++) { int average;
            if(i % 3 == 0 || i % 4 == 0) {
                //t is number of prints of the i value
                t++;
                System.out.println(i);
                sum += i;
            }
        }
        System.out.print("Average = " + sum / t);
    }
}