import java.util.Scanner;
public class Main {

    //2 fonksiyon tanımlandı. f ve g fonksiyonları.
    //f fonksiyonu sayı 0 ya da negatif olana kadar sayısı 5 azaltır ve g fonksiyonunu çağırır.
    //g fonksiyonu 2 parametre tutar. ilk f fonksiyonundan aldığı, ikincisi kullanıcının girdiği değerler.
    //g fonksiyonu ilk değeri bulana kadar sayıya 5 ekler.
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

        //burada f fonkisoyunundan gelen değer g fonksiyonuna aktarılır
        int j =f(n);
        //g; hem j'yi hem de n'i tutar.
        g(j, n);
    }
}

