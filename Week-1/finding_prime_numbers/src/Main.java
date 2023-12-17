public class Main {
    public static void main(String[] args) {
        //2 ile 100 arasındaki asal sayıları bulmak için 2 for döngüsüne ihtiyaç var
        //ilkinde 100'e kadar sayıları tek tek ele alınır
        //ikincisinde bu sayıların çarpanı olup olmadığı kontrol edilir.

       for (int i=2; i<=100; i++){
           boolean isPrime = true;
           for(int j=2; j<=i-1; j++){
               if(i%j == 0 ){
                   isPrime = false; //eğer sayının çarpanı varsa isPrime false'a dönüyor
                   break;
               }
           }

           //isPrime doğru olduğu andaki i değerleri asal sayıları verir.
           if (isPrime) {
               System.out.println(i);
           }
       }


    }
}