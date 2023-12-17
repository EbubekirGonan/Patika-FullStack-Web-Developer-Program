import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //call scanner class
        Scanner input = new Scanner(System.in);
        System.out.print("Enter digit number: ");
        //declare variable
        int n = input.nextInt();

        //her yinelemede belli sayıda boşluk ve yıldız yazdırma algoritması
        //algorithm for printing a certain number of spaces and asterisks in each iterationH
        for (int i=1; i <= n; i++){
            for(int j=1; j <= i; j++){
                System.out.print(" ");
            }
            for (int k=1; k<= 2*n -2*i +1; k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}