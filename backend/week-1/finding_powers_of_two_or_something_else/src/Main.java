import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        //declare values
        int n, i;

        //call scanner class
        Scanner input = new Scanner(System.in);

        //demand for value
        System.out.print("Please enter a value: ");
        n = input.nextInt();

        //for loops
        System.out.println("Powers of 4: ");
        for (i = 1; i <= n; i *= 4){
            System.out.println(i);
        }
        System.out.println();

        System.out.println("Powers of 5: ");
        for (i = 1; i <= n; i *= 5){
            System.out.println(i);
        }

    }
}