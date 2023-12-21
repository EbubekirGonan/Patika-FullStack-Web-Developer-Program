import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        
        int number;
        Scanner inp = new Scanner(System.in);
        System.out.print("Please enter a value: ");
        number = inp.nextInt();

        int [] arr = {12, 15,788,1,-1,-778,2,0};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        int min = arr[0];
        int max = arr[arr.length-1];

        for(int i: arr) {
            if (i < number && i > min){
                min = i;
            }
            if (i > number && i < max){
                max = i;
            }
        }

        System.out.println("Dizinin en küçük sayısı: " + arr[0]);
        System.out.println("Dizinin en küçük sayısı: " + arr[arr.length -1]);
        System.out.println("Girdiğiniz " + number + " sayısından küçük, en büyük sayı: " + min);
        System.out.println("Girdiğiniz " + number + " sayısından büyük, en küçük sayı: " + max);

    }
}