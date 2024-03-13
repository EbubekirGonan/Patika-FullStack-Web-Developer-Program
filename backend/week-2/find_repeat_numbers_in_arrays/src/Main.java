import java.util.Arrays;
public class Main {
    static boolean isFind(int[]arr, int value){
        for (int i : arr){
            if(i == value){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {1, 24 , 4, 32, 4, 235, 23, 5, 24, 5, 32, 1, 0, 0};
        int [] duplicate = new int[arr.length];
        int startIndex = 0;
        for(int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length; j++){
                if (arr[j] % 2 == 0) {
                    if(i!=j && arr[i] == arr[j]){
                        if(!isFind(duplicate, arr[i])) {
                            duplicate[startIndex++] = arr[i];
                        }
                        break;
                    }
                }
            }
        }
        for(int value: duplicate){
            if(value != 0){
                System.out.println(value);
            }
        }
    }
}