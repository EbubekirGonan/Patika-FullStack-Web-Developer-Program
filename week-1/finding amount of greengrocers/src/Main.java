import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //declare variables
        double pearAmount, appleAmount, tomatoAmount, bananaAmount, eggplantAmount,
                pearPerKg, applePerKg, tomatoPerKg, bananaPerKg, eggplantPerKg,
                totalAmount;
        pearPerKg = 2.14;
        applePerKg = 3.67;
        tomatoPerKg = 1.11;
        bananaPerKg = 0.95;
        eggplantPerKg = 5.00;

        //call scanner class
        Scanner input = new Scanner(System.in);

        //demand for values
        System.out.print("Please enter how many kilos of pear: ");
        pearAmount = input.nextDouble() * pearPerKg;

        System.out.print("Please enter how many kilos of apple: ");
        appleAmount = input.nextDouble() * applePerKg;

        System.out.print("Please enter how many kilos of tomato: ");
        tomatoAmount = input.nextDouble() * tomatoPerKg;

        System.out.print("Please enter how many kilos of banana: ");
        bananaAmount = input.nextDouble() * bananaPerKg;

        System.out.print("Please enter how many kilos of eggplant: ");
        eggplantAmount = input.nextDouble() * eggplantPerKg;

        //calculate total amount
        totalAmount = pearAmount + appleAmount + tomatoAmount + bananaAmount + eggplantAmount;

        //print the bill
        System.out.println("---------------------------");
        System.out.println("Pear Amount: " + pearAmount);
        System.out.println("Apple Amount: " + appleAmount);
        System.out.println("Tomato Amount: " + tomatoAmount);
        System.out.println("Banana Amount: " + bananaAmount);
        System.out.println("Eggplant Amount: " + eggplantAmount);
        System.out.println("Total Amount: " + totalAmount);


    }
}