import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        String userName, password, newPassword;
        int select;

        Scanner input = new Scanner(System.in);

        System.out.print("ID: ");
        userName = input.nextLine();
        System.out.print("Password: ");
        password = input.nextLine();


        if (userName.equals("patika") && password.equals("java123")) {
            System.out.print("Entrance successful... ");
        } else if (!userName.equals("patika")) {
            System.out.print("ID is wrong. Try again.");
        } else if (!password.equals("java123")) {
            System.out.println("Password is wrong. Do you want to create new password?\nPress 1 to yes\nPress 2 to no");

            select = input.nextInt();
            switch (select) {
                case 1:
                    System.out.print("Create new password:");
                    newPassword = input.next();
                    if (newPassword.equals("java123")){
                        System.out.print("Password couldn't be generated, try again.");
                    } else {
                        System.out.print("Password created.");
                    }
                case 2:
                    System.out.print("Try again.");
            }
        }
    }
}
