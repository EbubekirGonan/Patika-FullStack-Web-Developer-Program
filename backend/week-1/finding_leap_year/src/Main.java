import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        //declare variables
        int year;

        //call scanner class
        Scanner input = new Scanner(System.in);

        //demand for values
        System.out.print("Please enter a year: ");
        year = input.nextInt();

        //if-else structure for finding leap year
        if (year % 4 == 0) {
            if (year % 100 == 0 && year % 400 != 0) {
                System.out.print("This year is not a leap year.");
            } else {
                System.out.print("This year is a leap year.");
            }

        } else {
            System.out.print("This year is not a leap year.");
        }


    }
}