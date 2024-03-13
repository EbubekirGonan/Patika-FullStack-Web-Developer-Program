import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        System.out.print("Please enter number of elemens: ");
        int N= input.nextInt();

        //0 ve 1 diye değişkenleri tanımladım
        int m=0, n=1;
        //bunların toplamına t dedim
        int t = m+ n;

        //0 ve 1'i diziye en başta diziye dahil edemedim. Onun yerine düz bi şekilde ekledi
        //dolayısıyla i'yi de 3'ten başlatmak zorunda kaldım.
        //her seferinde her birini bir yanındakine eşitleyerek
        //son iki değerin toplamını yazdırmış oluyoruz.
        System.out.println("0\n1");
        for(int i=3; i<=N; i++){
            System.out.println(t);
            m = n;
            n = t;
            t = m + n;
        }
    }
}