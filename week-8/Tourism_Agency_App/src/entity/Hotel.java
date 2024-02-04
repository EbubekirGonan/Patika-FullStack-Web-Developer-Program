package entity;

public class Hotel {
    private int id;
    private String name;
    private String addres;
    private String email;
    private String phone;
    private String star;

    public Hotel() {
    }

    public Hotel(int id, String name, String address, String email, String phone, String star) {
        this.id = id;
        this.name = name;
        this.addres = address;
        this.email = email;
        this.phone = phone;
        this.star = star;
    }

    public enum Facility{
        FREE_WIFI,
        FREE_PARKING,
        POOL,
        FITNESS_CENTER,
        CONCIERGE,
        SPA,
        ROOM_SERVICE
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

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }


}
