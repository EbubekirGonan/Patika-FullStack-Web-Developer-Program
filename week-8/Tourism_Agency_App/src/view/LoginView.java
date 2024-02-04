package view;

import business.UserManager;
import core.Helper;
import entity.User;

import javax.swing.*;

public class LoginView extends Layout{
    private JPanel container;
    private JPanel w_top;
    private JTextField fld_username;
    private JTextField fld_password;
    private JButton btn_login;

    private final UserManager userManager;

    public LoginView(){
        this.userManager = new UserManager();
        this.add(container);
        this.guiInitialise(400,400);

        btn_login.addActionListener(e -> {
            JTextField[] checkFieldList = {this.fld_username, this.fld_password};
            if(Helper.isFieldListEmpty(checkFieldList)){
                Helper.showMsg("fill");
            } else {
                User loginUser = this.userManager.findByLogin(this.fld_username.getText(), this.fld_password.getText());
                if(loginUser == null){
                    Helper.showMsg("notFound");
                }else {
                    if(loginUser.getRole() == User.UserRole.ADMIN) {
                        AdminView adminView = new AdminView(loginUser);
                    }else if(loginUser.getRole() == User.UserRole.EMPLOYEE){
                        EmployeeView employeeView = new EmployeeView();
                    }
                    dispose();
                }
            }

        });
    }


}
