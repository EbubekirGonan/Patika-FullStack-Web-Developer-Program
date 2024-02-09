package view;

import business.HotelManager;
import business.RoomManager;
import core.Helper;
import dao.ReservationDao;
import entity.Reservation;
import entity.Room;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class ReservationView extends Layout {
    //Değerlendirme formu 5
    private JTextField fld_hotel_name;
    private JTextField fld_city;
    private JTextField fld_star;
    private JRadioButton rdbtn_free_parking;
    private JRadioButton rdbtn_wifi;
    private JRadioButton rdbtn_pool;
    private JRadioButton rdbtn_fitness;
    private JRadioButton rdbtn_concierge;
    private JRadioButton rdbtn_spa;
    private JRadioButton rdbtn_room_service;
    private JTextField fld_room_type;
    private JTextField fld_pension_type;
    private JTextField fld_strt_date;
    private JTextField fld_fnsh_date;
    private JTextField fld_total_price;
    private JTextField fld_bed_count;
    private JRadioButton rdbtn_tv;
    private JTextField fld_room_area;
    private JRadioButton rdbtn_game_console;
    private JRadioButton rdbtn_projector;
    private JRadioButton rdbtn_minibar;
    private JRadioButton rdbtn_case;
    private JTextField fld_total_guest_number;
    private JTextField fld_guest_name;
    private JTextField fld_guest_idno;
    private JTextField fld_guest_phone;
    private JTextField fld_guest_mail;
    private JButton btn_create_reservation;
    private JPanel container;
    private JButton btn_update_reservation;
    private RoomManager roomManager;
    private HotelManager hotelManager;
    private Reservation reservation;
    private ReservationDao reservationDao;

    public ReservationView(Reservation reservation, int roomId, String checkInDate, String checkOutDate, int numOfAdult, int numOfChild) {
        if (reservation == null) {
            this.reservation = new Reservation();
            this.btn_update_reservation.setVisible(false);
        } else {
            this.reservation = reservation;
            this.btn_create_reservation.setVisible(false);
        }
        this.add(container);
        this.guiInitialise(1200, 700);
        this.roomManager = new RoomManager();
        this.hotelManager = new HotelManager();
        this.reservationDao = new ReservationDao();


        //Değerlendirme formu 14
        int totalGuestCount = numOfAdult + numOfChild;
        int pricePerDay = (this.roomManager.getById(roomId).getAdultPrice() * numOfAdult) + (this.roomManager.getById(roomId).getChildPrice() * numOfChild);
        long totalDay = (int) ChronoUnit.DAYS.between(LocalDate.parse(checkInDate, DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.parse(checkOutDate, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        //Değerlendirme formu 17
        int totalPrice = (int) (totalDay * pricePerDay);

        //Değerlendirme formu 3
        //Değerlendirme formu 4
        this.fld_hotel_name.setText(this.hotelManager.getById(this.roomManager.getById(roomId).getHotelId()).getName());
        this.fld_city.setText(this.hotelManager.getById(this.roomManager.getById(roomId).getHotelId()).getAddres());
        this.fld_star.setText(this.hotelManager.getById(this.roomManager.getById(roomId).getHotelId()).getStar());
        this.rdbtn_free_parking.setSelected(this.hotelManager.getById(this.roomManager.getById(roomId).getHotelId()).hasFreeParking());
        this.rdbtn_wifi.setSelected(this.hotelManager.getById(this.roomManager.getById(roomId).getHotelId()).hasFreeWifi());
        this.rdbtn_pool.setSelected(this.hotelManager.getById(this.roomManager.getById(roomId).getHotelId()).hasPool());
        this.rdbtn_fitness.setSelected(this.hotelManager.getById(this.roomManager.getById(roomId).getHotelId()).hasFitnessCenter());
        this.rdbtn_concierge.setSelected(this.hotelManager.getById(this.roomManager.getById(roomId).getHotelId()).hasConcierge());
        this.rdbtn_spa.setSelected(this.hotelManager.getById(this.roomManager.getById(roomId).getHotelId()).hasSpa());
        this.rdbtn_room_service.setSelected(this.hotelManager.getById(this.roomManager.getById(roomId).getHotelId()).hasRoomService());

        this.fld_room_type.setText(this.roomManager.getById(roomId).getType().toString());
        this.fld_pension_type.setText(String.valueOf(this.roomManager.getById(roomId).getPensionType()));
        this.fld_strt_date.setText(checkInDate);
        this.fld_fnsh_date.setText(checkInDate);
        this.fld_total_price.setText(String.valueOf(totalPrice));
        this.fld_bed_count.setText(String.valueOf(this.roomManager.getById(roomId).getBedCount()));
        this.fld_room_area.setText(String.valueOf(this.roomManager.getById(roomId).getArea()));

        this.rdbtn_tv.setSelected(this.roomManager.getById(roomId).hasTV());
        this.rdbtn_minibar.setSelected(this.roomManager.getById(roomId).hasMiniBar());
        this.rdbtn_game_console.setSelected(this.roomManager.getById(roomId).hasGameConsole());
        this.rdbtn_case.setSelected(this.roomManager.getById(roomId).hasSafeCase());
        this.rdbtn_projector.setSelected(this.roomManager.getById(roomId).hasProjector());
        this.fld_total_guest_number.setText(String.valueOf(totalGuestCount));

        if (this.reservation.getReservationId() != 0) {

            this.fld_guest_name.setText(this.reservation.getGuestName());
            this.fld_guest_idno.setText(this.reservation.getGuestCitizenId());
            this.fld_guest_mail.setText(this.reservation.getGuestMail());
            this.fld_guest_phone.setText(this.reservation.getGuestPhone());

            this.btn_update_reservation.addActionListener(e -> {
                this.reservation.setGuestName(this.fld_guest_name.getText());
                this.reservation.setGuestCitizenId(this.fld_guest_idno.getText());
                this.reservation.setGuestMail(this.fld_guest_mail.getText());
                this.reservation.setGuestPhone(this.fld_guest_phone.getText());
                this.reservationDao.update(this.reservation);
                Helper.showMsg("done");
                dispose();
            });
        }

        btn_create_reservation.addActionListener(e -> {
            this.reservation.setReservationRoomId(roomId);
            this.reservation.setCheckInDate(LocalDate.parse(checkInDate, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            this.reservation.setCheckOutDate(LocalDate.parse(checkOutDate, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            this.reservation.setTotalPrice(Integer.parseInt(this.fld_total_price.getText()));
            this.reservation.setGuestCount(Integer.parseInt(this.fld_total_guest_number.getText()));
            this.reservation.setNumOfAdult(numOfAdult);
            this.reservation.setNumOfChild(numOfChild);
            this.reservation.setGuestName(this.fld_guest_name.getText());
            this.reservation.setGuestCitizenId(this.fld_guest_idno.getText());
            this.reservation.setGuestMail(this.fld_guest_mail.getText());
            this.reservation.setGuestPhone(this.fld_guest_phone.getText());

            //Değerlendirme formu 18
            this.reservationDao.save(this.reservation);
            Room room = this.roomManager.getById(roomId);
            //Değerlendirme formu 19
            room.setStock(room.getStock() - 1);
            this.roomManager.stockUpdate(room);
            Helper.showMsg("done");
            dispose();


        });
    }
}
