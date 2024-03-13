import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        //değişkenleri tanımla
        int n, t;
        int min, max;

        //scanner sınıfını çağır
        Scanner input = new Scanner(System.in);

        //kaç elemanlı olduğunu iste
        System.out.print("Enter number of elements: ");
        n = input.nextInt();

        //önce bir sayı alıp max ve min değerlere atıyoruz.
        System.out.print("First number: ");
        max = input.nextInt();
        min = max;

        //sonra gelen sayıları karşılaştırma yaparak max ve min değerleri güncelliyoruz.
        // 2.den itibaren gelen her bir sayı max'tan büyük mü ya da min'den küçük mü
        // kontrolü sağlanıyor.
        // max'tan büyükse max'a, min'den küçükse min'e atanıyor.
        for (int i = 2; i <= n; i++) {
            System.out.print("Another one: ");
            t = input.nextInt();
            if (t > max) {
                max = t;
            } else if (t < min){
                min = t;
            }


        }
        System.out.println("Max value: " + max);
        System.out.println("Min value: " + min);



    }
}

