package view;

import business.SeasonManager;
import core.Helper;
import entity.Season;

import javax.swing.*;

public class SeasonView extends Layout{
    private JPanel container;
    private JLabel fld_hotel_id;
    private JTextField fld_strt_date;
    private JTextField fld_fnsh_date;
    private JButton btn_add_season;
    private Season season;
    private SeasonManager seasonManager;

    public SeasonView(int hotelId) {
        this.add(container);
        this.guiInitialise(300, 400);
        this.fld_hotel_id.setText("Hotel id: " + hotelId);
        this.season = new Season();
        this.seasonManager = new SeasonManager();

        btn_add_season.addActionListener(e -> {
            if(Helper.isFieldListEmpty(new JTextField[]{this.fld_strt_date, this.fld_fnsh_date})){
                Helper.showMsg("fill");
            }else{
                boolean result;
                this.season.setStrtDate(fld_strt_date.getText());
                this.season.setFnshDate(fld_fnsh_date.getText());
                this.season.setHotelId(hotelId);
                result = this.seasonManager.save(this.season);
                if(result){
                    Helper.showMsg("done");
                }else {
                    Helper.showMsg("error");
                }
            }


        });

    }
}
