package view;

import business.UserManager;
import core.Helper;
import entity.User;

import javax.swing.*;

public class UserView extends Layout{
    private JPanel container;
    private JTextField fld_username;
    private JTextField fld_password;
    private JComboBox cmb_user_role;
    private JButton btn_user_save;
    private User user;
    private UserManager userManager;

    public UserView(User user) {
        this.add(container);
        guiInitialise(300,400);
        this.user = user;
        this.userManager = new UserManager();
        cmb_user_role.setModel(new DefaultComboBoxModel(User.UserRole.values()));

        if (user != null) {
            fld_username.setText(user.getUsername());
            fld_password.setText(user.getPassword());
            cmb_user_role.getModel().setSelectedItem(user.getRole());
            //cmb_user_role.setModel(new DefaultComboBoxModel(userRoles));
        }

        btn_user_save.addActionListener(e -> {
            if (Helper.isFieldEmpty(this.fld_username)) {
                Helper.showMsg("fill");
            } else {
                boolean result;
                if(this.user == null){
                    result = this.userManager.save(new User(fld_username.getText(), fld_password.getText(), (User.UserRole) cmb_user_role.getSelectedItem()));

                }else {
                    this.user.setUsername(fld_username.getText());
                    this.user.setPassword(fld_password.getText());
                    this.user.setRole((User.UserRole) cmb_user_role.getSelectedItem());
                    result = this.userManager.update(this.user);
                }
                if (result) {
                    Helper.showMsg("done");
                } else {
                    Helper.showMsg("error");
                }
            }
        });

    }
}


