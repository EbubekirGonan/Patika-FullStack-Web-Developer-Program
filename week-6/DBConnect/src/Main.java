import java.sql.*;

public class Main {
    //declare url, username and password
    public static final String DB_URL = "jdbc:postgresql://localhost/employees";
    public static final String DB_USERNAME = "postgres";
    public static final String DB_PASSWORD = "postgres";

    public static void main(String[] args) {
        //an object from connection class
        Connection conn = null;
        String sql = "SELECT * FROM employees";
        try {
            //get connection with an object from connection class
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            //declare new statement
            Statement st = conn.createStatement();
            //transfer data to ResultSet
            ResultSet data = st.executeQuery(sql);
            //while loop for print line by line
            while(data.next()){
                System.out.println("ID: " + data.getInt("id"));
                System.out.println("Name: " + data.getString("name"));
                System.out.println("Position: " + data.getString("position"));
                System.out.println("Salary: " + data.getInt("salary"));
                System.out.println("*****************************");
            }

        } catch (SQLException ex) {

            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}