import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        //declare variables
        int birthYear, remain;
        String zodiac = "";

        //call scanner class
        Scanner input = new Scanner(System.in);

        //demand for values
        System.out.print("Please enter your birth year: ");
        birthYear = input.nextInt();

        //finding remain from birth year
       remain = birthYear % 12;

       //according to the remainder find zodiac
       switch (remain) {
           case 0 :
               zodiac = "monkey";
               break;
           case 1 :
               zodiac = "rooster";
               break;
           case 2 :
               zodiac = "dog";
               break;
           case 3 :
               zodiac = "pig";
               break;
           case 4 :
               zodiac = "rat";
               break;
           case 5 :
               zodiac = "ox";
               break;
           case 6 :
               zodiac = "tiger";
               break;
           case 7 :
               zodiac = "rabbit";
               break;
           case 8 :
               zodiac = "dragon";
               break;
           case 9 :
               zodiac = "snake";
               break;
           case 10 :
               zodiac = "horse";
               break;
           case 11 :
               zodiac = "goat";
       }
       System.out.print("Your chinese zodiac is: " + zodiac);
    }
}