import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Dizinin kaç elemanlı olacağını giriniz: ");
        int n = inp.nextInt();
        int startIndex = 0;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print((startIndex + 1) + ". elemanı: ");
            arr[startIndex++] = inp.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}