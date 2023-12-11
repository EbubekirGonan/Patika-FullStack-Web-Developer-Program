import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int math, physics, chemistry, literature, history, music;
        Scanner inp = new Scanner(System.in);

        System.out.print("Enter math score:");
        math = inp.nextInt();

        System.out.print("Enter physics score:");
        physics = inp.nextInt();

        System.out.print("Enter chemistry score:");
        chemistry = inp.nextInt();

        System.out.print("Enter literature score:");
        literature = inp.nextInt();

        System.out.print("Enter history score:");
        history = inp.nextInt();

        System.out.print("Enter music score:");
        music = inp.nextInt();

        double result;
        result = (math + physics + chemistry + literature + history + music) / 6;
        System.out.println("Graduate Average: " + result);

        String gradstat = (result >= 60) ? "You graduated succesfully."
                : "Sorry, you didn't graduated.";
        System.out.print(gradstat);

    }
}

