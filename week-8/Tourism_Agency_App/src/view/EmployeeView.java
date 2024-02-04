package view;

import business.HotelManager;
import business.PensionManager;
import business.RoomManager;
import business.SeasonManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;

public class EmployeeView extends Layout{

    private JPanel container;
    private JTabbedPane fld;
    private JTable tbl_hotel;

    private JTable tbl_pension;
    private JTable tbl_season;
    private JButton btn_add_hotel;
    private JTable tbl_room;
    private JButton button1;
    private DefaultTableModel tmdl_hotel = new DefaultTableModel();
    private DefaultTableModel tmdl_room = new DefaultTableModel();
    private HotelManager hotelManager;
    private JPopupMenu hotel_menu;
    private DefaultTableModel tmdl_pension = new DefaultTableModel();
    private DefaultTableModel tmdl_season = new DefaultTableModel();
    private PensionManager pensionManager;
    private SeasonManager seasonManager;
    private RoomManager roomManager;
    private Object[] col_hotel;
    private Object[] col_room;

    public EmployeeView() {
        this.add(container);
        this.guiInitialise(1000, 800);
        this.hotelManager = new HotelManager();
        this.pensionManager = new PensionManager();
        this.seasonManager = new SeasonManager();
        this.roomManager = new RoomManager();

        loadHotelTable(null);
        loadHotelComponent();

        loadPensionTable();

        loadSeasonTable();


        loadRoomTable();
        //loadRoomComponent();

        //loadReservationTable();
        //loadReservationComponent();


        btn_add_hotel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HotelView hotelView = new HotelView();

                hotelView.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        loadHotelTable(null);
                        loadHotelComponent();

                    }
                });
            }
        });
    }

    public void loadRoomTable(){
        this.col_room = new Object[]{"Oda ID", "Oda Otel ID", "Pension Türü", "Oda Tipi", "Stok", "Yetişkin Fiyat", "Çocuk Fiyat", "Yatak Sayısı", "Metrekare", "Tv", "Minibar", "Oyun Konsolu", "Kasa", "Projeskiyon"};
        ArrayList<Object[]> roomList = this.roomManager.getForTable();
        createTable(this.tmdl_room, this.tbl_room, col_room, roomList);

    }

    private void loadHotelTable(ArrayList<Object[]> hotelList){
        this.col_hotel = new Object[]{"Hotel ID", "Hotel Adı", "Adres", "Email", "Telefon", "Star"};
        if(hotelList == null){
            hotelList = this.hotelManager.getForTable(col_hotel.length, this.hotelManager.findAll());
        }
        this.createTable(this.tmdl_hotel, this.tbl_hotel, col_hotel, hotelList);
    }

    private void loadHotelComponent(){
        tableRowSelect(tbl_hotel);

        this.hotel_menu = new JPopupMenu();
        this.hotel_menu.add("Sezon Ekle").addActionListener(e -> {
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

    public void loadPensionTable (){
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

    public void loadSeasonTable(){
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
