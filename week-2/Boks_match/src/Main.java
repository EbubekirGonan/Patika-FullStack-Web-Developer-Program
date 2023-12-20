public class Main {
    public static void main(String[] args) {
        //Fighter sınıfından f1 ve f2 adlarında nesneler türetildi.
        Fighter f1 = new Fighter("A", 10, 120, 100, 30);
        Fighter f2 = new Fighter("B", 20, 90, 95, 40);

        //match sınıfından match isminde bir nesne türetildi.
        Match match = new Match(f1, f2, 80, 110);
        //run methodu çağrıldı.
        match.run();
    }
}