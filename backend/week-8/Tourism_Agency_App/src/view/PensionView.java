package view;

import business.PensionManager;
import core.Helper;
import dao.PensionDao;
import entity.Pension;
import entity.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PensionView extends Layout {
    private JPanel contanier;
    private JLabel fld_hotel_id;
    private JComboBox cmb_pension_type;
    private JButton btn_save_pension_type;
    private Pension pension;
    private PensionManager pensionManager;

    public PensionView(int hotelId) {
        this.add(contanier);
        this.guiInitialise(400, 500);
        this.pension = new Pension();
        this.pensionManager = new PensionManager();
        this.fld_hotel_id.setText("Otel Id: " + hotelId);

        this.cmb_pension_type.setModel(new DefaultComboBoxModel<>(Pension.Type.values()));

        btn_save_pension_type.addActionListener(e -> {
            this.pension.setPensionHotelId(hotelId);
            this.pension.setType((Pension.Type) cmb_pension_type.getSelectedItem());
            boolean result;
            result = this.pensionManager.save(this.pension);

            if(result){
                Helper.showMsg("done");

            }else{
                Helper.showMsg("error");
            }

        });
    }


}

