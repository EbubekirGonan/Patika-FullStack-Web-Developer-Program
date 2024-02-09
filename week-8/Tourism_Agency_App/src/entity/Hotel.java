package entity;

import core.ComboItem;

public class Hotel {
    private int id;
    private String name;
    private String addres;
    private String email;
    private String phone;
    private String star;
    private boolean hasFreeWifi;
    private boolean hasFreeParking;
    private boolean hasPool;
    private boolean hasFitnessCenter;
    private boolean hasConcierger;
    private boolean hasSpa;
    private boolean hasRoomService;

    public Hotel() {
    }

    public Hotel(int id, String name, String address, String email, String phone, String star,
                 boolean hasFreeWifi, boolean hasFreeParking, boolean hasPool,
                 boolean hasFitnessCenter, boolean hasConcierge, boolean hasSpa,
                 boolean hasRoomService) {
        this.id = id;
        this.name = name;
        this.addres = address;
        this.email = email;
        this.phone = phone;
        this.star = star;
        this.hasFreeWifi = hasFreeWifi;
        this.hasFreeParking = hasFreeParking;
        this.hasPool = hasPool;
        this.hasFitnessCenter = hasFitnessCenter;
        this.hasConcierger = hasConcierge;
        this.hasSpa = hasSpa;
        this.hasRoomService = hasRoomService;
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

    public boolean hasFreeWifi() {
        return hasFreeWifi;
    }

    public void setHasFreeWifi(boolean hasFreeWifi) {
        this.hasFreeWifi = hasFreeWifi;
    }

    public boolean hasFreeParking() {
        return hasFreeParking;
    }

    public void setHasFreeParking(boolean hasFreeParking) {
        this.hasFreeParking = hasFreeParking;
    }

    public boolean hasPool() {
        return hasPool;
    }

    public void setHasPool(boolean hasPool) {
        this.hasPool = hasPool;
    }

    public boolean hasFitnessCenter() {
        return hasFitnessCenter;
    }

    public void setHasFitnessCenter(boolean hasFitnessCenter) {
        this.hasFitnessCenter = hasFitnessCenter;
    }

    public boolean hasConcierge() {
        return hasConcierger;
    }

    public void setHasConcierge(boolean hasConcierger) {
        this.hasConcierger = hasConcierger;
    }

    public boolean hasSpa() {
        return hasSpa;
    }

    public void setHasSpa(boolean hasSpa) {
        this.hasSpa = hasSpa;
    }

    public boolean hasRoomService() {
        return hasRoomService;
    }

    public void setHasRoomService(boolean hasRoomService) {
        this.hasRoomService = hasRoomService;
    }

    public ComboItem getComboItem () {
        return new ComboItem(this.getId(), this.getName());
    }


}
