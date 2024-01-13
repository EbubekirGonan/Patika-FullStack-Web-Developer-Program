import java.util.TreeSet;

public class Brands implements Comparable<Brands>{
    //declare variables
    private int id;
    private int idCounter = 1;
    private String name;
    private static TreeSet<Brands> brandList = new TreeSet<>();

    public Brands(String name) {
        this.id = idCounter++;
        this.name = name;
    }


    static{
        brandList.add(new Brands("Samsung"));
        brandList.add(new Brands("Lenovo"));
        brandList.add(new Brands("Apple"));
        brandList.add(new Brands("Huawei"));
        brandList.add(new Brands("Casper"));
        brandList.add(new Brands("Asus"));
        brandList.add(new Brands("HP"));
        brandList.add(new Brands("Xiaomi"));
        brandList.add(new Brands("Monster"));
    }



    public Brands() {
    }

    public void printBrand(){
        for(Brands br : brandList){
            System.out.println(br.getName());
        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int compareTo(Brands b) {
        return this.name.compareTo(b.getName());
    }
}
