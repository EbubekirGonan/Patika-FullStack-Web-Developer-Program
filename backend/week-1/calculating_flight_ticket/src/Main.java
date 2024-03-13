import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        //declare variables
        double ageDiscount, tripTypeDiscount, bill = 0;
        int distance, age, tripType;

        //call scanner class
        Scanner input = new Scanner(System.in);

        //demand for values
        System.out.print("Please enter distance: ");
        distance = input.nextInt();

        System.out.print("Please enter your age: ");
        age = input.nextInt();

        System.out.println("Please enter your Trip Type: \nPress 1 to one way\nPress 2 to round trip...");
        tripType = input.nextInt();

        //The bill is calculated by taking 10% of the distance
        bill = distance * 0.1;

        // bill is calculated
        // if younger than 12, half of bill
        // between 12 and 24, %90 of bill
        // older than 65, %70 of bill
        if ((distance > 0) && (age > 0)) {
            if (age < 12) {
                bill *= 0.5;
            } else if (age <= 24) {
                bill *= 0.9;
            } else if (age >= 65) {
                bill *= 0.7;
            }
        } else {
            System.out.println("Yaş ve mesafe 0'dan büyük olmalı.");
        }

        // Trip type must be 1 or 2
        if ((tripType == 1 || tripType == 2)) {
            // if trip type is 2
            if (tripType == 2) {
                // bill is calculated %80 of previous bill
                // then it is multiplied 2, because of it is round trip
                bill *= 1.6;
            }
        } else {
            System.out.print("Yolculuk tipi seçerken hata yaptınız. Tekrar deneyin.");
        }
        System.out.print(bill + "$");

    }
}