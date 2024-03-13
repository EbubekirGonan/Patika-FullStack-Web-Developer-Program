import java.util.Scanner;
public class PatikaStore {
    public Scanner input = new Scanner(System.in);
    public boolean isRun = true;

    //run method works until isRun return false
    public void run() {
        while (isRun){
            System.out.println("Patika Store Yönetim Paneli;\n" +
                    "1- Notebook işlemleri\n" +
                    "2- Cep telefonu işlemleri\n" +
                    "3- Marka listele\n" +
                    "0- Çıkış");
            System.out.print("Yapmak istediğiniz işlem: ");
            int select = input.nextInt();
            switch (select){
                case 1:
                    NoteBooks noteBook = new NoteBooks();
                    noteBook.runMenu();
                    break;
                case 2:
                    MobilePhones mobilePhone = new MobilePhones();
                    mobilePhone.runMenu();
                    break;
                case 3:
                    Brands brand = new Brands();
                    brand.printBrand();
                    break;
                case 0:
                    System.out.println("Çıkış başarılı.");
                    isRun =false;
                    break;
                default:
                    System.out.println("Lütfen geçerli bir değer giriniz.");
            }
        }

    }
}
