package view;

import business.*;
import core.Helper;
import entity.Reservation;
import entity.Room;
import entity.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class EmployeeView extends Layout {
    //extends Layout

    //declare variables
    private JPanel container;
    private JTabbedPane fld;
    private JTable tbl_hotel;

    private JTable tbl_pension;
    private JTable tbl_season;
    private JTable tbl_reservation;
    private JTable tbl_room;
    private JButton btn_add_hotel;
    private JTextField fld_src_hotel_name;
    private JTextField fld_src_city;
    private JTextField fld_src_strt_date;
    private JTextField fld_src_fnsh_date;
    private JTextField fld_src_adult_num;
    private JTextField fld_src_child_num;
    private JButton btn_add_room;
    private JButton btn_src_clear;
    private JButton btn_src_room;

    private DefaultTableModel tmdl_hotel = new DefaultTableModel();
    private DefaultTableModel tmdl_room = new DefaultTableModel();
    private DefaultTableModel tmdl_reservation = new DefaultTableModel();
    private JPopupMenu hotel_menu;
    private JPopupMenu room_menu;
    private JPopupMenu reservation_menu;

    private DefaultTableModel tmdl_pension = new DefaultTableModel();
    private DefaultTableModel tmdl_season = new DefaultTableModel();
    private HotelManager hotelManager;
    private PensionManager pensionManager;
    private SeasonManager seasonManager;
    private RoomManager roomManager;
    private ReservationManager reservationManager;
    private Object[] col_hotel;
    private Object[] col_room;
    private Object[] col_reservation;

    public EmployeeView(User user) {
        this.add(container);
        this.guiInitialise(1200, 700);
        this.hotelManager = new HotelManager();
        this.pensionManager = new PensionManager();
        this.seasonManager = new SeasonManager();
        this.roomManager = new RoomManager();
        this.reservationManager = new ReservationManager();

        //Değerlendirme formu 8
        //hotel table
        loadHotelTable();
        //hotel component
        loadHotelComponent();

        //pension table
        loadPensionTable();

        //season table
        loadSeasonTable();

        //room table
        loadRoomTable(this.roomManager.filterRooms());
        //room component
        loadRoomComponent();

        //reservation table
        //Değerlendirme formu 20
        loadReservationTable();
        //reservation component
        loadReservationComponent();

        //button add hotel
        btn_add_hotel.addActionListener(e -> {
            HotelView hotelView = new HotelView();
            //Değerlendirme formu 10
            hotelView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadHotelTable();
                    loadHotelComponent();
                }
            });
        });
        //button add room
        //Değerlendirme formu 13
        EmployeeView employeeView = this;
        btn_add_room.addActionListener(e -> {
            RoomView roomView = new RoomView();
            roomView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadRoomTable(employeeView.roomManager.filterRooms());
                }
            });
        });

        //Değerlendirme formu 15
        //button search room
        btn_src_room.addActionListener(e -> {
            ArrayList<Object[]> filteredRoomList = this.roomManager.filterRooms(
                    this.fld_src_hotel_name.getText(), this.fld_src_city.getText(), this.fld_src_strt_date.getText(),
                    this.fld_src_fnsh_date.getText(), this.fld_src_adult_num.getText(),
                    this.fld_src_child_num.getText());
            //Değerlendirme formu 16
            loadRoomTable(filteredRoomList);


        });

        //button clear
        btn_src_clear.addActionListener(e -> {
            this.fld_src_hotel_name.setText("");
            this.fld_src_city.setText("");
            this.fld_src_strt_date.setText("");
            this.fld_src_fnsh_date.setText("");
            this.fld_src_adult_num.setText("");
            this.fld_src_child_num.setText("");
        });
    }

    public void loadReservationComponent() {
        //selected row in table
        tableRowSelect(tbl_reservation);
        this.reservation_menu = new JPopupMenu();
        //Değerlendirme formu 21
        reservation_menu.add("Rezervayonu Düzenle").addActionListener(e -> {
            int reservationId = getTableSelectedRow(tbl_reservation, 0);
            Reservation selectedReservation = this.reservationManager.getById(reservationId);
            int selectedRoomId = selectedReservation.getReservationRoomId();

            //new reservation window for reorganizaiton
            ReservationView reservationView = new ReservationView(selectedReservation,
                    selectedRoomId,
                    selectedReservation.getCheckInDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                    selectedReservation.getCheckOutDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                    selectedReservation.getNumOfAdult(),
                    selectedReservation.getNumOfChild());
            EmployeeView employeeView = this;
            reservationView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadRoomTable(employeeView.roomManager.filterRooms());
                    loadReservationTable();
                }
            });
        });

        //Değerlendirme formu 22
        //delete reservation
        reservation_menu.add("Rezervasyonu Sil").addActionListener(e -> {
            if (Helper.confirm("sure")) {
                int selectedReservationId = this.getTableSelectedRow(tbl_reservation, 0);
                int selectedRoomId = this.getTableSelectedRow(tbl_reservation, 1);
                this.reservationManager.delete(selectedReservationId);
                Room room = this.roomManager.getById(selectedRoomId);
                //stock + 1
                room.setStock(room.getStock() + 1);
                //Değerlendirme formu 23
                if (this.roomManager.stockUpdate(room)) {
                    Helper.showMsg("done");
                    //Değerlendirme formu 24
                    loadRoomTable(this.roomManager.filterRooms());
                    loadReservationTable();
                } else {
                    //Değerlendirme formu 25
                    Helper.showMsg("error");
                }
            }
        });
        this.tbl_reservation.setComponentPopupMenu(reservation_menu);
    }

    public void loadReservationTable() {
        this.col_reservation = new Object[]{"ID", "Room Id", "Giriş Tarihi", "Çıkış Tarihi", "Toplam Fiyat", "Misafir Sayısı", "Misafir İsmi", "Misafir Id No", "Mail Adresi", "Misafir Tel No"};
        ArrayList<Object[]> reservationList = this.reservationManager.getReservationRowListForTable(col_reservation.length);
        this.createTable(this.tmdl_reservation, this.tbl_reservation, col_reservation, reservationList);
    }


    public void loadRoomComponent() {
        //selected row int table
        tableRowSelect(tbl_room);
        this.room_menu = new JPopupMenu();
        this.room_menu.add("Rezervasyon Ekle").addActionListener(e -> {
            if (this.fld_src_hotel_name.getText().isEmpty() || this.fld_src_strt_date.getText().isEmpty() || this.fld_src_fnsh_date.getText().isEmpty() || this.fld_src_adult_num.getText().isEmpty()) {
                Helper.showMsg("fill");
            } else {
                int numOfAdult = Integer.parseInt(this.fld_src_adult_num.getText());
                int numOfChild = Integer.parseInt(this.fld_src_child_num.getText());
                String checkInDate = this.fld_src_strt_date.getText();
                String checkOutDate = this.fld_src_fnsh_date.getText();
                int selectRoomId = this.getTableSelectedRow(tbl_room, 0);
                EmployeeView employeeView = this;
                ReservationView reservationView = new ReservationView(null, selectRoomId, checkInDate, checkOutDate, numOfAdult, numOfChild);
                reservationView.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        loadRoomTable(employeeView.roomManager.filterRooms());
                        loadReservationTable();
                    }
                });
            }
        });
        this.tbl_room.setComponentPopupMenu(room_menu);

    }

    public void loadRoomTable(ArrayList<Object[]> roomList) {
        this.col_room = new Object[]{"Oda ID", "Oda Otel ID", "Pension Türü", "Oda Tipi", "Stok",
                "Yetişkin Fiyat", "Çocuk Fiyat", "Yatak Sayısı", "Metrekare", "Tv", "Minibar",
                "Oyun Konsolu", "Kasa", "Projeksiyon"};
        createTable(this.tmdl_room, this.tbl_room, col_room, roomList);
    }

    private void loadHotelTable() {
        this.col_hotel = new Object[]{"Hotel ID", "Hotel Adı", "Adres", "Email", "Telefon", "Star", "Otopark", "Wifi", "Yüzme Havuzu", "Spor Salonu", "Konsiyerj", "Spa", "Oda Servisi"};
        ArrayList<Object[]> hotelList = this.hotelManager.getForTable(col_hotel.length, this.hotelManager.findAll());
        this.createTable(this.tmdl_hotel, this.tbl_hotel, col_hotel, hotelList);
    }

    private void loadHotelComponent() {
        tableRowSelect(tbl_hotel);

        this.hotel_menu = new JPopupMenu();
        //add season
        this.hotel_menu.add("Sezon Ekle").addActionListener(e -> {
            //Değerlendirme formu 11
            int selectHotelId = this.getTableSelectedRow(tbl_hotel, 0);
            SeasonView seasonView = new SeasonView(selectHotelId);
            seasonView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadSeasonTable();
                }
            });
        });
        this.hotel_menu.add("Pansiyon Ekle").addActionListener(e -> {
            //Değerlendirme formu 12
            int selectHotelId = this.getTableSelectedRow(tbl_hotel, 0);
            PensionView pensionView = new PensionView(selectHotelId);
            pensionView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadPensionTable();
                }
            });
        });
        this.tbl_hotel.setComponentPopupMenu(hotel_menu);
    }

    public void loadPensionTable() {
        EmployeeView employeeView = this;
        tbl_hotel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int selected_row = tbl_hotel.rowAtPoint(e.getPoint());
                tbl_hotel.setRowSelectionInterval(selected_row, selected_row);

                int selectedHotelId = Integer.parseInt(tbl_hotel.getValueAt(tbl_hotel.getSelectedRow(), 0).toString());

                Object[] col_pension = {"Pansiyon ID", "Hotel ID", "Pansiyon Türü"};
                ArrayList<Object[]> pensionList = employeeView.pensionManager.getForTable(selectedHotelId);
                employeeView.createTable(employeeView.tmdl_pension, employeeView.tbl_pension, col_pension, pensionList);

            }
        });
    }

    public void loadSeasonTable() {
        EmployeeView employeeView = this;
        tbl_hotel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int selected_row = tbl_hotel.rowAtPoint(e.getPoint());
                tbl_hotel.setRowSelectionInterval(selected_row, selected_row);

                int selectedSeasonId = Integer.parseInt(tbl_hotel.getValueAt(tbl_hotel.getSelectedRow(), 0).toString());

                Object[] col_season = {"Sezon ID", "Hotel ID", "Sezon Başlangıç Tarihi", "Sezon Bitiş Tarihi"};
                ArrayList<Object[]> seasonList = employeeView.seasonManager.getForTable(selectedSeasonId);
                employeeView.createTable(employeeView.tmdl_season, employeeView.tbl_season, col_season, seasonList);
            }
        });
    }


}
