import java.util.Scanner;
public class Main {

    //description method
    static boolean isPrime (int num, int divisor){
        if(divisor ==1){
            return true;
        }
        if(num % divisor == 0){
            return false;
        }return isPrime(num, divisor-1);
    }


    //main method
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Please enter a number to check if it's prime: ");
        //get number
        int num = inp.nextInt();

        if (isPrime(num, num -1))
            System.out.print(num + " is a prime number");
        else
            System.out.print(num + " is not a prime number");

    }
}
