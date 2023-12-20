public class Main {
    public static void main(String[] args) {

        //Employee sınıfından e1 ve e2 adında 2 nesne oluşturuldu.
        //ve bu nesneler için toPrint methodu çağrıldı.

        Employee e1 = new Employee("Kemal", 2000, 45, 1985);
        e1.toPrint();

        Employee e2 = new Employee("Beko", 3000, 50, 1996 );
        e2.toPrint();
    }
}