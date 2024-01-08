import java.util.Scanner;

public class Main {

    //Define check index method
    public static void checkIndex(int select) throws Exception {
        //if select less then 0 or greater then 10
        //throw new exception
        if (select < 0 || select >= 10) {
            throw new Exception();
        }
    }

    public static void main(String[] args) {

        //define random array
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        Scanner input = new Scanner(System.in);
        System.out.print("Lütfen dizin almak istediğiniz index'ini giriniz. Dizi 10 elemanlıdır:");

        //the user is allowed to try 5 times
        int i = 5;
        while (i > 0) {
            try {
                //check that if user enter another type
                int select = input.nextInt();
                //call check index method
                checkIndex(select);
                //if there is no exception
                //print arr[select]
                System.out.println(arr[select]);
                i--;
            } catch (Exception e) {
                System.out.println("Girdiğiniz index dizinin dışındadır. Dizi 10 elemanlıdır. Başka bir sayı deneyin.");
                i--;
            }
        }


    }
}