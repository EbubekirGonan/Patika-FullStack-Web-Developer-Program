import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //declare variables
        String line;
        int sum = 0;

        //declare path
        String path = "/home/bekir/IdeaProjects/Patika+ FullStack Web Developer Programı/Patika+ FullStack Web Developer Programı/week-6/read_numbers_from_file/src/myFile.txt";
        //new file from File Class
        File file = new File(path);
        //new file reader object
        FileReader fReader = new FileReader(file);
        //support buffreader
        BufferedReader bReader = new BufferedReader(fReader);
        //readLine method from buffreader object
        //while loop works until return null
        while ((line = bReader.readLine()) != null){
            sum += Integer.parseInt(line);
        }
        //print sum
        System.out.print(sum);
    }
}
