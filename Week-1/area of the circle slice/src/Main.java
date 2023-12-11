import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int r, a;
        double p = 3.14, area;

        Scanner input = new Scanner(System.in);

        System.out.print("Please enter value of radius in: ");
        r = input.nextInt();

        System.out.print("Please enter value of center angle of the circle slice: ");
        a = input.nextInt();

        area = (p * (r * r) * a) / 360;
        System.out.print("Area is: " + area);
        
    }
}