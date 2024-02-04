package view;

import business.UserManager;
import core.Helper;
import entity.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class AdminView extends Layout {
    private JPanel container;
    private JLabel lbl_wellcome;
    private JTabbedPane tabbedPane1;
    private JTable tbl_user;
    private JTextField fld_username;
    private JTextField fld_password;
    private JComboBox cmb_user_role;
    private JButton btn_user_save;
    private JPopupMenu user_menu;
    private UserManager userManager;

    private User user;
    private DefaultTableModel tmdl_user = new DefaultTableModel();


    public AdminView(User logedInUser) {
        this.userManager = new UserManager();
        this.user = logedInUser;
        this.add(container);
        this.guiInitialise(700,500);
        this.lbl_wellcome.setText("Hoşgeldiniz: " + this.user.getUsername());
        cmb_user_role.setModel(new DefaultComboBoxModel(User.UserRole.values()));

        loadUserTable();
        loadUserComponent();


        btn_user_save.addActionListener(e -> {

            this.user.setUsername(fld_username.getText());
            this.user.setPassword(fld_password.getText());
            this.user.setRole((User.UserRole) cmb_user_role.getSelectedItem());
            JTextField[] addedUser = {fld_username, fld_password};
            if (!Helper.isFieldListEmpty(addedUser)){
                this.userManager.save(this.user);
                Helper.showMsg("done");
                fld_username.setText("");
                fld_password.setText("");
                cmb_user_role.setSelectedItem("");
                loadUserTable();
            }else{
                Helper.showMsg("fill");
            }

        });
    }

    private void loadUserTable(){
        Object[] col_user = {"Kullanıcı ID", "Kullanıcı Adı", "Parola", "Rol"};
        ArrayList<Object[]> userList = this.userManager.getForTable(col_user.length);
        this.createTable(this.tmdl_user, this.tbl_user, col_user, userList);
    }

    private void loadUserComponent() {
        tableRowSelect(tbl_user);

        this.user_menu = new JPopupMenu();
        this.user_menu.add("Yeni").addActionListener(e -> {
            UserView userView = new UserView(null);
            userView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadUserTable();
                }
            });
        });
        this.user_menu.add("Güncelle").addActionListener(e -> {
            int selectUserId = this.getTableSelectedRow(tbl_user, 0);
            UserView userView = new UserView(userManager.getById(selectUserId));
            userView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadUserTable();
                }
            });
        });
        this.user_menu.add("Sil").addActionListener(e -> {
            if (Helper.confirm("sure")) {
                int selectUserId = this.getTableSelectedRow(tbl_user, 0);
                if (this.userManager.delete(selectUserId)) {
                    Helper.showMsg("done");
                    loadUserTable();

                } else {
                    Helper.showMsg("error");
                }

            }
        });
        this.tbl_user.setComponentPopupMenu(user_menu);
    }
}
