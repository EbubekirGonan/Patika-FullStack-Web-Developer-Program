import java.util.ArrayList;

public class MobilePhones extends Products implements Operation {
    //declare variables
    private int id;
    int idCounter = 1;
    private String camera;
    private String color;
    public boolean isRun = true;
    private static ArrayList<MobilePhones> mobilePhones = new ArrayList<>();

    //declare constructor methods
    public MobilePhones(String name, int price, int stock, String brand, String memory, String screenSize, String battery, String ram, String camera, String color) {
        super(name, price, stock, brand, memory, screenSize, battery, ram);

        this.id = idCounter++;
        this.color = color;
        this.camera = camera;
    }

    static{
        mobilePhones.add(new MobilePhones("Galaxy A7", 5000, 50, "Samsung", "512", "4", "2300", "16", "24", "Beyaz"));
        mobilePhones.add(new MobilePhones("iPhone 12", 6000, 30, "Apple", "1024", "3", "1800", "32", "24", "Gümüş"));
        mobilePhones.add(new MobilePhones("Xiaomi", 4500, 70, "Xiaomi", "2Gb", "5", "1900", "16", "30", "Siyah"));
    }

    public MobilePhones() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    //run menu works until isRun return false
    @Override
    public void runMenu() {
        while (isRun){
            System.out.println("MobilePhone Paneli;\n" +
                    "1- Telefonları listele\n" +
                    "2- Telefon ekleme\n" +
                    "3- Telefon silme\n" +
                    "4- Markaya göre listele\n" +
                    "5- Id'ye göre listele\n" +
                    "0- Çıkış");
            System.out.print("Yapmak istediğiniz işlem: ");
            int select = input.nextInt();
            switch (select) {
                case 1:
                    showProductList();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    filterByBrand();
                    break;
                case 5:
                    filterById();
                    break;
                case 0:
                    isRun = false;
                    break;
                default:
                    System.out.println("Lütfen geçerli bir değer giriniz.");
            }
        }

    }
    //show product list method
    @Override
    public void showProductList() {
        showListHeader();
        for (MobilePhones m : mobilePhones) {
            System.out.format("%-5s%-18s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%n", "| " + m.getId(), "| " + m.getName(), "| " + m.getPrice(), "| " + m.getBrand(), "| " + m.getMemory(), "| " + m.getScreenSize(), "| " + m.getCamera(), "| " + m.getBattery(), "| " + m.getRam(), "| " + m.getColor(), "| " + m.getStock());
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
        }
    }


    public void showListHeader(){
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("%-5s%-18s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%n", "| Id", "| Ürün adı", "| Fiyat", "| Marka", "| Depolama", "| Ekran", "| Kamera", "| Pil", "| Ram", "| Renk", "| Stok");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
    }

    // add product method
    @Override
    public void addProduct() {
        System.out.print("Telefon ismi: ");
        String name;
        name = input.next();
        System.out.print("Fiyatı: ");
        int price;
        price = input.nextInt();
        System.out.print("Stok miktarı: ");
        int stock = input.nextInt();
        System.out.print("Markası: ");
        String brand;
        brand = input.next();
        System.out.print("Hafızası: ");
        String memory;
        memory = input.nextLine();
        input.next();
        System.out.print("Ekran boyutu: ");
        String screenSize = input.nextLine();
        System.out.print("Batarya gücü: ");
        String battery = input.nextLine();
        System.out.print("RAM: ");
        String ram = input.nextLine();
        System.out.print("Kamera: ");
        String camera = input.nextLine();
        System.out.print("Renk: ");
        String color = input.nextLine();

        mobilePhones.add(new MobilePhones(name, price, stock, brand, memory, screenSize, battery, ram, camera, color));
        System.out.print("Ürün eklendi");
        showProductList();
    }

    //delete product method
    @Override
    public void deleteProduct() {
        showProductList();
        System.out.print("Silmek istediğiniz ürünün id'sini giriniz: ");
        int select = input.nextInt();
        if(mobilePhones.remove(findProductById(select))){
            System.out.print("Ürün silindi. ");
            showProductList();
        }else {
            System.out.print("Geçersiz bir değer girdiniz.");
        }
    }

    //filterById method//filterById method
    @Override
    public void filterById() {
        System.out.print("Görüntülemek istediğiniz ürünün id numarasını giriniz: ");
        int select = input.nextInt();
        MobilePhones m = findProductById(select);
        showListHeader();
        System.out.format("%-5s%-18s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%n", "| " + m.getId(), "| " + m.getName(), "| " + m.getPrice(), "| " + m.getBrand(), "| " + m.getMemory(), "| " + m.getScreenSize(), "| " + m.getCamera(), "| " + m.getBattery(), "| " + m.getRam(), "| " + m.getColor(), "| " + m.getStock());
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
    }

    //filterByBrand method
    @Override
    public void filterByBrand() {
        showProductList();
        System.out.print("Görüntülemek istediğiniz ürünlerin markasını giriniz: ");
        String selectedBrand = input.nextLine();
        for(MobilePhones m: mobilePhones){
            if(m.getBrand().equalsIgnoreCase(selectedBrand)){
                System.out.format("%-5s%-18s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%n", "| " + m.getId(), "| " + m.getName(), "| " + m.getPrice(), "| " + m.getBrand(), "| " + m.getMemory(), "| " + m.getScreenSize(), "| " + m.getCamera(), "| " + m.getBattery(), "| " + m.getRam(), "| " + m.getColor(), "| " + m.getStock());
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
            }
        }
    }
    //findProductById method
    public MobilePhones findProductById(int num){
        for(MobilePhones m: mobilePhones){
            if(num == m.getId()){
                return m;
            }
        }return null;
    }
}
