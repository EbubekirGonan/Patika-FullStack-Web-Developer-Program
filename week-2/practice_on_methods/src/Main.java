import java.util.Scanner;
public class Main {
    static int f(int n){
        if (n<= 0){
            return n;
        }
        System.out.print(n + " ");
        return f(n-5);
    }

    static int g(int j, int n){
        if (j-5 >= n){
            return j;
        }
        System.out.print(j + " ");
        return g(j+5, n);
    }

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        int n = inp.nextInt();

        int j =f(n);
        g(j, n);
    }
}

