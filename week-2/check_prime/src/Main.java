import java.util.Scanner;
public class Main {

    //description method
    static boolean isPrime (int num){
        if(num<=1){
            return false;
        }
        for (int i=2; i<=num/2; i++){
            if(num%i == 0){
                return false;
            }
        }return true;
    }


    //main method
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Please enter a number to check if it's prime: ");
        //get number
        int num = inp.nextInt();

        if (isPrime(num))
            System.out.print(num + " is a prime number");
        else
            System.out.print(num + " is not a prime number");

    }
}
