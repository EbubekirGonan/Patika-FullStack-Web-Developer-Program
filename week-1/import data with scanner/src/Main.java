import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        float a,b;
        Scanner firstEdge = new Scanner(System.in);
        System.out.print("Enter the length of the edge:");
        a = firstEdge.nextFloat();
        Scanner secondEdge = new Scanner(System.in);
        System.out.print("Enter the height of the edge:");
        b = secondEdge.nextFloat();
        System.out.print("Area of Triangle: ");
        System.out.print((a*b)/2);

    }
}