import java.util.Scanner;
public abstract class Products {

    //declare variables
    private String name;
    private int price;
    private int stock;
    private String brand;
    private String memory;
    private String screenSize;
    private String battery;
    private String ram;
    public Scanner input = new Scanner(System.in);

    //constructor method
    public Products(String name, int price, int stock, String brand, String memory, String screenSize, String battery, String ram) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.brand = brand;
        this.memory = memory;
        this.screenSize = screenSize;
        this.battery = battery;
        this.ram = ram;
    }
    //empty constructor method
    public Products() {
    }

    //getter and setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }
}
