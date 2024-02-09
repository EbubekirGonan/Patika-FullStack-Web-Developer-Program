package entity;

import java.time.LocalDate;

public class Reservation {
    private int reservationId;
    private int reservationRoomId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int totalPrice;
    private int guestCount;
    private String guestName;
    private String guestCitizenId;
    private String guestMail;
    private String guestPhone;
    private int numOfAdult;
    private int numOfChild;

    public Reservation() {
    }

    public Reservation(int reservationId, int reservationRoomId, LocalDate checkInDate, LocalDate checkOutDate, int totalPrice, int guestCount, String guestName, String guestCitizenId, String guestMail, String guestPhone) {
        this.reservationId = reservationId;
        this.reservationRoomId = reservationRoomId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalPrice = totalPrice;
        this.guestCount = guestCount;
        this.guestName = guestName;
        this.guestCitizenId = guestCitizenId;
        this.guestMail = guestMail;
        this.guestPhone = guestPhone;
    }

    public int getNumOfAdult() {
        return numOfAdult;
    }

    public void setNumOfAdult(int numOfAdult) {
        this.numOfAdult = numOfAdult;
    }

    public int getNumOfChild() {
        return numOfChild;
    }

    public void setNumOfChild(int numOfChild) {
        this.numOfChild = numOfChild;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getReservationRoomId() {
        return reservationRoomId;
    }

    public void setReservationRoomId(int reservationRoomId) {
        this.reservationRoomId = reservationRoomId;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getGuestCount() {
        return guestCount;
    }

    public void setGuestCount(int guestCount) {
        this.guestCount = guestCount;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getGuestCitizenId() {
        return guestCitizenId;
    }

    public void setGuestCitizenId(String guestCitizenId) {
        this.guestCitizenId = guestCitizenId;
    }

    public String getGuestMail() {
        return guestMail;
    }

    public void setGuestMail(String guestMail) {
        this.guestMail = guestMail;
    }

    public String getGuestPhone() {
        return guestPhone;
    }

    public void setGuestPhone(String guestPhone) {
        this.guestPhone = guestPhone;
    }
}
