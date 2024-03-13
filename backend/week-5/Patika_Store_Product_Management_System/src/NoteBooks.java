import java.util.ArrayList;

public class NoteBooks extends Products implements Operation {
    //declare variables
    private int id;
    private int idCounter = 1;
    public boolean isRun = true;
    private static ArrayList<NoteBooks> noteBookList = new ArrayList<>();

    //constructor method
    public NoteBooks(String name, int price, int stock, String brand, String memory, String screenSize, String battery, String ram) {
        super(name, price, stock, brand, memory, screenSize, battery, ram);
        this.id = idCounter++;
    }

    //empty constructor method
    public NoteBooks() {
    }

    //getter and setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //run menu works until isRun return false
    @Override
    public void runMenu() {
        while (isRun){
            System.out.println("Notebook Paneli:\n" +
                    "1- Notebook'ları listele\n" +
                    "2- Notebook ekleme\n" +
                    "3- Notebook silme\n" +
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

    static {
        noteBookList.add(new NoteBooks("Lenovo ideapad", 1000, 20, "Lenovo", "1Tb", "16", "6000", "16"));
        noteBookList.add(new NoteBooks("Monster x4", 12000, 30, "Monster", "512Gb", "15", "7500", "32"));
        noteBookList.add(new NoteBooks("Casper Nirvana", 9000, 70, "Casper", "512", "15.7", "6500", "16"));
    }

    //show product list method
    @Override
    public void showProductList() {
        showListHeader();
        for (NoteBooks n : noteBookList) {
            System.out.format("%-5s%-18s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%n", "| " + n.getId(), "| " + n.getName(), "| " + n.getPrice(), "| " + n.getBrand(), "| " + n.getMemory(), "| " + n.getScreenSize(), "| " + n.getBattery(), "| " + n.getRam(), "| " + n.getStock());
            System.out.println("----------------------------------------------------------------------------------------------------------------");
        }

    }

    public void showListHeader() {
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.format("%-5s%-18s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%n", "| Id", "| Ürün adı", "| Fiyat", "| Marka", "| Depolama", "| Ekran", "| Pil", "| Ram", "| Stok");
        System.out.println("----------------------------------------------------------------------------------------------------------------");
    }

    // add product method
    @Override
    public void addProduct() {
        System.out.print("Notebook ismi: ");
        String name = input.next();
        input.nextLine();
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
        input.nextLine();
        System.out.print("Ekran boyutu: ");
        String screenSize = input.nextLine();
        System.out.print("Batarya gücü: ");
        String battery = input.nextLine();
        System.out.print("RAM: ");
        String ram = input.nextLine();

        noteBookList.add(new NoteBooks(name, price, stock, brand, memory, screenSize, battery, ram));
        System.out.print("Ürün eklendi");
        showProductList();

    }

    //delete product method
    @Override
    public void deleteProduct() {
        showProductList();
        System.out.print("Silmek istediğiniz ürünün id'sini giriniz: ");
        int select = input.nextInt();
        if (noteBookList.remove(findProductById(select))) {
            System.out.println("Ürün silindi. ");
            showProductList();
        } else {
            System.out.print("Geçersiz bir değer girdiniz.");
        }


    }

    //filterById method
    @Override
    public void filterById() {
        System.out.print("Görüntülemek istediğiniz ürünün id numarasını giriniz: ");
        int select = input.nextInt();
        NoteBooks n = findProductById(select);
        showListHeader();
        System.out.format("%-5s%-18s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%n", "| " + n.getId(), "| " + n.getName(), "| " + n.getPrice(), "| " + n.getBrand(), "| " + n.getMemory(), "| " + n.getScreenSize(), "| " + n.getBattery(), "| " + n.getRam(), "| " + n.getStock());
        System.out.println("----------------------------------------------------------------------------------------------------------------");

    }

    //filterByBrand method
    @Override
    public void filterByBrand() {
        showProductList();
        System.out.print("Görüntülemek istediğiniz ürünlerin markasını giriniz: ");
        String selectedBrand = input.nextLine();
        for(NoteBooks n: noteBookList){
            if(n.getBrand().equalsIgnoreCase(selectedBrand)){
                System.out.format("%-5s%-18s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%n", "| " + n.getId(), "| " + n.getName(), "| " + n.getPrice(), "| " + n.getBrand(), "| " + n.getMemory(), "| " + n.getScreenSize(), "| " + n.getBattery(), "| " + n.getRam(), "| " + n.getStock());
                System.out.println("----------------------------------------------------------------------------------------------------------------");
            }else {
                System.out.print("Ürün bulunamadı.");
            }
        }
    }
    //findProductById method
    public NoteBooks findProductById(int num){
        for(NoteBooks n: noteBookList){
            if(num == n.getId()){
                return n;
            }
        }return null;
    }
}
