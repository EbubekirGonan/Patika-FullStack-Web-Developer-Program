import core.Db;
import core.Helper;
import view.AdminView;
import view.EmployeeView;
import view.LoginView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {

        //Where it all begins
        Helper.setTheme();
        LoginView loginView = new LoginView();


    }
}