import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a value: ");
        int num = input.nextInt();

        //declare values
        int numValue;
        int result = 0;

        //while structure for sum of numeric values
        while (num != 0) {
            numValue = num % 10;
            result += numValue;
            num /= 10;
        }

        System.out.print(result);

    }
}