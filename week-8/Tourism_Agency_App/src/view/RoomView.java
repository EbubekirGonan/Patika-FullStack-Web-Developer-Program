package view;

import business.HotelManager;
import business.PensionManager;
import business.RoomManager;
import business.SeasonManager;
import core.ComboItem;
import core.Helper;
import entity.Hotel;
import entity.Pension;
import entity.Room;
import entity.Season;

import javax.swing.*;

public class RoomView extends Layout {
    private JPanel contanier;
    private JComboBox cmb_hotel;
    private JComboBox cmb_pension;
    private JComboBox cmb_season;
    private JComboBox cmb_room_type;
    private JTextField fld_stock;
    private JTextField fld_adult_price;
    private JTextField fld_child_price;
    private JTextField fld_bed_count;
    private JTextField fld_area;
    private JRadioButton rdbtn_tv;
    private JRadioButton rdbtn_minibar;
    private JRadioButton rdbtn_game_console;
    private JRadioButton rdbtn_case;
    private JRadioButton rdbtn_projection;
    private JButton btn_save_room;
    private Room room;
    private RoomManager roomManager;
    private HotelManager hotelManager;
    private PensionManager pensionManager;
    private SeasonManager seasonManager;
    private Hotel hotel = new Hotel();

    public RoomView() {
        this.add(contanier);
        this.guiInitialise(700, 500);
        this.room = new Room();
        this.roomManager = new RoomManager();
        this.hotelManager = new HotelManager();
        this.pensionManager = new PensionManager();
        this.seasonManager = new SeasonManager();



        for (Hotel hotel : this.hotelManager.findAll()) {
            this.cmb_hotel.addItem(hotel.getComboItem());
        }

        cmb_hotel.addActionListener(e -> {
            this.cmb_pension.removeAllItems();
            this.cmb_season.removeAllItems();
            ComboItem selectedHotel = (ComboItem) cmb_hotel.getSelectedItem();
            for (Pension pension : this.pensionManager.findPensionByHotelID(selectedHotel.getKey())) {
                cmb_pension.addItem(pension.getComboItem());
            }
            for (Season season : this.seasonManager.findSeasonByHotelID(selectedHotel.getKey())) {
                cmb_season.addItem(season.getComboItem());
            }
        });


        this.cmb_room_type.setModel(new DefaultComboBoxModel(Room.Type.values()));

        btn_save_room.addActionListener(e -> {
            ComboItem selectedHotel = (ComboItem) cmb_hotel.getSelectedItem();
            this.room.setHotelId(selectedHotel.getKey());
            ComboItem selectedPension = (ComboItem) cmb_pension.getSelectedItem();
            this.room.setPensionType(Pension.Type.values()[selectedPension.getKey()]);
            this.room.setType((Room.Type) this.cmb_room_type.getSelectedItem());
            ComboItem selectedSeason = (ComboItem) cmb_season.getSelectedItem();
            this.room.setSeasonId(selectedSeason.getKey());
            this.room.setStock(Integer.parseInt(this.fld_stock.getText()));
            this.room.setAdultPrice(Integer.parseInt(this.fld_adult_price.getText()));
            this.room.setChildPrice(Integer.parseInt(this.fld_child_price.getText()));
            this.room.setBedCount(Integer.parseInt(this.fld_bed_count.getText()));
            this.room.setArea(Integer.parseInt(this.fld_area.getText()));
            this.room.setHasTV(this.rdbtn_tv.isSelected());
            this.room.setHasGameConsole(this.rdbtn_game_console.isSelected());
            this.room.setHasMiniBar(this.rdbtn_case.isSelected());
            this.room.setHasProjector(this.rdbtn_projection.isSelected());

            if(this.roomManager.save(this.room)){
                Helper.showMsg("done");
                dispose();
            }else {
                Helper.showMsg("error");
            }
        });

    }

}
