import java.util.Arrays;

public class Main {

    //transpoz almak için method yazıldı
    public static int[][] trans(int[][] arr) {
        //methodun tek parametresi transpozu alınacak array

        //row ve col değişkenleri arrayin uzunluk ve genişliğine atandı.
        int row = arr.length;
        int col = arr[0].length;


        //transpoz işlemi:
        int[][] transArr = new int[col][row];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                transArr[j][i] = arr[i][j];
            }
        }
        return transArr;
    }

    //matrisi yazdırmak için method oluşturuldu.
    public static void printMatris(int [][] matris){

        for (int[] row : matris) {
            for (int col : row) {
                System.out.print(col + " ");
            }System.out.println();
        }

    }

    public static void main(String[] args) {
        //2 boyutlu bir matris tanımlandı.
        int[][] arr = new int[3][4];

        //içine değerler hücre sayısınca yerleştirildi
        int number = 1;
        for (int x = 0; x < arr.length; x++) {
            int[] row = arr[x];
            for (int y = 0; y < row.length; y++) {
                row[y] = number;
                number++;
            }
        }

        //matirisi yazdırma methodu çağrıldı.
        printMatris(arr);
        System.out.println();

        //transpoz methodu çağrıldı.
        int[][] transArr = trans(arr);
        //transpoze edilen matris yazdırıldı.
        printMatris(transArr);



    }
}