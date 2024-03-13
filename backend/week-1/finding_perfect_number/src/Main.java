import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        //scanner sınıfı çağır
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        //değişkenleri tanımla
        int n = input.nextInt();
        int total = 0;
        int result;

        //1'den girilen sayıya kadar
        //girilen sayıyı tam bölen sayılar
        // total değişkeninde toplanır.

        for (int i = 1; i <= n; i++) {
            if(n%i == 0){
                total += i;
            }
        }

        //bu toplama sayının kendisi dahil edilmeyeceği için toplamdan çıkarılır.
        //eğer sonuç girilen sayıya eşitse
        //sayı perfect number'dır
        //değilse değildir.

        result = total - n;
        if (result == n){
            System.out.print(n + " is a perfect number.");
        } else {
            System.out.print(n + " is not a perfect number.");
        }
    }
}