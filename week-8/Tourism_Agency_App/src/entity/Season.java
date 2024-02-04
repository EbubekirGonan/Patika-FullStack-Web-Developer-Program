package entity;

public class Season {
    private int id;
    private int hotelId;
    private String strtDate;
    private String fnshDate;


    public Season() {
    }

    public Season(int hotelId) {
        this.hotelId = hotelId;
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

    public String getStrtDate() {
        return strtDate;
    }

    public void setStrtDate(String strtDate) {
        this.strtDate = strtDate;
    }

    public String getFnshDate() {
        return fnshDate;
    }

    public void setFnshDate(String fnshDate) {
        this.fnshDate = fnshDate;
    }
}
