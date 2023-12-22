import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int number= rand.nextInt(100);
        Scanner inp = new Scanner(System.in);
        int right = 0;
        int selected;
        int [] wrong = new int[5];
        boolean isWin = false;
        boolean isWrong = false;
        while (right< 5){
            System.out.print("LÜtfen tahmininizi giriniz:");
            selected = inp.nextInt();

            if(selected <0 || selected>100){
                System.out.println("Lütfen 0-100 arası bir sayı giriniz");
                if(!isWrong){
                    isWrong = true;
                    System.out.println("Bir daha hatalı girişinizde hakkınızdan düşecektir.");
                } else {
                    System.out.println("Çok fazla hatalı giriş yaptınız. Kalan hakkınız: " + (5-(++right)));
                }
                continue;
            }
            if(selected== number){
                System.out.println("Tebrikler doğru tahmin.");
                isWin=true;
                break;
            }
            else{
                wrong [right++] = selected;
                System.out.println("Hatalı bir sayı girdiniz");
                if (selected > number){
                    System.out.println(selected + " sayısı gizli sayıdan büyük. Daha küçük bir sayı deneyin.");
                } else {
                    System.out.println(selected + " sayısı gizli sayıdan küçük. Daha büyük bir sayı deneyin.");
                }
                System.out.println("Kalan hakkınız: " + (5 - right));
            }
        }
        if(right == 5 && !isWin){
            System.out.println("Kaybettiniz.");
            System.out.println("Gizli sayı: " + number);
            System.out.println("Tahminleriniz " + Arrays.toString(wrong));
        }

    }
}