public class Main {
    //statik method tanımlandı.
    static boolean isFind(int[] arr, int value, int currentIndex) {
        //sayı bir kere bulunduğunda, sayıma tekrar katılmaması sağlandı.
        for (int i = 0; i < currentIndex; i++) {
            if (arr[i] == value) {
                return true; //sayı bulunduysa true
            }
        }
        return false; //bulunmadıysa false döner. Eğer false ise işleme girer.
    }

    public static void main(String[] args) {
        int count = 0;
        int[] arr = {10, 20, 20, 10, 10, 20, 5, 20};
        //tekrar eden sayıları bulmak için 2 for döngüsü kullanılır.
        for (int i = 0; i < arr.length; i++) {
            //i=0 iken arr[0] için bütün liste taranır.
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    //eşleşme oldukça count artar.
                    count++;
                }
            }
            if (!isFind(arr, arr[i], i)) {
                System.out.println(arr[i] + " sayısı " + count + " kere tekrar edildi");
            }
            count = 0;
        }
    }
}
