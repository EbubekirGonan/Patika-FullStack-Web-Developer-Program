import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //The taximeter costs 2.20 TL per KM.
        //The minimum amount to be paid is 20 TL.
        //For fees under 20 TL, 20 TL will still be charged.
        //Taximeter startPrice is 10 TL.

        double a, perKm = 2.20, taximeter, startPrice = 10;


        Scanner input = new Scanner(System.in);

        System.out.print("Please enter the distance: ");
        a = input.nextInt();

        taximeter = (a * perKm) + startPrice;
        taximeter = (taximeter < 20) ? 20 : taximeter;
        System.out.print("Taximeter is: " + taximeter);

    }
}