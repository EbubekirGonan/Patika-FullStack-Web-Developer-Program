package view;

import business.HotelManager;
import core.Helper;
import entity.Hotel;

import javax.swing.*;

public class HotelView extends Layout {
    private JPanel container;
    private JTextField fld_hotel_name;
    private JTextField fld_hotel_address;
    private JTextField fld_hotel_email;
    private JTextField fld_hotel_phone;
    private JComboBox cmb_hotel_star;
    private JRadioButton freeWifiRadioButton;
    private JRadioButton freeParkingRadioButton;
    private JRadioButton swimmingPoolRadioButton;
    private JRadioButton fitnessCenterRadioButton;
    private JRadioButton conciergeRadioButton;
    private JRadioButton spaRadioButton;
    private JRadioButton roomServiceRadioButton;
    private JButton btn_save_hotel;
    private Hotel hotel;
    private HotelManager hotelManager;

    public HotelView() {
        this.add(container);
        this.guiInitialise(500, 500);
        this.hotel = new Hotel();
        this.hotelManager = new HotelManager();

        btn_save_hotel.addActionListener(e -> {
            if (Helper.isFieldEmpty(this.fld_hotel_name)) {
                Helper.showMsg("fill");
            } else {
                boolean result;
                hotel.setName(fld_hotel_name.getText());
                hotel.setAddres(fld_hotel_address.getText());
                hotel.setEmail(fld_hotel_email.getText());
                hotel.setPhone(fld_hotel_phone.getText());
                hotel.setStar((String) cmb_hotel_star.getSelectedItem());
                hotel.setHasFreeWifi(freeWifiRadioButton.isSelected());
                hotel.setHasFreeParking(freeParkingRadioButton.isSelected());
                hotel.setHasPool(swimmingPoolRadioButton.isSelected());
                hotel.setHasFitnessCenter(fitnessCenterRadioButton.isSelected());
                hotel.setHasConcierge(conciergeRadioButton.isSelected());
                hotel.setHasSpa(spaRadioButton.isSelected());
                hotel.setHasRoomService(roomServiceRadioButton.isSelected());
                result = hotelManager.save(this.hotel);
                dispose();
                if (result) {
                    Helper.showMsg("done");
                } else {
                    Helper.showMsg("error");
                }
            }
        });


    }
}
