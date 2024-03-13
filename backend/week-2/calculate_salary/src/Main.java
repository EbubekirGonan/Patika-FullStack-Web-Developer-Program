public class Main {
    public static void main(String[] args) {

        //Employee sınıfından e1 ve e2 adında 2 nesne oluşturuldu.
        //ve bu nesneler için toString methodu çağrıldı.

        Employee e1 = new Employee("Kemal", 2000, 45, 1985);
        System.out.println(e1.toString());

        Employee e2 = new Employee("Beko", 3000, 50, 1996 );
        System.out.println(e2.toString());

        Employee e3 = new Employee("İvan", 3200, 40, 2001);
        System.out.println(e3.toString());










    }
}