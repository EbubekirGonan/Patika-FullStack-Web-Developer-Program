import javax.script.ScriptContext;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //declare variables
        int a, b, select;

        //call scanner class
        Scanner input = new Scanner(System.in);

        //demand for first value
        System.out.print("Please enter first value: ");
        a = input.nextInt();

        //demand for second value
        System.out.print("Please enter second value: ");
        b = input.nextInt();

        //demand for select operation
        System.out.println("Please select operation: ");
        System.out.println("1 - Addition\n2 - Subtraction\n" +
                           "3 - Multiplication\n4 - Division\n");

        select = input.nextInt();

        //Switch-case structure
        switch (select){
            case 1:
                System.out.print(a + b);
                break;
            case 2:
                System.out.print(a - b);
                break;
            case 3:
                System.out.print(a * b);
                break;
            case 4:
                if(b == 0){
                    System.out.print("A number is not divisible by zero!");
                } else {System.out.print(a / b);
                }
                break;
            default:
                System.out.print("You made wrong choice! Try again.");

        }
    }
}