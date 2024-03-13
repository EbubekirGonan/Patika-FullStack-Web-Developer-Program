import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        //declare variables
        String userName, password;
        Scanner input = new Scanner(System.in);
        int right = 3;
        int select;
        int balance = 1500;
        while (right >= 0) {
            //demand id and password
            System.out.print("Enter your ID: ");
            userName = input.nextLine();
            System.out.print("Enter your password: ");
            password = input.nextLine();
            // check id and password
            if (userName.equals("patika") && password.equals("dev123")){
                System.out.print("Entrance successful");

                //switch case structure in do-while structure
                do {
                    System.out.print("Please make a choice:\n" +
                            "1 - Add money\n" +
                            "2 - Get money\n" +
                            "3 - Balance inquiry\n" +
                            "4 - Quit\n");
                    select = input.nextInt();
                    switch (select) {
                        case 1:
                            System.out.print("Amount: ");
                            int price = input.nextInt();
                            balance += price;
                            break;
                        case 2:
                            System.out.print("Amount: ");
                            price = input.nextInt();
                            if (price > balance) {
                                System.out.print("the amount you wish to receive cannot be higher than your balance");
                            } else {
                                balance -= price;
                            }
                            break;
                        case 3:
                            System.out.println("Your money: " + balance);
                            break;
                    }

                } while (select != 4);
            } else {
                right--;
                System.out.print("You have logged in incorrectly");
                if (right == 0) {
                    System.out.print("Your account has been blocked. ");
                }else {
                    System.out.println("your remaining rights: " + right);
                }

            }
        }
    }
}