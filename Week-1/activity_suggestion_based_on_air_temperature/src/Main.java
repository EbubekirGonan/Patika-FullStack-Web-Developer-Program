import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //call scanner class
        Scanner input = new Scanner(System.in);

        //demand for value
        System.out.print("Please enter Air Temperature: ");
        int heat = input.nextInt();

        //if else structure for suggestion
        if (heat < 5) {
            System.out.println("Kayak yapmaya gidebilirsiniz.");
        } else if (heat >= 5 && heat < 25) {
            if (heat < 15) {
                System.out.println("Sinemaya gidebilirsiniz.");
            }
            if (heat > 10) {
                System.out.println("Pikniğe gidebilirsiniz.");
            }
        } else {
            System.out.print("Yüzmeye gidebilirsiniz.");
        }

    }
}
