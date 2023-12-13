import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        //declare variables
        int math, physics, chemistry, literature, history, music;
        double average;
        int total =0, count = 0;

        //call scanner class
        Scanner inp = new Scanner(System.in);

        //demand for values
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

        //grades are included in the calculation only beetween 0 and 100
        if (math >= 0 && math <= 100) {
            total += math;
            count++;
        }

        if (physics >= 0 && physics <= 100) {
            total += physics;
            count++;
        }

        if (chemistry >= 0 && chemistry <= 100) {
            total += chemistry;
            count++;
        }

        if (literature >= 0 && literature <= 100) {
            total += literature;
            count++;
        }

        if (history >= 0 && history <= 100) {
            total += history;
            count++;
        }

        if (music >= 0 && music <= 100) {
            total += music;
            count++;
        }

        //calculate average
        average = total / count;
        System.out.println("Your graduate note is: " + average);

        //graduation status
        if (average < 55) {
            System.out.print("You didn't graduated. See you next year.");
        } else {
            System.out.println("You graduated succesfully.");
        }

    }
}

