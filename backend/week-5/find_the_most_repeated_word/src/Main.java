import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Call Scanner Class
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();

        //split method in String Class
        String[] words = text.split(" ");

        //new HashMap named frequencies
        HashMap<String, Integer> frequencies = new HashMap<>();

        //for each loop for put method
        for (String word : words) {
            Integer frequence = 1; //frequence starts 1
            word = word.toLowerCase();

            //check if it contains word already
            if (frequencies.containsKey(word)) {
                frequence = frequencies.get(word);
                frequence++;
                frequencies.put(word, frequence);
            } else {
                //else put
                frequencies.put(word, frequence);
            }
        }
        //print loop
        for (String word : frequencies.keySet()) {
            System.out.println(word + ": " + frequencies.get(word));
        }

    }
}