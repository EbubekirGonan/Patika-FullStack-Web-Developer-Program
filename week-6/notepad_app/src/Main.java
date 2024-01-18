import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //declare variables
        Scanner input = new Scanner(System.in);
        String path = "/home/bekir/IdeaProjects/Patika+ FullStack Web Developer Programı/Patika+ FullStack Web Developer Programı/week-6/notepad_app/notlar.txt";
        File file = new File(path);
        FileWriter fileWriter = null;
        FileReader fileReader = null;
        boolean isRun = true;

        //while loop
        while(isRun){
            //show menu
            System.out.println("### NOTEPAD MENU ###");
            System.out.print("1- Not ekle\n" +
                    "2- Son notu görüntüle\n" +
                    "3- Tüm notları görüntüle\n" +
                    "4- Çıkış\n" +
                    "Seçiminiz: ");
            int select = input.nextInt();
            input.nextLine();
            switch (select){
                case 1: //add note
                    try {
                        System.out.print("Bir metin girin: ");
                        String text = input.nextLine();

                        fileWriter = new FileWriter(file, true);
                        PrintWriter printWriter = new PrintWriter(fileWriter);

                        printWriter.write(text);
                        printWriter.println();
                        printWriter.close();

                    } catch (Exception e) {
                        System.out.print(e.getMessage());
                    }
                    break;
                case 2: //print last note
                    try {
                        fileReader = new FileReader(file);
                        BufferedReader bReader = new BufferedReader(fileReader);
                        String readText;
                        String finalRow = null;

                        while ((readText = bReader.readLine()) != null){
                            finalRow = readText;
                        }
                        if (finalRow != null) {
                            System.out.println("Son eklenen not: " + finalRow);
                        } else {
                            System.out.println("Dosya boş.");
                        }
                        bReader.close();

                    } catch (Exception e) {
                        System.out.print(e.getMessage());
                    }
                    break;
                case 3: //print all notes
                    try {
                        fileReader = new FileReader(file);
                        BufferedReader bReader = new BufferedReader(fileReader);
                        String readtext ;
                        while ((readtext = bReader.readLine())!= null){
                            System.out.println(readtext);
                        }
                        bReader.close();
                    } catch (Exception e) {
                        System.out.print(e.getMessage());
                    }
                    break;
                case 4: //exit
                    isRun = false;
                    break;
            }

        }



    }
}