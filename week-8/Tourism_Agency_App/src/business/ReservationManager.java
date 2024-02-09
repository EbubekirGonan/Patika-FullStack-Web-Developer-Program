package business;

import dao.ReservationDao;
import entity.Reservation;
import entity.User;

import java.util.ArrayList;

public class ReservationManager {
    private final ReservationDao reservationDao;

    public ReservationManager() {
        this.reservationDao = new ReservationDao();
    }

    public ArrayList<Reservation> findAll() {
        return this.reservationDao.findAll();
    }

    public boolean save(Reservation reservation) {
        return this.reservationDao.save(reservation);
    }

    public boolean delete (int id) {
        return this.reservationDao.delete(id);
    }

    public Reservation getById (int id) {
        return this.reservationDao.getById(id);
    }

    public ArrayList<Object[]> getReservationRowListForTable (int size){
        ArrayList<Object[]> reservationRowList = new ArrayList<>();
        for(Reservation reservation: this.findAll()){
            Object[] rowObject = new Object[size];
            int i = 0;
            rowObject[i++] = reservation.getReservationId();
            rowObject[i++] = reservation.getReservationRoomId();
            rowObject[i++] = reservation.getCheckInDate();
            rowObject[i++] = reservation.getCheckOutDate();
            rowObject[i++] = reservation.getTotalPrice();
            rowObject[i++] = reservation.getGuestCount();
            rowObject[i++] = reservation.getGuestName();
            rowObject[i++] = reservation.getGuestCitizenId();
            rowObject[i++] = reservation.getGuestMail();
            rowObject[i++] = reservation.getGuestPhone();
            reservationRowList.add(rowObject);
        }
        return reservationRowList;
    }
}
