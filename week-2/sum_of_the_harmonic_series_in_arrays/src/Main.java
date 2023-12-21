public class Main {
    public static void main(String[] args) {
        //dizi tanımlandı
        double[] arr = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0};
        //dizi elemanlarının harmonik toplaması için toplam değişkeni oluşturuldu.
        double sum = 0;

        //her elemanın harmonik toplamaya katılması için for döngüsü
        for(int i = 0; i < arr.length; i++){
            sum += (1/arr[i]);
        }
        //harmonik ortalama harmonicAverage değişkenine atıldı.
        double harmonicAverage = arr.length/sum;

        //yazdırıldı.
        System.out.println(harmonicAverage);
    }
}