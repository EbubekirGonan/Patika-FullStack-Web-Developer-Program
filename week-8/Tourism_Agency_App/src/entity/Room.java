package entity;

public class Room {
    private int id;
    private int hotelId;
    private int pensionId;
    private int seasonId;
    private Room.Type type;
    private int stock;
    private int adultPrice;
    private int childPrice;
    private int bedCount;
    private int area;
    private boolean hasTV;
    private boolean hasMiniBar;
    private boolean hasGameConsole;
    private boolean hasSafeCase;
    private boolean hasProjector;


    public Room() {
    }

    public Room(int id, int hotelId, int pensionId, int seasonId, Type type, int stock, int adultPrice, int childPrice, int bedCount, int area, boolean hasTV, boolean hasMiniBar, boolean hasGameConsole, boolean hasSafeCase, boolean hasProjector) {
        this.id = id;
        this.hotelId = hotelId;
        this.pensionId = pensionId;
        this.seasonId = seasonId;
        this.type = type;
        this.stock = stock;
        this.adultPrice = adultPrice;
        this.childPrice = childPrice;
        this.bedCount = bedCount;
        this.area = area;
        this.hasTV = hasTV;
        this.hasMiniBar = hasMiniBar;
        this.hasGameConsole = hasGameConsole;
        this.hasSafeCase = hasSafeCase;
        this.hasProjector = hasProjector;
    }

    public enum Type {
        SINGLE,
        DOUBLE,
        JUNIOR_SUITE,
        SUITE
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getPensionId() {
        return pensionId;
    }

    public void setPensionId(int pensionId) {
        this.pensionId = pensionId;
    }

    public int getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(int seasonId) {
        this.seasonId = seasonId;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getAdultPrice() {
        return adultPrice;
    }

    public void setAdultPrice(int adultPrice) {
        this.adultPrice = adultPrice;
    }

    public int getChildPrice() {
        return childPrice;
    }

    public void setChildPrice(int childPrice) {
        this.childPrice = childPrice;
    }

    public int getBedCount() {
        return bedCount;
    }

    public void setBedCount(int bedCount) {
        this.bedCount = bedCount;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public boolean hasTV() {
        return hasTV;
    }

    public void setHasTV(boolean hasTV) {
        this.hasTV = hasTV;
    }

    public boolean hasMiniBar() {
        return hasMiniBar;
    }

    public void setHasMiniBar(boolean hasMiniBar) {
        this.hasMiniBar = hasMiniBar;
    }

    public boolean hasGameConsole() {
        return hasGameConsole;
    }

    public void setHasGameConsole(boolean hasGameConsole) {
        this.hasGameConsole = hasGameConsole;
    }

    public boolean hasSafeCase() {
        return hasSafeCase;
    }

    public void setHasSafeCase(boolean hasSafeCase) {
        this.hasSafeCase = hasSafeCase;
    }

    public boolean hasProjector() {
        return hasProjector;
    }

    public void setHasProjector(boolean hasProjector) {
        this.hasProjector = hasProjector;
    }
}
