import javax.security.sasl.SaslClient;
import java.util.Scanner;
public class Main {

    //Description method
    static int expo(int b,int n){
        int result=1;
        for(int i=1; i<=n; i++){
            result *= b;
        }
        return result;
    }
    //main method
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        //demand for base and exponent
        System.out.print("Please enter base: ");
        int b = inp.nextInt();
        System.out.print("And exponent: ");
        int n = inp.nextInt();
        //print result
        System.out.print(b + " to the " + n + "(th): " + expo(b, n));
    }
}