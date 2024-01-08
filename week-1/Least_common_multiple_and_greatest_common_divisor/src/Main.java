import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int n1, n2;
        int gcd = 1, lcm;
        int i = 1;
        //gcd = ebob
        //lcm = ekok

        Scanner input = new Scanner(System.in);

        System.out.print("Enter first value: ");
        n1 = input.nextInt();
        System.out.print("Enter second one: ");
        n2 = input.nextInt();

        // i sayısı en başta 1 değerini taşıyor. i; n1'den ve n2'den küçük olduğu müddetçe
        // if döngüsünün içinde n1 ve n2'yi kalansız bölebiliyorsa ebob'a atanıyor. Sonra i sayısı
        // 1 arttırılıyor ve tekrar deneniyor.
        // if parantezi içindeki ifade her doğrulandığında ebob değeri güncelleniyor.
        while (i <= n1 && i <= n2){
            if (n1 % i == 0 && n2 % i == 0){
                gcd = i;
            }
            i++;
        }

        // ebob bulunduktan sonra ekoku bulmak daha kolay tabi :)
        lcm = (n1 * n2) / gcd;

        System.out.println("Greatest common divisor is: " + gcd);
        System.out.println("Least common multiple is: " + lcm);



    }
}